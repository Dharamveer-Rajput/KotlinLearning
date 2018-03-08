package com.kotlinlearning.mvparchitecture.base

import com.kotlinlearning.mvparchitecture.injection.component.DaggerPresenterInjector
import com.kotlinlearning.mvparchitecture.injection.component.PresenterInjector
import com.kotlinlearning.mvparchitecture.injection.module.ContextModule
import com.kotlinlearning.mvparchitecture.injection.module.NetworkModule
import com.kotlinlearning.mvparchitecture.ui.post.PostPresenter

/**
 * Created by dharamveer on 8/3/18.
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }


    /**
     * this method may be called when the presenter view is created
     */

    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */

    open fun onViewDestroyed(){}


    /**
     * Injects the required dependencies
     */

    private fun inject(){

        when(this){
            is PostPresenter -> injector.inject(this)
        }
    }
}