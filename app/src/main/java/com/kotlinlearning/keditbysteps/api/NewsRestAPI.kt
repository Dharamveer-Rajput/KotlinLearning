package com.kotlinlearning.keditbysteps.api

import retrofit2.Call
import javax.inject.Inject

/**
 * Created by dharamveer on 5/3/18.
 */
class NewsRestAPI @Inject constructor(private val redditApi: RedditApi) : NewsAPI {


    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }


}