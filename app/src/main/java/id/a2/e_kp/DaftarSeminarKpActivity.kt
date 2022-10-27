package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.DaftarSeminarAdapter
import id.a2.e_kp.databinding.ActivityDaftarSeminarKpBinding
import id.a2.e_kp.models.DaftarSeminar

class DaftarSeminarKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DaftarSeminarAdapter
    lateinit var binding: ActivityDaftarSeminarKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarSeminarKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data =ArrayList<DaftarSeminar>()
        data.add(DaftarSeminar(1,null,"Hagi Siraj", "2011521015"))
        data.add(DaftarSeminar(1,null,"Delicia Syifa", "2011522027"))
        data.add(DaftarSeminar(1,null,"Kemal Muhammad", "2011523019"))

        recyclerView =binding.rvDaftarSeminar
        adapter = DaftarSeminarAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}