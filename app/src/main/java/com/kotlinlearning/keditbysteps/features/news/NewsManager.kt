package com.kotlinlearning.keditbysteps.features.news

import com.kotlinlearning.keditbysteps.api.NewsAPI
import com.kotlinlearning.keditbysteps.api.RedditNewsResponse
import com.kotlinlearning.keditbysteps.commons.RedditNews
import com.kotlinlearning.keditbysteps.commons.RedditNewsItem
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResult
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    /**
     *
     * Returns Reddit News paginated by the given limit.
     *
     * @param after indicates the next page to navigate.
     * @param limit the number of news to request.
     */
    suspend fun getNews(after: String, limit: String = "10"): RedditNews {
        val result = api.getNews(after, limit).awaitResult()
        return when (result) {
            is Result.Ok -> process(result.value)
            is Result.Error -> throw Throwable("HTTP error: ${result.response.message()}")
            is Result.Exception -> throw result.exception
            else -> {
                throw Throwable("Something went wrong, please try again later.")
            }
        }
    }

    private fun process(response: RedditNewsResponse): RedditNews {
        val dataResponse = response.data
        val news = dataResponse.children.map {
            val item = it.data
            RedditNewsItem(item.author, item.title, item.num_comments,
                    item.created, item.thumbnail, item.url)
        }
        return RedditNews(
                dataResponse.after.orEmpty(),
                dataResponse.before.orEmpty(),
                news)
    }
}