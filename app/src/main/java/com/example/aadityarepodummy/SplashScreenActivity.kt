package com.example.aadityarepodummy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        Button = findViewById(R.id.btnCustomToast)


        val toast = Toast(this)

        val view : View = layoutInflater.inflate(R.layout.custom_toast_layout,null)

        toast.view=view

        val txtView : TextView = view.findViewById(R.id.tvToastMessage)
        txtView.text = "Message sent successfully"
        toast.duration = Toast.LENGTH_LONG


        Button.setOnClickListener {
            toast.show()
        }

    }
}