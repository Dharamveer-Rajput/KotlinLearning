package com.kotlinlearning.mvparchitecture.network

import com.kotlinlearning.mvparchitecture.model.Post
import retrofit2.http.GET
import io.reactivex.Observable
import java.util.*

/**
 * Created by dharamveer on 8/3/18.
 */


/**
 * The interface which provides methods to get result of webservices
 */
interface PostApi {

    /**
     * Get the list of the pots from the API
     */

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}