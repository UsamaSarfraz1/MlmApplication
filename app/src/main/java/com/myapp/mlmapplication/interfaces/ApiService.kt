package com.myapp.mlmapplication.interfaces

import android.view.contentcapture.DataRemovalRequest.LocusIdRequest
import com.myapp.mlmapplication.interfaces.model.LoginRequest
import com.myapp.mlmapplication.interfaces.model.LoginResponse
import com.myapp.mlmapplication.interfaces.model.RegistrationRequest
import com.myapp.mlmapplication.interfaces.model.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("register")
    fun registerUser(@Body request: RegistrationRequest): Call<RegistrationResponse>

    @POST("login")
    fun loginUser(@Body request: LoginRequest) : Call<LoginResponse>
}
