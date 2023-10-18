package com.example.aadityarepodummy.Model.Otp.OtpRequests

data class OtpRequests(
    val mobileNumber: String?,
    val otp: Int,
    val user_type: Int
)