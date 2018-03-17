package com.kotlinlearning.kotlinApp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo

import com.kotlinlearning.R
import com.kotlinlearning.mvparchitecture.base.BasePresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login_main.*


class LoginMainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_main)

        edPassword.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == R.id.login || i == EditorInfo.IME_NULL) {
                login()
                return@setOnEditorActionListener true
            }
            false
        }

        btnSignIn.setOnClickListener {
            login()
        }



    }

    private fun login() {



    }


}
