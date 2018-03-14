package com.kotlinlearning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.kotlin_test_layout2.*

/**
 * Created by dharamveer on 14/3/18.
 */
class KotlinTest2 : AppCompatActivity() {


    var age : Int? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_test_layout2)

        //test()


        val op = Sum()
        println(op.sum(5,3))
        println(op.div(5,3))
    }


    class Sum : Div() {
        fun sum(a: Int, b:Int):Int {
            return a + b
        }
    }

    open class Div {
        fun div(a: Int, b:Int):Int {
            return a / b
        }
    }

    fun test(){
        val x = 5 * 4
        println(x)
    }



    fun helloWorld(view: View) {
        textView.text = "Good morning! Dharamveer"

    }


    fun makeSimpson(view: View){

        val name = nameText.text.toString()

        if(!ageText.text.toString().equals("")){
            age = ageText.text.toString().toInt()

        }


        val job = jobText.text.toString()


        val simpson = Simpson(name,age,job)

        textView.text ="Name: " + simpson.name + " Age: " + simpson.age + " Job: " + simpson.job

    }




}