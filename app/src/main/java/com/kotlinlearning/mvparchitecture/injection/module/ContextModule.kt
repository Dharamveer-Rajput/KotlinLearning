package com.kotlinlearning.mvparchitecture.injection.module

import android.app.Application
import android.content.Context
import com.kotlinlearning.mvparchitecture.base.BaseView
import dagger.Module
import dagger.Provides

/**
 * Created by dharamveer on 8/3/18.
 */

@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object ContextModule {

    /**
     * Provides the context
     * @param baseView the BaseView used to provides the context
     * @return the context to be provided
     */

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context{
        return baseView.getContext()
    }

    /**
     * Provides the application context
     * @param context Context in which the application is running
     * @return the MyApplication context to be provided
     */

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}