package com.kotlinlearning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.kotlin_test_layout.*
import java.util.*


class KotlinTest : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_test_layout)


        //variables


        //Integers

        var x = 5
        val y = 4

        x = 6

        println(x * y)

        var age = 20

        val result = age * 5 / 4

       // println(result)


        //Only interger

        val myInteger : Int = 5
        val double : Double = 5.0


        //Double & Float

        val pi = 3.14

        val myAge = 26.0

        val myResult = myAge * 5/4

      //  println(myResult)


        //String

        val  names = "dharam"
        val  surname = "rajput"

        val fullname  = names+ " " +surname
      //  println(fullname)


        val myName : String  = "Dharam"
        //boolean

        var isAlive : Boolean = true

        isAlive = false



        //Arrays

        val myArray = arrayOfNulls<String>(4)

        myArray[0] = "Dharam"
        myArray[1] = "Rajput"
        myArray[2] = "Kirk"
        myArray[3] = "Rob"

     //   println(myArray[2])



        val myNumberArray = intArrayOf(10,20,30,40,50,60)
        println(myNumberArray.size)
        myNumberArray.set(2,25)
     //   println(myNumberArray[2])



        //List
        val myMusician = ArrayList<String>()

        myMusician.add("Dharam")
        myMusician.add("Rajput")

     //   println(myMusician)


        myMusician.add(1,"Kirk")
        println(myMusician)

        myMusician.removeAt(1)
     //   println(myMusician)



        //Sets

        val mySet = HashSet<String>()

        mySet.add("Kirk")
        mySet.add("Kirk")

      //  println(mySet.size)


        //Map
        //Kind of arrays.
        //One value and one key.

        val myHashMap = HashMap<String, String>()

        myHashMap.put("name","James")
        myHashMap.put("instrument","Guitar")

      //  println(myHashMap["instrument"])




    }



}