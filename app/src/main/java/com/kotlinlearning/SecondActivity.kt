package com.kotlinlearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.kotlin_cal_layout.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent;
        val received: String = intent.getStringExtra("input")

        textSec.text = received

    }


    fun goBack(view: View){

        val intent = Intent(applicationContext,KotlinTest::class.java)
        startActivity(intent)
    }

}
