package com.kotlinlearning.kotlin_calculator

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlinlearning.R
import kotlinx.android.synthetic.main.kotlin_cal_layout.*
import kotlinx.android.synthetic.main.kotlin_test_layout2.*

/**
 * Created by dharamveer on 14/3/18.
 */

class KotlinCalculator : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_cal_layout)

    }


    fun sum(view: View){

        val a = number1.text.toString().toInt()
        val b = number2.text.toString().toInt()

        val result = a + b

        textView2.text = "Result: $result"

    }

    fun sub(view: View){
        val a = number1.text.toString().toInt()
        val b = number2.text.toString().toInt()

        val result = a - b

        textView2.text = "Result: $result"
    }

    fun multiply(view: View){
        val a = number1.text.toString().toInt()
        val b = number2.text.toString().toInt()

        val result = a * b

        textView2.text = "Result: $result"
    }

    fun div(view: View){
        val a = number1.text.toString().toInt()
        val b = number2.text.toString().toInt()

        val result = a / b

        textView2.text = "Result: $result"
    }

}