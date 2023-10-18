package com.example.aadityarepodummy.ModelClasses.Otp.OtpRequests

data class OtpRequests(
    val mobileNumber: String?,
    val otp: Int,
    val user_type: Int
)