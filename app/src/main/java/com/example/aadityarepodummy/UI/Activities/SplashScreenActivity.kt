package com.example.aadityarepodummy.UI.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.example.aadityarepodummy.R

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
            val intent= Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },2000)

    }
}