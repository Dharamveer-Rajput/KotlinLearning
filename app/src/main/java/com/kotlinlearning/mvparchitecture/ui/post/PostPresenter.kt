package com.kotlinlearning.mvparchitecture.ui.post

import com.kotlinlearning.R
import com.kotlinlearning.mvparchitecture.base.BasePresenter
import com.kotlinlearning.mvparchitecture.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by dharamveer on 8/3/18.
 */

/**
 * The Presenter that will present the Post view.
 * @param postView the Post view to be presented by the presenter
 * @property postApi the API interface implementation
 * @property subscription the subscription to the API call
 */


class PostPresenter(postView: PostView) : BasePresenter<PostView>(postView) {

    @Inject
    lateinit var postApi: PostApi

    private var subscription: Disposable? = null


    override fun onViewCreated() {
        loadPosts()
    }


    /**
     * Loads the posts from the API and presents them in the view when retrieved, or showss error if
     * any.
     */


    fun loadPosts(){
        view.showLoading()
        subscription = postApi
                .getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { postList -> view.updatePosts(postList)},
                        {view.showError(R.string.unknown_error)}
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }


}