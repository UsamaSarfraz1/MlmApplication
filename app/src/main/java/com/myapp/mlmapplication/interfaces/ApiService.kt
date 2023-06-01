package com.myapp.mlmapplication.interfaces

import android.view.contentcapture.DataRemovalRequest.LocusIdRequest
import com.myapp.mlmapplication.interfaces.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("register")
    fun registerUser(@Body request: RegistrationRequest): Call<RegistrationResponse>

    @POST("login")
    fun loginUser(@Body request: LoginRequest) : Call<LoginResponse>

    @GET("users/list")
    fun getUsers(@Header("Authorization") token: String): Call<UserRoot>
}
