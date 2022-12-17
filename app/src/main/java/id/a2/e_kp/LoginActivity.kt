package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import id.a2.e_kp.databinding.ActivityLoginBinding
import id.a2.e_kp.models.LoginResponse
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var buttonLogin : Button
    lateinit var inputUsername : TextInputEditText
    lateinit var inputPassword : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //cekLogin(); //fungsi loginnya
        lateinit var buttonLogin : Button   //fungsi awal
        buttonLogin  = binding.tombolLogin
        buttonLogin.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }

    fun cekLogin(){

        buttonLogin  = binding.tombolLogin
        inputUsername = binding.inputUsername
        inputPassword = binding.inputPassword

        val username: String = inputUsername.getText().toString()
        val password: String = inputPassword.getText().toString()

        buttonLogin.setOnClickListener(View.OnClickListener() {



            val client: KpClient = NetworkConfig().getService()

            val call: Call<LoginResponse> = client.login(username,password)

            call.enqueue(object: Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                    val respon: LoginResponse? = response.body();
                    if (respon != null){
                        Toast.makeText(this@LoginActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()
                        intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                    } else{
                        Toast.makeText(this@LoginActivity,"Username dan Password anda salah", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        })
    }


}