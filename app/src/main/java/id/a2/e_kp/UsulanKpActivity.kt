package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.UsulanKpAdapter
import id.a2.e_kp.databinding.ActivityUsulanKpBinding
import id.a2.e_kp.models.UsulanKp

class UsulanKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UsulanKpAdapter
    lateinit var binding: ActivityUsulanKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data =ArrayList<UsulanKp>()
        data.add(UsulanKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(UsulanKp(1,null,"Delicia Syifa", "201152027"))
        data.add(UsulanKp(1,null,"Kemal Muhammad", "2011523019"))
        data.add(UsulanKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(UsulanKp(1,null,"Delicia Syifa", "201152027"))
        data.add(UsulanKp(1,null,"Kemal Muhammad", "2011523019"))
        data.add(UsulanKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(UsulanKp(1,null,"Delicia Syifa", "201152027"))
        data.add(UsulanKp(1,null,"Kemal Muhammad", "2011523019"))

        recyclerView = binding.rvUsulanKP
        adapter = UsulanKpAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : UsulanKpAdapter.ClickListener{
            override fun onItemClick(position: Int) {
                val detailUsulan = Intent (this@UsulanKpActivity, DetailUsulanKpActivity::class.java)
                detailUsulan.putExtra("namaMahasiswa", data[position].nama)
                detailUsulan.putExtra("nimMahasiswa", data[position].nim)
                startActivity(detailUsulan)
            }
        })

    }

}