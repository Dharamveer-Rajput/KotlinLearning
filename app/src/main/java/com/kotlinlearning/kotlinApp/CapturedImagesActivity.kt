package com.kotlinlearning.kotlinApp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import com.kotlinlearning.R
import kotlinx.android.synthetic.main.activity_captured_images.*
import kotlinx.android.synthetic.main.grid_item_layout.view.*
import java.util.*

class CapturedImagesActivity : AppCompatActivity() {


    var adapter: ImagesAdapter? = null
    var imagesList = ArrayList<ImagesModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)

        //Remove notification bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_captured_images)



        // load foods
        imagesList.add(ImagesModel("Front View", R.drawable.imagesam))
        imagesList.add(ImagesModel("Back View", R.drawable.person))
        imagesList.add(ImagesModel("Left View ", R.drawable.person))
        imagesList.add(ImagesModel("Right View",R.drawable.imagesam))

        adapter = ImagesAdapter(this, imagesList)

        gridCapture.adapter = adapter


    }

    class ImagesAdapter : BaseAdapter {
        var foodsList = ArrayList<ImagesModel>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<ImagesModel>) : super() {
            this.context = context
            this.foodsList = foodsList
        }

        override fun getCount(): Int {
            return foodsList.size
        }

        override fun getItem(position: Int): Any {
            return foodsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.foodsList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.grid_item_layout, null)
            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            return foodView
        }
    }



}
