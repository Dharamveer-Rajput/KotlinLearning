package com.kotlinlearning.keditbysteps.di

import android.app.Application
import android.content.Context
import com.kotlinlearning.keditbysteps.KedditApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dharamveer on 5/3/18.
 */
@Module
class AppModule(val app: KedditApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app
}