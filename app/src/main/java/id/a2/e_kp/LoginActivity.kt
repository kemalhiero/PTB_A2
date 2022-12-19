package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import id.a2.e_kp.databinding.ActivityLoginBinding
import id.a2.e_kp.models.LoginResponse
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //cek ada token atau ndak, kalo ada langsung ke MainActivity
        val sharedPref = getSharedPreferences("prefs",Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada!=null){
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonLogin  = binding.tombolLogin

        buttonLogin.setOnClickListener {

            val progresBar = binding.progressBarLogin
            progresBar.visibility = View.GONE

            val username = binding.inputUsername.getText().toString()
            val password = binding.inputPassword.getText().toString()
            Log.d("login debug", username + " " + password)

            val client: KpClient = NetworkConfig().getService()

            progresBar.visibility = View.VISIBLE

            val call: Call<LoginResponse> = client.login(username, password)

            call.enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    progresBar.visibility = View.GONE
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                    val respon: LoginResponse? = response.body()

                    if (respon != null && respon.status == "success" && respon.user?.username == "198201182008121002") {
                        Toast.makeText(this@LoginActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()

                        val token : String? = respon.authorisation?.token

                        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
                        with (sharedPref.edit()) {
                            putString("token", token)
                            apply()
                        }

                        intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                    else if (respon != null && respon.status == "success" && respon.user?.username != "198201182008121002"){
                        Toast.makeText(this@LoginActivity, "Anda bukan pak husnil", Toast.LENGTH_SHORT).show()
                    }

                    else {
                        Toast.makeText(this@LoginActivity,"Username dan password anda salah",Toast.LENGTH_SHORT).show()
                    }

                    progresBar.visibility = View.GONE
                }
            })
        }

    }


}