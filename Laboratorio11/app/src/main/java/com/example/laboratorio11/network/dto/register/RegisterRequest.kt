package com.example.laboratorio11.network.dto.register

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)