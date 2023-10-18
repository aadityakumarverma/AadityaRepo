package com.example.aadityarepodummy.ModelClasses.Otp.OtpResponses

data class OtpResponseData(
    val token: String,
    val user: UserDataFromOtp,
    val userType: Int
)