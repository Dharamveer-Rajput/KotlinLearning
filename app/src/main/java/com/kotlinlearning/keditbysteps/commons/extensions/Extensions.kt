@file:JvmName("ExtensionsUtils")


package com.kotlinlearning.keditbysteps.commons.extensions

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kotlinlearning.R
import com.squareup.picasso.Picasso

/**
 * Created by dharamveer on 5/3/18.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {

    return LayoutInflater.from(context).inflate(layoutId,this,attachToRoot)
}


fun ImageView.loadImg(imageUrl: String){

    if(TextUtils.isEmpty(imageUrl)){
        Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
    }
    else
    {
        Picasso.with(context).load(imageUrl).into(this)
    }
}

fun <T> androidLazy(initializer: () -> T) : Lazy<T> = lazy(LazyThreadSafetyMode.NONE,initializer)
