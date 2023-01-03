package id.a2.e_kp

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import id.a2.e_kp.databinding.ActivityMainBinding
import id.a2.e_kp.models.LogoutResponse
import id.a2.e_kp.models.ProfileResponse
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var btnkeluar : Button


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("prefs",Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)
        val namaUser = sharedPref.getString("nama",null)

        if (token==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.textNamaKaprodi.text = namaUser

        btnkeluar = findViewById(R.id.btnkeluar)
        btnkeluar.setOnClickListener {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setContentView(R.layout.custom_dialog)

            val btnyakin = dialog.findViewById<Button>(R.id.btnyakin)
            btnyakin.setOnClickListener{

                val client: KpClient = NetworkConfig().getService()
                val call: Call<LogoutResponse> = client.logout("Bearer "+token)

                call.enqueue(object: Callback<LogoutResponse>{
                    override fun onResponse( call: Call<LogoutResponse>, response: Response<LogoutResponse> ) {
                        val respon = response.body()
                        if (respon != null) {
                            Toast.makeText(this@MainActivity, respon.message, Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                        Log.d("logout-debug",t.localizedMessage)
                    }

                })

                val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
                with (sharedPref.edit()) {
                    putString("token", null)
                    putString("nama", null)
                    apply()
                }

                intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
                dialog.dismiss()
            }
            dialog.show()
        }


        lateinit var cardViewUsulanKp: CardView
        cardViewUsulanKp = binding.cardViewUsulanKp
        cardViewUsulanKp.setOnClickListener {
            intent = Intent(applicationContext, UsulanKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var cardViewMahasiswaKp: CardView
        cardViewMahasiswaKp = binding.cardViewMahasiswaKp
        cardViewMahasiswaKp.setOnClickListener {
            intent = Intent(applicationContext, MahasiswaKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var cardViewLaporanKp: CardView
        cardViewLaporanKp = binding.cardViewLaporanKp
        cardViewLaporanKp.setOnClickListener {
            intent = Intent(applicationContext, LaporanActivity::class.java)
            startActivity(intent)
        }
    }
}

