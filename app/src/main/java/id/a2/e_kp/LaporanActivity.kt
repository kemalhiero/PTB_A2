package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.laporanKpAdapter
import id.a2.e_kp.databinding.ActivityLaporanBinding
import id.a2.e_kp.models.Internships_selesai
import id.a2.e_kp.models.LogoutResponse
import id.a2.e_kp.models.SelesaiKp
import id.a2.e_kp.models.laporanKp
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaporanActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: laporanKpAdapter
    lateinit var binding: ActivityLaporanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)

        val data =ArrayList<Internships_selesai>()


        recyclerView =binding.rvLaporan
        adapter = laporanKpAdapter(data)

        val client: KpClient = NetworkConfig().getService()
        val call: Call<SelesaiKp> = client.selesaikp("Bearer "+token)

        call.enqueue(object : Callback<SelesaiKp>{
            override fun onResponse(
                call: Call<SelesaiKp>,
                response: Response<SelesaiKp>
            ) {
                val araei = response.body()?.internships

                adapter = araei?.let { laporanKpAdapter(it) }!!
                Log.d("anjay", araei.toString())
            }

            override fun onFailure(call: Call<SelesaiKp>, t: Throwable) {
                Toast.makeText(this@LaporanActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : laporanKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val DetailLaporanKpActivity = Intent (this@LaporanActivity, DetailLaporanKpActivity::class.java)
                DetailLaporanKpActivity.putExtra("namaMahasiswa",data[position].name)
                DetailLaporanKpActivity.putExtra("nimMahasiswa",data[position].nim)
                startActivity(DetailLaporanKpActivity)
            }
        })

    }

}