package com.myapp.mlmapplication.interfaces.model

data class RegistrationRequest(
    val email: String,
    val password: String,
    val phone: String,
    val name: String,
    val refer_by: String
)


data class RegistrationResponse(
    val message: String,
    val status: Int,
    val token: String
)
