package com.example.aadityarepodummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aadityarepodummy.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userDetails=intent.getStringExtra("user_details")
        binding.tvUserDetails.text=userDetails



    }
}