package com.kotlinlearning.timers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.kotlinlearning.R
import kotlinx.android.synthetic.main.activity_kotlin_timers.*

class KotlinTimers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_timers)


        object : CountDownTimer(10000,1000) {
            override fun onFinish() {

                Toast.makeText(applicationContext,"Time's OFF",Toast.LENGTH_LONG).show()
                textViewTimer.text = "Left: 0"
            }

            override fun onTick(p0: Long) {

                textViewTimer.text = "Left: " + p0 / 1000

            }

        }.start()



    }
}
