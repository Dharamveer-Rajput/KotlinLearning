package com.kotlinlearning.kotlinApp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_app.*
import android.view.*
import android.widget.Toast
import com.droidbyme.dialoglib.AnimUtils
import com.droidbyme.dialoglib.DroidDialog
import com.kotlinlearning.R
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {


    val CAMERA_REQUEST_CODE = 0
    lateinit var imageFilePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)

        //Remove notification bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_kotlin_app)


        txtMyProfile.setOnClickListener(this)
        txtMyImages.setOnClickListener(this)
        txtGallery.setOnClickListener(this)
        txtAboutus.setOnClickListener(this)
        txtFeedback.setOnClickListener(this)
        txtLogout.setOnClickListener(this)

        imageCamera.setOnClickListener(this)
        myImageViewText.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {

        when(p0?.id){

            R.id.myImageViewText -> {

                val intent = Intent(this,CapturedImagesActivity::class.java)
                startActivity(intent)
            }


            R.id.txtMyProfile ->{
                drawer_layout.closeDrawer(GravityCompat.START)
                Toast.makeText(applicationContext, "My Profile", Toast.LENGTH_SHORT).show()
            }
            R.id.txtMyImages ->{
                drawer_layout.closeDrawer(GravityCompat.START)
                Toast.makeText(applicationContext, "My Images", Toast.LENGTH_SHORT).show()
            }
            R.id.txtGallery ->{
                drawer_layout.closeDrawer(GravityCompat.START)
                Toast.makeText(applicationContext, "My Gallery", Toast.LENGTH_SHORT).show()
            }
            R.id.txtAboutus -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                Toast.makeText(applicationContext,"About Us",Toast.LENGTH_SHORT).show()
            }
            R.id.txtFeedback -> {
                drawer_layout.closeDrawer(GravityCompat.START)
                Toast.makeText(applicationContext,"Feedback",Toast.LENGTH_SHORT).show()
            }
            R.id.txtLogout -> {
                drawer_layout.closeDrawer(GravityCompat.START)
               // Toast.makeText(applicationContext,"Logout",Toast.LENGTH_SHORT).show()


                DroidDialog.Builder(this)
                        .icon(R.drawable.ic_action_tick)
                        .title("Logout")
                        .content(getString(R.string.areyousuretologout))
                        .cancelable(true, true)
                        .positiveButton("YES") { droidDialog ->
                            droidDialog.dismiss()
                             Toast.makeText(this, "YES", Toast.LENGTH_SHORT).show();


                        }
                        .negativeButton("No") { droidDialog ->
                            droidDialog.dismiss()
                            //Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                        }
                        .neutralButton("SKIP") { droidDialog ->
                            droidDialog.dismiss()
                            // Toast.makeText(context, "Skip", Toast.LENGTH_SHORT).show();
                        }
                        .typeface("regular.ttf")
                        .animation(AnimUtils.AnimZoomInOut)
                        .color(ContextCompat.getColor(this, R.color.yellowtext), ContextCompat.getColor(this, R.color.white),
                                ContextCompat.getColor(this, R.color.dark_indigo))
                        .divider(true, ContextCompat.getColor(this, R.color.orange))
                        .show()

            }
            R.id.imageCamera -> {
             //   Toast.makeText(this,"Camera Open",Toast.LENGTH_SHORT).show()


                try {
                    val imageFile = createImageFile()
                    val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if(callCameraIntent.resolveActivity(packageManager) != null) {
                        val authorities = packageName + ".fileprovider"
                        val imageUri = FileProvider.getUriForFile(this, authorities, imageFile)
                        callCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                        startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
                    }
                } catch (e: IOException) {
                    Toast.makeText(this, "Could not create file!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    @Throws(IOException::class)
     fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName: String = "JPEG_" + timeStamp + "-"
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if(!storageDir.exists()) storageDir.mkdir()
        val imageFile = File.createTempFile(imageFileName,".jpg",storageDir)
        imageFilePath  = imageFile.absolutePath
        return imageFile

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                /*                if(resultCode == Activity.RESULT_OK && data != null) {
                     photoImageView.setImageBitmap(data.extras.get("data") as Bitmap)
                 }*/

                if(resultCode == Activity.RESULT_OK) {
                  //  photoImageView.setImageBitmap(setScaledBitmap())

                    Toast.makeText(this, "Photo has been captured", Toast.LENGTH_SHORT).show()

                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_SHORT).show()
            }


        }
    }

  /*  fun setScaledBitmap(): Bitmap {
        val imageViewWidth = photoImageView.width
        val imageViewHeight = photoImageView.height

        val bmOptions = BitmapFactory.Options()
        bmOptions.inJustDecodeBounds = true
        BitmapFactory.decodeFile(imageFilePath, bmOptions)
        val bitmapWidth = bmOptions.outWidth
        val bitmapHeight = bmOptions.outHeight

        val scaleFactor = Math.min(bitmapWidth/imageViewWidth, bitmapHeight/imageViewHeight)

        bmOptions.inJustDecodeBounds = false
        bmOptions.inSampleSize = scaleFactor

        return BitmapFactory.decodeFile(imageFilePath, bmOptions)

    }*/


}
