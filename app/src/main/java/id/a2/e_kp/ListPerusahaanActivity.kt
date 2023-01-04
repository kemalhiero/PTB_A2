package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.ListPerusahaanAdapter
import id.a2.e_kp.databinding.ActivityListPerusahaanBinding
import id.a2.e_kp.models.CompaniesItem
import id.a2.e_kp.models.ListPerusahaanResponse
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPerusahaanActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListPerusahaanAdapter
    lateinit var binding: ActivityListPerusahaanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPerusahaanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progresBar = binding.progressBarListPerusahaan
        progresBar.visibility = View.GONE

        val adapter: ListPerusahaanAdapter = ListPerusahaanAdapter()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)

        val data =ArrayList<CompaniesItem>()

        recyclerView =binding.rvListPerusahaan


        val client: KpClient = NetworkConfig().getService()
        progresBar.visibility = View.VISIBLE

        val call: Call<ListPerusahaanResponse> = client.listPerusahaan("Bearer "+token)

        call.enqueue(object : Callback<ListPerusahaanResponse>{
            override fun onResponse( call: Call<ListPerusahaanResponse>, response: Response<ListPerusahaanResponse> ) {

                val respon: ListPerusahaanResponse? = response.body()
                if (respon!= null){
                    val list : List<CompaniesItem> = respon.companies as List<CompaniesItem>
                    adapter.setListIntansi(list)
                    progresBar.visibility = View.GONE
                }
                Log.d("anjay", response.toString())
            }

            override fun onFailure(call: Call<ListPerusahaanResponse>, t: Throwable) {
                progresBar.visibility = View.GONE
                Toast.makeText(this@ListPerusahaanActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : ListPerusahaanAdapter.clickListener{
            override fun onItemClick(position: Int) {

                val intentt = Intent (this@ListPerusahaanActivity, AccRejectPerusahaanActivity::class.java)
//                intentt.putExtra("nama",data.get(position).name)
//                intentt.putExtra("alamat",data.get(position).address)
                Toast.makeText(this@ListPerusahaanActivity,data.toString(),Toast.LENGTH_SHORT).show()
                startActivity(intentt)
            }
        })

    }

}