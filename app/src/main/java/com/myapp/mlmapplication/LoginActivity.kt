package com.myapp.mlmapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.myapp.mlmapplication.RetrofitInstance.retrofit
import com.myapp.mlmapplication.databinding.ActivityLoginBinding
import com.myapp.mlmapplication.interfaces.ApiService
import com.myapp.mlmapplication.interfaces.model.LoginRequest
import com.myapp.mlmapplication.interfaces.model.LoginResponse
import com.myapp.mlmapplication.utils.SharedPreferencesManager
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferencesManager=SharedPreferencesManager(this)
        if (sharedPreferencesManager.isLoggedIn()){
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()
        }else{
            binding.btnLogin.setOnClickListener {
                loginUser()
            }
        }
        binding.btnSignup.setOnClickListener{
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }

    }

    private fun loginUser(){
        binding.progressBar.visibility= View.VISIBLE
        val email = binding.emailEdittext.text.toString().trim()
        val password = binding.passwordEdittext.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || password.isEmpty()){
            binding.progressBar.visibility=View.GONE
            Toast.makeText(this@LoginActivity,"Incorrect Email or Password",Toast.LENGTH_SHORT).show()
            return
        }
        val apiService: ApiService = retrofit.create(ApiService::class.java)

        val userRequest = LoginRequest(email,password)
        val loginCall: Call<LoginResponse> = apiService.loginUser(userRequest)
        loginCall.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    // Handle the successful login response
                    val token = loginResponse?.token
                    val user = loginResponse?.user
                    val message = loginResponse?.message
                    val gson = Gson()
                    val loginResponseJson = gson.toJson(loginResponse)
                    sharedPreferencesManager.save(loginResponseJson)
                    if (token != null) {
                        sharedPreferencesManager.saveToken(token)
                    }
                    Toast.makeText(this@LoginActivity,message,Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@LoginActivity,UserListActivity::class.java))
                    finish()
                    binding.progressBar.visibility=View.GONE

                    // ...
                } else {
                    val errorBody = response.errorBody()?.string()
                    val message = if (!errorBody.isNullOrEmpty()) {
                        try {
                            val errorJson = JSONObject(errorBody)
                            errorJson.getString("message")
                        } catch (e: JSONException) {
                            "Login failed"
                        }
                    } else {
                        "Login failed"
                    }
                    binding.progressBar.visibility=View.GONE

                    Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Handle login failure
                Toast.makeText(this@LoginActivity,t.message,Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility=View.GONE
                // ...
            }
        })
    }
}