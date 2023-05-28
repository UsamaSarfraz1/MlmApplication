package com.myapp.mlmapplication.utils

import android.content.Context
import android.content.SharedPreferences
import com.myapp.mlmapplication.BuildConfig
import com.myapp.mlmapplication.interfaces.model.LoginResponse

class SharedPreferencesManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun save(loginResponse: String) {
        sharedPreferences.edit().putString(KEY_LOGIN, loginResponse).apply()
    }

    fun getLoginInfo(): String? {
        return sharedPreferences.getString(KEY_LOGIN, null)
    }

    fun saveToken(token : String){
        sharedPreferences.edit().putString(KEY_TOKEN,token).apply()
    }

    fun clearToken(){
        sharedPreferences.edit().remove(KEY_TOKEN).apply()
    }
    // Other methods for saving/retrieving data from SharedPreferences
    fun isLoggedIn(): Boolean {
        return sharedPreferences.contains(KEY_TOKEN) // Check if the token is stored in shared preferences
    }
    companion object {
        private const val PREFS_NAME = BuildConfig.APPLICATION_ID
        private const val KEY_LOGIN = "login_response"
        private const val KEY_TOKEN ="token"
        // Add other keys for different data you want to store
    }
}
