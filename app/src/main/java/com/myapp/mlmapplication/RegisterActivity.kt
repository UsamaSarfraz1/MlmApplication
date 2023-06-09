package com.myapp.mlmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.myapp.mlmapplication.RetrofitInstance.retrofit
import com.myapp.mlmapplication.databinding.ActivityRegisterBinding
import com.myapp.mlmapplication.interfaces.ApiService
import com.myapp.mlmapplication.interfaces.model.RegistrationRequest
import com.myapp.mlmapplication.interfaces.model.RegistrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            finish()
        }


        binding.btnSignup.setOnClickListener{
            register()
        }

    }


    private fun register(){
        binding.progressBar.visibility= View.VISIBLE
        val request = RegistrationRequest(
            email = binding.emailEdittext.text.toString().trim(),
            password = binding.passwordEdittext.text.toString().trim(),
            phone = binding.phoneEdittext.text.toString().trim(),
            name = binding.nameEdittext.text.toString().trim(),
            refer_by = binding.rollEdittext.text.toString().trim()
        )
        if (request.name.isEmpty()){
            binding.progressBar.visibility=View.GONE
            Toast.makeText(this,"Enter name",Toast.LENGTH_SHORT).show()
            return
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(request.email).matches()){
            Toast.makeText(this,"Enter email",Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility=View.GONE
            return
        }else if (request.password.isEmpty()){
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility=View.GONE
            return
        }else if (request.phone.isEmpty()){
            binding.progressBar.visibility=View.GONE
            Toast.makeText(this,"Enter phone",Toast.LENGTH_SHORT).show()
            return
        }
        val apiService: ApiService = retrofit.create(ApiService::class.java)

        val call: Call<RegistrationResponse> = apiService.registerUser(request)
        call.enqueue(object : Callback<RegistrationResponse> {
            override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                if (response.isSuccessful) {
                    val registrationResponse: RegistrationResponse? = response.body()
                    // Process the registration response
                    val message: String? = registrationResponse?.message
                    val status: Int? = registrationResponse?.status
                    val token: String? = registrationResponse?.token
                    binding.progressBar.visibility=View.GONE
                    Toast.makeText(this@RegisterActivity,message,Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    binding.progressBar.visibility=View.GONE
                    Toast.makeText(this@RegisterActivity,"Something getting wrong",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                // Handle network failure
                binding.progressBar.visibility=View.GONE
                Toast.makeText(this@RegisterActivity,"Something getting wrong",Toast.LENGTH_SHORT).show()
            }
        })
    }
}