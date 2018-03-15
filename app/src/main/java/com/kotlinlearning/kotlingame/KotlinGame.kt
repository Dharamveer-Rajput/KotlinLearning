package com.kotlinlearning.kotlingame

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.kotlinlearning.R
import kotlinx.android.synthetic.main.activity_kotlin_game.*
import java.util.*

class KotlinGame : AppCompatActivity() {

    var score : Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable : Runnable = Runnable {  }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_game)

        score = 0

        imageArray = arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)


        hideImages()

        object : CountDownTimer(10000,1000) {
            override fun onFinish() {

                textViewTimer.text = "Time is Off"
                handler.removeCallbacks(runnable)
                for(image in imageArray) {
                    image.visibility = View.INVISIBLE
                }


            }

            override fun onTick(p0: Long) {
                textViewTimer.text = "Time: " + p0 / 1000
            }

        }.start()



    }




    fun hideImages(){

        runnable = object : Runnable {
            override fun run() {

                for( image in imageArray) {

                    image.visibility = View.INVISIBLE

                }

                val random = Random()
                val index = random.nextInt(8-0)
                imageArray[index].visibility = View.VISIBLE


                handler.postDelayed(runnable,500)
            }

        }

        handler.post(runnable)


    }

    fun increaseScore(view: View){

        score++

        textViewScore.text = "Score: " + score
    }
}
