package com.myapp.mlmapplication.utils

import com.google.gson.Gson
import com.myapp.mlmapplication.interfaces.model.ErrorResponse
import retrofit2.Response

fun <T> Response<T>.getErrorBodyMessage(): String {
    val gson = Gson()
    val errorBody = errorBody()?.string()
    return if (errorBody != null) {
        try {
            val errorResponse = gson.fromJson(errorBody, ErrorResponse::class.java)
            errorResponse.message
        } catch (e: Exception) {
            "Error: Failed to parse error response"
        }
    } else {
        "Error: Empty error response body"
    }
}
