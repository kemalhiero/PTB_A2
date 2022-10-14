package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.laporanKpAdapter
import id.a2.e_kp.models.laporanKp



class LaporanActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: laporanKpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        init()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

}

    private fun init(){
        recyclerView =findViewById(R.id.rvLaporan)

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
        data.add(laporanKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(laporanKp(1,null,"Delicia Syifa", "201152027"))
        data.add(laporanKp(1,null,"Kemal Muhammad", "2011523019"))


        adapter = laporanKpAdapter(data)
        adapter.setOnClickListener(object : laporanKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@LaporanActivity, "Ini item no ${position + 1}", Toast.LENGTH_SHORT).show()
                val detailLaporan = Intent (this@LaporanActivity, detailLaporan::class.java)
                startActivity(detailLaporan)
            }
        })

    }
}