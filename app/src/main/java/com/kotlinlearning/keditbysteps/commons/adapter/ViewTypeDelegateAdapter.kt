package com.kotlinlearning.keditbysteps.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewParent

/**
 * Created by dharamveer on 5/3/18.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder,item: ViewType)

}