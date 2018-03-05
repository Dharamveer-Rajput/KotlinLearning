package com.kotlinlearning.keditbysteps.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by dharamveer on 5/3/18.
 */
interface RedditApi {

    @GET("/top.json")
    fun getTop(@Query("after") after : String,
               @Query("limit") limit: String): Call<RedditNewsResponse>
}