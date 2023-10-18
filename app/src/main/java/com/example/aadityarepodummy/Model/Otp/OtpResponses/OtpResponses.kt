package com.example.aadityarepodummy.Model.Otp.OtpResponses

data class OtpResponses(
    val code: Int,
    val `data`: OtpResponseData,
    val message: String
)