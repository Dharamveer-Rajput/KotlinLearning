package com.kotlinlearning.keditbysteps.features.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import com.kotlinlearning.keditbysteps.commons.RedditNewsItem
import com.kotlinlearning.keditbysteps.commons.adapter.AdapterConstants
import com.kotlinlearning.keditbysteps.commons.adapter.ViewType
import com.kotlinlearning.keditbysteps.commons.adapter.ViewTypeDelegateAdapter
import java.util.*

/**
 * Created by dharamveer on 5/3/18.
 */
class NewsAdapter(listener: NewsDelegateAdapter.onViewSelectedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var items: ArrayList<ViewType>
    private var delegateAdapter = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }



    init {
        delegateAdapter.put(AdapterConstants.LOADING,LoadingDelegateAdapter())
        delegateAdapter.put(AdapterConstants.NEWS, NewsDelegateAdapter(listener))
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAdapter.get(viewType).onCreateViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapter.get(getItemViewType(position)).onBindViewHolder(holder,items[position])
    }


    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun addNews(news: List<RedditNewsItem>){
        //first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition,items.size + 1)  /* plus loading item */

    }

    fun clearAndAddNews(news: List<RedditNewsItem>) {

        items.clear()
        notifyItemRangeRemoved(0,getLastPosition())

        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0,items.size)
    }

    fun getNews(): List<RedditNewsItem>  =
            items
                    .filter { it.getViewType() == AdapterConstants.NEWS }
                    .map { it as RedditNewsItem }


    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex


}