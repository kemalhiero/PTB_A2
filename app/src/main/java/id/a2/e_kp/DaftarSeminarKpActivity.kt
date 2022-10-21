package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.DaftarSeminarAdapter
import id.a2.e_kp.models.DaftarSeminar

class DaftarSeminarKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DaftarSeminarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_seminar_kp)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init(){
        recyclerView =findViewById(R.id.rvDaftarSeminar)

        val data =ArrayList<DaftarSeminar>()
        data.add(DaftarSeminar(1,null,"Hagi Siraj", "2011521015"))
        data.add(DaftarSeminar(1,null,"Delicia Syifa", "201152027"))
        data.add(DaftarSeminar(1,null,"Kemal Muhammad", "2011523019"))

        adapter = DaftarSeminarAdapter(data)
        adapter.setOnClickListener(object : DaftarSeminarAdapter.clickListener{
            override fun onItemClick(position: Int) {
              //  val detailSeminar = Intent (this@DaftarSeminarKpActivity, DetailSeminarActivity::class.java)
              //  startActivity(detailSeminar)
            }
        })


    }
}