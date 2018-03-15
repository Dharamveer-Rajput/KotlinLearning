package com.kotlinlearning.runnables

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.kotlinlearning.R
import kotlinx.android.synthetic.main.activity_runnable_kotlin.*

class RunnableKotlin : AppCompatActivity() {

    var number : Int = 0
    var handler : Handler = Handler()
    var runnable : Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runnable_kotlin)


    }

    fun start(view: View){

        number = 0

        runnable = object : Runnable {
            override fun run() {
                 textRunnable.text = "Time: " + number
                number++
                textRunnable.text = "Time: " + number
                handler.postDelayed(this,1000)
            }

        }
        handler.post(runnable)
    }

    fun reset(view: View){

        handler.removeCallbacks(runnable)
        number = 0

        textRunnable.text  = "Time: " + number

    }
}
