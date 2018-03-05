package com.kotlinlearning.keditbysteps.di.news

import android.app.Fragment
import com.kotlinlearning.keditbysteps.di.AppModule
import com.kotlinlearning.keditbysteps.di.NetworkModule
import com.kotlinlearning.keditbysteps.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dharamveer on 5/3/18.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class
))

interface NewsComponent {

    fun inject(newsFragment: NewsFragment)
}