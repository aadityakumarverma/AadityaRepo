package com.example.aadityarepodummy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SplashScreenActivity : AppCompatActivity() {

    lateinit var Button : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        /*btn_GetStarted.setOnClickListener {
            val intent = Intent(this@SplashScreenActivity,UserLogin::class.java)
            startActivity(intent)
        }*/
        Handler().postDelayed({
            val intent= Intent(this@SplashScreenActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        },2000)

    }
}