package com.kotlinlearning.keditbysteps.features.news

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlinlearning.R
import com.kotlinlearning.keditbysteps.KedditApp
import com.kotlinlearning.keditbysteps.commons.InfiniteScrollListener
import com.kotlinlearning.keditbysteps.commons.RedditNews
import com.kotlinlearning.keditbysteps.commons.RxBaseFragment
import com.kotlinlearning.keditbysteps.commons.extensions.androidLazy
import com.kotlinlearning.keditbysteps.commons.extensions.inflate
import com.kotlinlearning.keditbysteps.features.news.adapter.NewsAdapter
import com.kotlinlearning.keditbysteps.features.news.adapter.NewsDelegateAdapter
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import kotlinx.android.synthetic.main.news_fragment.*

/**
 * Created by dharamveer on 5/3/18.
 */
class NewsFragment : RxBaseFragment(), NewsDelegateAdapter.onViewSelectedListener{

    override fun onItemSelected(url: String?) {
        if (url.isNullOrEmpty()) {
            Snackbar.make(news_list, "No URL assigned to this news", Snackbar.LENGTH_LONG).show()
        } else {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    companion object {
        private val KEY_REDDIT_NEWS = "redditNews"
    }

    @Inject lateinit var newsManager: NewsManager
    private var redditNews: RedditNews? = null
    private val newsAdapter by androidLazy { NewsAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KedditApp.newsComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        }

        news_list.adapter = newsAdapter

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_REDDIT_NEWS)) {
            redditNews = savedInstanceState.get(KEY_REDDIT_NEWS) as RedditNews
            newsAdapter.clearAndAddNews(redditNews!!.news)
        } else {
            requestNews()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val news = newsAdapter.getNews()
        if (redditNews != null && news.isNotEmpty()) {
            outState.putParcelable(KEY_REDDIT_NEWS, redditNews?.copy(news = news))
        }
    }

    private fun requestNews() {
        /**
         * first time will send empty string for 'after' parameter.
         * Next time we will have redditNews set with the next page to
         * navigate with the 'after' param.
         */
        job = launch(UI) {
            try {
                val retrievedNews = newsManager.getNews(redditNews?.after.orEmpty())
                redditNews = retrievedNews
                newsAdapter.addNews(retrievedNews.news)
            } catch (e: Throwable) {
                if (isVisible) {
                    Snackbar.make(news_list, e.message.orEmpty(), Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY") { requestNews() }
                            .show()
                }
            }
        }
    }
}

