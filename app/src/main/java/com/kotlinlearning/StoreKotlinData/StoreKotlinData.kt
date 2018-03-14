package com.kotlinlearning.StoreKotlinData

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlinlearning.R

class StoreKotlinData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_kotlin_data)

        val sharedPreferences = this.getSharedPreferences("com.kotlinlearning.StoreKotlinData",android.content.Context.MODE_PRIVATE)

        var age = 27


        val storedAge = sharedPreferences.getInt("userAge",0)

        println("storedAge: $storedAge")

        age = 31

        sharedPreferences.edit().putInt("userAge",age).apply()

        val storedAge2 = sharedPreferences.getInt("userAge",0)

        println("storedAge: $storedAge2")

        //sharedPreferences.edit().remove("userAge").apply()

        val storedAge3 = sharedPreferences.getInt("userAge",0)

        println("storedAge3 $storedAge3")


    }
}
