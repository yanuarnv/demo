package com.example.demo

data class ApiResponse<T>(
    val success: Boolean,
    val msg:String,
    val data: T? = null,
)