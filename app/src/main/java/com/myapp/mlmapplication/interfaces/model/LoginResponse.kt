package com.myapp.mlmapplication.interfaces.model

data class LoginResponse(
    val user: User,
    val token: String,
    val message: String,
    val status: Int
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val email_verified_at: String?,
    val two_factor_confirmed_at: String?,
    val phone: String,
    val status: String,
    val role: String,
    val referral_id: String,
    val refer_by: String,
    val created_at: String,
    val updated_at: String,
    val profile_photo_url: String
)