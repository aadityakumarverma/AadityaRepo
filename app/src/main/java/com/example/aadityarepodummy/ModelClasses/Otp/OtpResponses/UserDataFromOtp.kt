package com.example.aadityarepodummy.ModelClasses.Otp.OtpResponses

data class UserDataFromOtp(
    val _id: String,
    val email: String,
    val fullName: String,
    val gender: String,
    val mobileNumber: String,
    val profilePicture: String,
    val profileSet: Boolean
)