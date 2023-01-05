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
import id.a2.e_kp.models.InternshipsSelesai
import id.a2.e_kp.models.SelesaiKP
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

        val adapter:laporanKpAdapter = laporanKpAdapter()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)


        val data =ArrayList<InternshipsSelesai>()


        recyclerView =binding.rvLaporan


        val client: KpClient = NetworkConfig().getService()
        val call: Call<SelesaiKP> = client.selesaikp("Bearer "+token)

        call.enqueue(object : Callback<SelesaiKP>{
            override fun onResponse(call: Call<SelesaiKP>, response: Response<SelesaiKP> ) {

                val respon: SelesaiKP? = response.body()
                if (respon!= null){
                    val list : List<InternshipsSelesai> = respon.internships as List<InternshipsSelesai>
                    adapter.setListMahasiswa(list)
                }

                    Log.d("success", response.toString()
                    )
            }

            override fun onFailure(call: Call<SelesaiKP>, t: Throwable) {
                Toast.makeText(this@LaporanActivity, t.localizedMessage,
                    Toast.LENGTH_SHORT).show()
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : laporanKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val DetailLaporanKpActivity = Intent (applicationContext, DetailLaporanKpActivity::class.java)

                startActivity(DetailLaporanKpActivity)
            }
        })


    }

}