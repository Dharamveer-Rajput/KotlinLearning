package com.kotlinlearning

import android.content.Intent
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


        //Operators

        var m = 5
       // println(m)
        m = m + 1
      //  println(m)
        m++
       // println(m)
        m--
       // println(m)


        var n = 10


      //  println(m>n)
      //  println(n>m)


        /*
        >
        <
        >=
        <=
        ==
        !=
        &&
        ||
         */

        //if

        if(m > n){
          //  println("m is greater than n")
        } else if( n > m){
           // println("n is greater than m")
        } else{
           // println("m is equal to n")
        }


        //switch

        val day = 1
        var dayString = ""

        if( day == 1)
        {
            dayString = "Monday"
        } else if(day == 2){
            dayString = "Tuesday"
        } else if(day == 3){
            dayString = "Wednesday"
        }

        when (day){

            1 -> dayString = "Monday"
            2 -> dayString = "Tuesday"
            3 -> dayString = "Wednesday"
            else ->dayString = "Sunday"
        }

      //  println(dayString)


        //for loops
        val myNumber = intArrayOf(12,15,18,21,24)

        val q = myNumber[0] / 3 * 5
        println(q)

        for (number in myNumber) {
            val z = number / 3 * 5
            println(z)
        }

        for ( i in myNumber.indices) {
            val y = myNumber[i] / 3 * 5
            println(y)
        }


        for( a in 0..9) {
            val b = a * 10
            println(b)
        }


        //While loop

        var j = 0

        while (j<10){
            val x = j * 10
            println(x)
            j++
        }
    }

    fun changeActivity(view: View){

        val intent = Intent(applicationContext,SecondActivity::class.java)

        intent.putExtra("input",editText.text.toString())

        startActivity(intent)
    }


}