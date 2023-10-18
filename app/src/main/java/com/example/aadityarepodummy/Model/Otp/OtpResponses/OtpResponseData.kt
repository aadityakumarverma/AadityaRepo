package com.example.aadityarepodummy.Model.Otp.OtpResponses

data class OtpResponseData(
    val token: String,
    val user: UserDataFromOtp,
    val userType: Int
)