package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.MahasiswaKpAdapter
import id.a2.e_kp.databinding.ActivityMahasiswaKpBinding
import id.a2.e_kp.models.MahasiswaKp

class MahasiswaKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MahasiswaKpAdapter
    lateinit var binding: ActivityMahasiswaKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMahasiswaKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val data =ArrayList<MahasiswaKp>()
        data.add(MahasiswaKp(1,null,"Hagi Siraj", "2011521015"))
        data.add(MahasiswaKp(1,null,"Delicia Syifa", "201152027"))
        data.add(MahasiswaKp(1,null,"Kemal Muhammad", "2011523019"))

        recyclerView =binding.rvMahasiswaKP
        adapter = MahasiswaKpAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : MahasiswaKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val detailMahasiswa = Intent (this@MahasiswaKpActivity, DetailMahasiswaKpActivity::class.java)
                detailMahasiswa.putExtra("namaMahasiswa", data[position].nama)
                detailMahasiswa.putExtra("nimMahasiswa", data[position].nim)
                startActivity(detailMahasiswa)
            }
        })

    }

}