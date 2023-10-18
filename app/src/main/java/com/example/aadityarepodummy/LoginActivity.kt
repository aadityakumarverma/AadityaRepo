package com.example.aadityarepodummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aadityarepodummy.Model.Login.LoginRequests.LoginRequests
import com.example.aadityarepodummy.Model.Login.LoginResponses.LoginResponses
import com.example.aadityarepodummy.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService=RetrofitBuilder.apiService

        binding.btnContinueLogin.setOnClickListener {
            val mobileNumber =binding.tvCountryCode.text.toString()+ binding.etmobileNumber.text.toString()
            val loginRequest = LoginRequests(mobileNumber,0) // Replace with your login details

            val call = apiService.login(loginRequest)

            call.enqueue(object : Callback<LoginResponses> {
                override fun onResponse(call: Call<LoginResponses>, response: Response<LoginResponses>) {



                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        Toast.makeText(this@LoginActivity, ""+loginResponse?.message.toString(), Toast.LENGTH_LONG).show()
                        val intent = Intent(this@LoginActivity, OtpVerificationActivity::class.java)
                        intent.putExtra("response_mobile_number", mobileNumber)
                        startActivity(intent)
                    }
                    else {

                        Toast.makeText(this@LoginActivity, "unsuccessful "+response.body().toString(), Toast.LENGTH_SHORT).show()

                    }
                }

                override fun onFailure(call: Call<LoginResponses>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "onFailure Block..", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }
}
