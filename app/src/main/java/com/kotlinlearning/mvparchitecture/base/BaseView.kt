package com.kotlinlearning.mvparchitecture.base

import android.content.Context

/**
 * Created by dharamveer on 8/3/18.
 */
interface BaseView {

    /**
     * Returns the context in which the application is running.
     * @return the context in which the application is running.
     */

    fun getContext(): Context
}