package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.MahasiswaKpAdapter
import id.a2.e_kp.databinding.ActivityMahasiswaKpBinding
import id.a2.e_kp.models.InternshipsItem
import id.a2.e_kp.models.SelesaiKPResponse
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MahasiswaKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MahasiswaKpAdapter
    lateinit var binding: ActivityMahasiswaKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMahasiswaKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter:MahasiswaKpAdapter= MahasiswaKpAdapter()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)

        val data = ArrayList<InternshipsItem>()

        recyclerView = binding.rvMahasiswaKP

        val client: KpClient = NetworkConfig().getService()
        val call: Call<SelesaiKPResponse> = client.selesaikp("Bearer "+ token)

        call.enqueue(object : Callback<SelesaiKPResponse>{
            override fun onResponse( call: Call<SelesaiKPResponse>, response: Response<SelesaiKPResponse>) {

                val respon: SelesaiKPResponse? = response.body()
                if (respon!= null){
                    val list : List<InternshipsItem> = respon.internships as List<InternshipsItem>
                    adapter.setListMahasiswa(list)
                }


                Log.d("anjay", response.toString())
            }

            override fun onFailure(call: Call<SelesaiKPResponse>, t: Throwable) {
                Toast.makeText(this@MahasiswaKpActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : MahasiswaKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val detailMahasiswa = Intent (this@MahasiswaKpActivity, DetailMahasiswaKpActivity::class.java)
                detailMahasiswa.putExtra("namaMahasiswa", data[position].name)
                detailMahasiswa.putExtra("nimMahasiswa", data[position].nim)
                startActivity(detailMahasiswa)
            }
        })

    }

}