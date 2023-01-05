package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import id.a2.e_kp.databinding.ActivitySeminarKpBinding
import id.a2.e_kp.models.DetailSeminarResponse
import id.a2.e_kp.models.DetailSeminarResponseItem
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeminarKpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySeminarKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeminarKpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val getNama = intent.getStringExtra("nama")
        binding.tvNamaMhsSeminar.text = getNama.toString()
        val getNim = intent.getStringExtra("nim")
        binding.tvNimMhsSeminar.text = getNim.toString()

        val client: KpClient = NetworkConfig().getService()
        val call: Call<List<DetailSeminarResponseItem>> = client.detailSeminar("Bearer "+ada, 2)

        call.enqueue(object: Callback<List<DetailSeminarResponseItem>>{
            override fun onResponse(
                call: Call<List<DetailSeminarResponseItem>>,
                response: Response<List<DetailSeminarResponseItem>>
            ) {
                val respon = response.body()?.get(0)
                if (respon!=null){
                    Log.d("seminarrr", respon.toString())
                    Toast.makeText(this@SeminarKpActivity, respon.toString(), Toast.LENGTH_SHORT).show()

                    binding.tvJadwalSeminar.text = respon.seminarDate
                    binding.tvTempatSeminar.text = respon.seminarRoomName
                    binding.tvPembimbingSeminar.text = respon.supervisor.toString()
                    binding.tvJudulSeminar.text = respon.title
                }
            }

            override fun onFailure(call: Call<List<DetailSeminarResponseItem>>, t: Throwable) {
                Toast.makeText(this@SeminarKpActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        lateinit var button : Button
        button  = binding.buttonDaftarSeminarKp
        button.setOnClickListener{
            intent = Intent(applicationContext, DaftarSeminarKpActivity::class.java)
            startActivity(intent)
        }
    }
}