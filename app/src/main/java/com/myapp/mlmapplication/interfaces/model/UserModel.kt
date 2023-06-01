package com.myapp.mlmapplication.interfaces.model

data class UserRoot(
    var message: List<UserModel>? = null,
    var status: Int = 0
)
data class UserModel(
    val id: String,
    val name: String,
    val email: String,
    val email_verified_at: String?,
    val password: String,
    val two_factor_secret: String?,
    val two_factor_recovery_codes: String?,
    val two_factor_confirmed_at: String?,
    val phone: String,
    val remember_token: String?,
    val status: String,
    val role: String,
    val referral_id: String,
    val refer_by: String?,
    val profile_pic_url: String?,
    val created_at: String,
    val updated_at: String
)
