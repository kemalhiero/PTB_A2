package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.laporanKpAdapter
import id.a2.e_kp.databinding.ActivityLaporanBinding
import id.a2.e_kp.models.laporanKp

class LaporanActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: laporanKpAdapter
    lateinit var binding: ActivityLaporanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data =ArrayList<laporanKp>()

        data.add(laporanKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(laporanKp(1,null,"Delicia Syifa", "201152027"))
        data.add(laporanKp(1,null,"Kemal Muhammad", "2011523019"))
        data.add(laporanKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(laporanKp(1,null,"Delicia Syifa", "201152027"))
        data.add(laporanKp(1,null,"Kemal Muhammad", "2011523019"))
        data.add(laporanKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(laporanKp(1,null,"Delicia Syifa", "201152027"))
        data.add(laporanKp(1,null,"Kemal Muhammad", "2011523019"))

        recyclerView =binding.rvLaporan
        adapter = laporanKpAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : laporanKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val DetailLaporanKpActivity = Intent (this@LaporanActivity, DetailLaporanKpActivity::class.java)
                DetailLaporanKpActivity.putExtra("namaMahasiswa",data[position].nama)
                DetailLaporanKpActivity.putExtra("nimMahasiswa",data[position].nim)
                startActivity(DetailLaporanKpActivity)
            }
        })

    }

}