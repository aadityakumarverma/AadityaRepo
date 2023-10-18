package com.example.aadityarepodummy.ModelClasses.Otp.OtpResponses

data class OtpResponses(
    val code: Int,
    val `data`: OtpResponseData,
    val message: String
)