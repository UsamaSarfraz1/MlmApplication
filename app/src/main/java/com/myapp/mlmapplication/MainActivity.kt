package com.myapp.mlmapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.mlmapplication.databinding.ActivityMainBinding
import com.myapp.mlmapplication.utils.SharedPreferencesManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreference : SharedPreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreference= SharedPreferencesManager(this)
        binding.btnSignOut.setOnClickListener {
            sharedPreference.clearToken()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this@MainActivity,ProfileActivity::class.java))
        }
    }
}