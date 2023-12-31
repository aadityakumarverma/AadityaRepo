package com.example.aadityarepodummy.Interfaces

import com.example.aadityarepodummy.ModelClasses.Login.LoginRequests.LoginRequests
import com.example.aadityarepodummy.ModelClasses.Login.LoginResponses.LoginResponses
import com.example.aadityarepodummy.ModelClasses.Otp.OtpRequests.OtpRequests
import com.example.aadityarepodummy.ModelClasses.Otp.OtpResponses.OtpResponses
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("v1/api/auth/login")
    fun login(@Body loginRequest: LoginRequests): Call<LoginResponses>

    @POST("v1/api/auth/verifyOtp")
    fun otp(@Body otpRequest: OtpRequests): Call<OtpResponses>
}
