package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var buttonLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        buttonLogin  = binding.tombolLogin

        buttonLogin.setOnClickListener {

            val username = binding.inputUsername.getText().toString()
            val password = binding.inputPassword.getText().toString()
            Log.d("login debug", username + " " + password)

            val client: KpClient = NetworkConfig().getService()
            val call: Call<LoginResponse> = client.login(username, password)

            call.enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }


                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                    val respon: LoginResponse? = response.body();

                    if (respon != null && respon.status == "success") {
                        Toast.makeText(this@LoginActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()

                        val token : String? = respon.authorisation?.token

                        intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this@LoginActivity,"Username" + username + password,Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

    }


}