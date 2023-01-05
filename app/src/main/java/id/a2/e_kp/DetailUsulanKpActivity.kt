package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import id.a2.e_kp.databinding.ActivityDetailUsulanKpBinding
import id.a2.e_kp.models.DetailUsulanProposalResponse
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUsulanKpActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailUsulanKpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("namaMahasiswa")
        binding.tvPerusahaanUsulanKPDetail.text = getNama.toString()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)

        if (token==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val client: KpClient = NetworkConfig().getService()
        val call: Call<DetailUsulanProposalResponse> = client.detailUsulanProposal("Bearer $token", 31)

        call.enqueue(object: Callback<DetailUsulanProposalResponse>{
            override fun onResponse(
                call: Call<DetailUsulanProposalResponse>,
                response: Response<DetailUsulanProposalResponse>
            ) {
                val respon = response.body()
                Log.d("detailusulandebug", respon.toString())

                if (respon!=null){
                    binding.tvPerusahaanUsulanKPDetail.text = respon.name
                    binding.tvMulaiKpDetail.text = respon.startAt
                    binding.tvSelesaiKpDetail.text = respon.endAt
                    binding.tvSelesaiKpDetail.text = respon.endAt
                    binding.tvJumlahPesertaKpDetail.text = respon.jumlah.toString()

                    if (respon.status==null){
                        binding.tvStatusKpDetail.text = "-"

                    }else{
                        binding.tvStatusKpDetail.text = respon.status.toString()
                    }

                }
            }

            override fun onFailure(call: Call<DetailUsulanProposalResponse>, t: Throwable) {
                Toast.makeText(this@DetailUsulanKpActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })


    }


}