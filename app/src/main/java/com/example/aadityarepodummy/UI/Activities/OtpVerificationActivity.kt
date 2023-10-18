package com.example.aadityarepodummy.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aadityarepodummy.Others.GenericKeyEvent
import com.example.aadityarepodummy.Others.GenericTextWatcher
import com.example.aadityarepodummy.ModelClasses.Otp.OtpRequests.OtpRequests
import com.example.aadityarepodummy.ModelClasses.Otp.OtpResponses.OtpResponses
import com.example.aadityarepodummy.Utils.RetrofitBuilder
import com.example.aadityarepodummy.databinding.ActivityOtpVerificationBinding
import retrofit2.Call
import retrofit2.Response

class OtpVerificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityOtpVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOtpVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mobileNumber:String? = intent.getStringExtra("response_mobile_number")
        binding.tvMobileNumber.text=mobileNumber


////////
        binding.et1.addTextChangedListener(GenericTextWatcher(binding.et1, binding.et2))
        binding.et2.addTextChangedListener(GenericTextWatcher(binding.et2, binding.et3))
        binding.et3.addTextChangedListener(GenericTextWatcher(binding.et3, binding.et4))
        binding.et4.addTextChangedListener(GenericTextWatcher(binding.et4, null))



        binding.et1.setOnKeyListener(GenericKeyEvent(binding.et1, null))
        binding.et2.setOnKeyListener(GenericKeyEvent(binding.et2, binding.et1))
        binding.et3.setOnKeyListener(GenericKeyEvent(binding.et3, binding.et2))
        binding.et4.setOnKeyListener(GenericKeyEvent(binding.et4, binding.et3))
//////////

        val apiService= RetrofitBuilder.apiService
        binding.btnSubmitOtp.setOnClickListener {
            val otpRequests= OtpRequests(mobileNumber,1234,0)
            val call=apiService.otp(otpRequests)

            call.enqueue(object : retrofit2.Callback<OtpResponses> {
                override fun onResponse(call: Call<OtpResponses>, response: Response<OtpResponses>) {
                    if (response.isSuccessful)
                    {val otpResponses=response.body()

                        val userId= otpResponses?.data?.user?._id

                        Toast.makeText(this@OtpVerificationActivity, ""+otpResponses?.message, Toast.LENGTH_SHORT).show()
                        val intentOtp=Intent(this@OtpVerificationActivity, HomeActivity::class.java)
                        intentOtp.putExtra("user_details", "id : $userId\n\nMobile Number : $mobileNumber")
                        startActivity(intentOtp)
                    }
                    else{
                        Toast.makeText(this@OtpVerificationActivity, "Incorrect OTP", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<OtpResponses>, t: Throwable) {
                    Toast.makeText(this@OtpVerificationActivity, "onFailure...", Toast.LENGTH_SHORT).show()
                }

            })
        }



    }
}