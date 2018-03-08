package com.kotlinlearning.keditbysteps

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.kotlinlearning.keditbysteps.di.AppModule
import com.kotlinlearning.keditbysteps.di.news.DaggerNewsComponent
import com.kotlinlearning.keditbysteps.di.news.NewsComponent
import dagger.Component
import dagger.internal.DaggerCollections

/**
 * Created by dharamveer on 5/3/18.
 */
class KedditApp : MultiDexApplication() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}