package com.kotlinlearning.keditbysteps.commons

import android.support.v4.app.Fragment
import kotlinx.coroutines.experimental.Job

/**
 * Created by dharamveer on 5/3/18.
 */
open class RxBaseFragment : Fragment() {

    protected var job: Job? = null

    override fun onResume() {
        super.onResume()
        job = null
    }

    override fun onPause() {
        super.onPause()
        job?.cancel()
        job = null
    }
}