package com.kotlinlearning.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.kotlinlearning.R

/**
 * Created by dharamveer on 1/3/18.
 */
class RecyclerviewMain : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_laout)


        //getting recyclerview from xml
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        //creating an arraylist to store users using the data classuser
        val users = ArrayList<User>()

        //adding some dummy data to the list
        users.add(User("Dharamveer" , "Mohali Punjab"))
        users.add(User("Manpreet" , "Ropar Punjab"))
        users.add(User("Atinder" , "Ropar Punjab"))
        users.add(User("Surinder Singh" , "Nangal Punjab"))
        users.add(User("Parvesh Khan" , "Agra Uttar Pardesh"))


        //creating our adapter
        val adapter = CustomAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter


    }
}