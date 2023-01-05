package id.a2.e_kp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import id.a2.e_kp.databinding.ActivityPersetujuanNilaiBinding
import id.a2.e_kp.models.InternshipsSelesai
import id.a2.e_kp.models.SelesaiKP
import id.a2.e_kp.models.setujuNilai
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersetujuanNilaiActivity : AppCompatActivity() {

    lateinit var binding: ActivityPersetujuanNilaiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersetujuanNilaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("nama")
        binding.tvNamaMhsPersetujuanNilai.text = getNama.toString()
        val getNim = intent.getStringExtra("nim")
        binding.tvNimMhsPersetujuanNilai.text = getNim.toString()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)

        val data =ArrayList<setujuNilai>()

        val client: KpClient = NetworkConfig().getService()
        val call: Call<setujuNilai> = client.setujunilai("Bearer "+token)


        call.enqueue(object : Callback<setujuNilai>{
            override fun onResponse(call: Call<setujuNilai>, response: Response<setujuNilai> ) {

                val respon: setujuNilai? = response.body()
                if (respon!= null){
                    val list : List<setujuNilai> = respon.message as List<setujuNilai>
                }

                Log.d("oke", response.toString()
                )
            }

            override fun onFailure(call: Call<setujuNilai>, t: Throwable) {
                Toast.makeText(this@PersetujuanNilaiActivity, t.localizedMessage,
                    Toast.LENGTH_SHORT).show()
            }

        })




    }


    }





