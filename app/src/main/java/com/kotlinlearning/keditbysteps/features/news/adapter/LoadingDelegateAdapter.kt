package com.kotlinlearning.keditbysteps.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kotlinlearning.R
import com.kotlinlearning.keditbysteps.commons.adapter.ViewType
import com.kotlinlearning.keditbysteps.commons.adapter.ViewTypeDelegateAdapter
import com.kotlinlearning.keditbysteps.commons.extensions.inflate

/**
 * Created by dharamveer on 5/3/18.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {



    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))


}