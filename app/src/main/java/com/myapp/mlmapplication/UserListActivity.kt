package com.myapp.mlmapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.myapp.mlmapplication.databinding.ActivityUserListBinding
import com.myapp.mlmapplication.interfaces.ApiService
import com.myapp.mlmapplication.interfaces.model.UserModel
import com.myapp.mlmapplication.interfaces.model.UserRoot
import com.myapp.mlmapplication.utils.SharedPreferencesManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserListBinding
    private val TAG = "UserListActivity"
    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferencesManager=SharedPreferencesManager(this)
        getUserList()
    }

    private fun getUserList() {
        val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)
        val token = sharedPreferencesManager.getTokken()
        val call : Call<UserRoot> = apiService.getUsers("Bearer $token")
        call.enqueue(object : Callback<UserRoot> {
            override fun onResponse(call: Call<UserRoot>, response: Response<UserRoot>) {
                if (response.isSuccessful) {
                    val userRoot: UserRoot? = response.body()
                    val users: List<UserModel>? = userRoot?.message

                    // Handle the list of users here
                    users?.let {
                        for (user in users) {
                            // Access user properties
                            val id = user.id
                            val name = user.name
                            val email = user.email
                            // ...

                            Log.i(TAG,email)
                        }
                    }
                } else {
                    // Handle unsuccessful response
                    // You can check the response code and error body here
                }
            }

            override fun onFailure(call: Call<UserRoot>, t: Throwable) {
                // Handle failure
            }
        })



    }
}