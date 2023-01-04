package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.UsulanKpAdapter
import id.a2.e_kp.databinding.ActivityUsulanKpBinding
import id.a2.e_kp.models.ListUsulanProposalResponse

class UsulanKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UsulanKpAdapter
    lateinit var binding: ActivityUsulanKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val data =ArrayList<ListUsulanProposalResponse>()

        recyclerView = binding.rvUsulanKP
        adapter = UsulanKpAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : UsulanKpAdapter.ClickListener{
            override fun onItemClick(position: Int) {
                val detailUsulan = Intent (this@UsulanKpActivity, DetailUsulanKpActivity::class.java)
                detailUsulan.putExtra("namaMahasiswa", data[position].proposals?.get(0)?.id)
                startActivity(detailUsulan)
            }
        })

    }

}