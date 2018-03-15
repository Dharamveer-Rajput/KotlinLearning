package com.kotlinlearning.alertDialogs

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import com.kotlinlearning.R

class AlertDialogs : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialogs)


    }

    fun save(view: View){

        val alert = AlertDialog.Builder(this)

        alert.setTitle("Save")
        alert.setMessage("Are you Sure?")
        alert.setPositiveButton("Yes") {dialogInterface: DialogInterface, i: Int -> Toast.makeText(applicationContext,"Saved",Toast.LENGTH_LONG).show() }
        alert.setNegativeButton("No") {dialogInterface: DialogInterface, i: Int ->  Toast.makeText(applicationContext,"Not Saved",Toast.LENGTH_LONG).show()}
        alert.show()
    }
}
