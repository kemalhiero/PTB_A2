package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.MahasiswaKpAdapter
import id.a2.e_kp.models.MahasiswaKp

class MahasiswaKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MahasiswaKpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa_kp)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init(){
        recyclerView =findViewById(R.id.rvMahasiswaKP)

        val data =ArrayList<MahasiswaKp>()
        data.add(MahasiswaKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(MahasiswaKp(1,null,"Delicia Syifa", "201152027"))
        data.add(MahasiswaKp(1,null,"Kemal Muhammad", "2011523019"))

        adapter = MahasiswaKpAdapter(data)
        adapter.setOnClickListener(object : MahasiswaKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MahasiswaKpActivity, "Ini item no ${position + 1}", Toast.LENGTH_SHORT).show()
                val detailMahasiswa = Intent (this@MahasiswaKpActivity, DetailMahasiswaKpActivity::class.java)
                startActivity(detailMahasiswa)
            }
        })


    }
}