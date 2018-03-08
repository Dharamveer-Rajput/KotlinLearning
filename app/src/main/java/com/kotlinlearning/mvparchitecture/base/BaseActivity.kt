package com.kotlinlearning.mvparchitecture.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by dharamveer on 8/3/18.
 */
abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {

    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = instantiatePresenter()

    }


    /**
     * Instantiates the presenter the Activity is based on.
     * */

    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }
}