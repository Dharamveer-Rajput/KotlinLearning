package com.kotlinlearning.keditbysteps.api

import retrofit2.Call

/**
 * Created by dharamveer on 5/3/18.
 */
interface NewsAPI {

    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}