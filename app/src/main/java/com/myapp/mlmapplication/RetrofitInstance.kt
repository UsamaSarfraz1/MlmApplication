package com.myapp.mlmapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit = Retrofit.Builder()
    .baseUrl("https://msgglobal.medtronix.world/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

}