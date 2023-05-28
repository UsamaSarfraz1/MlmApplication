package com.myapp.mlmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.myapp.mlmapplication.databinding.ActivityProfileBinding
import com.myapp.mlmapplication.interfaces.model.LoginResponse
import com.myapp.mlmapplication.utils.SharedPreferencesManager
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    private lateinit var sharedPreference : SharedPreferencesManager
    private val TAG = "ProfileActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreference= SharedPreferencesManager(this)
        val gson = Gson()
        val loginResponse = gson.fromJson(sharedPreference.getLoginInfo(),LoginResponse::class.java)
        val userData = loginResponse.user
        Log.i(TAG,userData.profile_photo_url.toString())
        binding.userName.text=userData.name
        binding.email.text=userData.email
        binding.name.text=userData.name
        binding.phone.text=userData.phone
        binding.date.text=userData.created_at
        Picasso.get()
            .load("https://ui-avatars.com/api/?name=usama+sarfraz&color=7F9CF5&background=EBF4FF")
            .placeholder(R.drawable.ic_baseline_phone_24) // Placeholder image resource
            // Error image resource
            .into(binding.avatar)
    }
}