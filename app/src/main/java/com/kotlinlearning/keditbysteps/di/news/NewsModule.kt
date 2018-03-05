package com.kotlinlearning.keditbysteps.di.news

import com.kotlinlearning.keditbysteps.api.NewsAPI
import com.kotlinlearning.keditbysteps.api.NewsRestAPI
import com.kotlinlearning.keditbysteps.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by dharamveer on 5/3/18.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI = NewsRestAPI(redditApi)

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi = retrofit.create(RedditApi::class.java)
}