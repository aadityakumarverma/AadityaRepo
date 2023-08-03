package com.example.aadityarepodummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.aadityarepodummy.databinding.ActivityCustomToastBinding

class CustomToastActivity : AppCompatActivity() {

    lateinit var binding: ActivityCustomToastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCustomToastBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val toast = Toast(this)

        val view : View = layoutInflater.inflate(R.layout.custom_toast_layout,null)

        toast.view=view

        val txtView : TextView = view.findViewById(R.id.tvToastMessage)
        txtView.text = "Message sent successfully"
        toast.duration = Toast.LENGTH_LONG


        binding.btnCustomToast.setOnClickListener {
            toast.show()
        }

    }
}