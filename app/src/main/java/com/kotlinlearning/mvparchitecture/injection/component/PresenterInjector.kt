package com.kotlinlearning.mvparchitecture.injection.component

import android.content.Context
import com.kotlinlearning.mvparchitecture.base.BaseView
import com.kotlinlearning.mvparchitecture.injection.module.ContextModule
import com.kotlinlearning.mvparchitecture.injection.module.NetworkModule
import com.kotlinlearning.mvparchitecture.ui.post.PostPresenter
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dharamveer on 8/3/18.
 */

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */

    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }

}