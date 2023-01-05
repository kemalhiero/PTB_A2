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
import id.a2.e_kp.adapters.UsulanKpAdapter
import id.a2.e_kp.databinding.ActivityUsulanKpBinding
import id.a2.e_kp.models.ListUsulanProposalResponse
import id.a2.e_kp.models.ProposalsItem
import id.a2.e_kp.network.KpClient
import id.a2.e_kp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsulanKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UsulanKpAdapter
    lateinit var binding: ActivityUsulanKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progresBar = binding.progressBarUsulanKP
        progresBar.visibility = View.GONE

        val adapter: UsulanKpAdapter = UsulanKpAdapter()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val data =ArrayList<ProposalsItem>()

        recyclerView = binding.rvUsulanKP

        val client: KpClient = NetworkConfig().getService()
        progresBar.visibility = View.VISIBLE

        val call: Call<ListUsulanProposalResponse> = client.listUsulanProposal("Bearer "+ada)

        call.enqueue(object: Callback<ListUsulanProposalResponse>{
            override fun onResponse(
                call: Call<ListUsulanProposalResponse>,
                response: Response<ListUsulanProposalResponse>
            ) {
                val respon: ListUsulanProposalResponse? = response.body()
                if (respon!= null){
                    val list : List<ProposalsItem> = respon.proposals as List<ProposalsItem>
                    adapter.setListUsulan(list)
                    progresBar.visibility = View.GONE
                }
                Log.d("anjay usulan", response.toString())

                adapter.setOnClickListener(object : UsulanKpAdapter.ClickListener{
                    override fun onItemClick(position: Int) {
                        val intentt = Intent (this@UsulanKpActivity, DetailUsulanKpActivity::class.java)
//                intentt.putExtra("namaMahasiswa", data[position].name)
//                Toast.makeText(this@UsulanKpActivity,data[position].name.toString(),Toast.LENGTH_LONG).show()
                        startActivity(intentt)
                    }
                })

            }

            override fun onFailure(call: Call<ListUsulanProposalResponse>, t: Throwable) {
                progresBar.visibility = View.GONE
                Toast.makeText(this@UsulanKpActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter



    }

}