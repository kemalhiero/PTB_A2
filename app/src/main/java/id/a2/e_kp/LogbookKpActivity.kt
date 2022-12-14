package id.a2.e_kp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.logKpAdapter
import id.a2.e_kp.databinding.ActivityLogbookKpBinding
import id.a2.e_kp.models.LogKp

class LogbookKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: logKpAdapter
    lateinit var binding: ActivityLogbookKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogbookKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val getNama = intent.getStringExtra("nama")
        binding.tvNamaMhsListLog.text = getNama.toString()
        val getNim = intent.getStringExtra("nim")
        binding.tvNimMhsLogKp.text = getNim.toString()

        val data=ArrayList<LogKp>()
        data.add(LogKp(1,"7 September 2022", "Membuat folder","14.00", "Wahyudi"))
        data.add(LogKp(1,"8 September 2022", "Membuat file","14.00", "Hags"))
        data.add(LogKp(1,"9 September 2022", "Membuat folder","14.00", "Wahyudi"))
        data.add(LogKp(1,"10 September 2022", "Membuat file","14.00", "JKS"))

        recyclerView =binding.rvLogKp
        adapter = logKpAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : logKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val detailLog = Intent(this@LogbookKpActivity, DetailLogKpActivity::class.java)
                detailLog.putExtra("nama", getNama)
                detailLog.putExtra("nim", getNim)
                startActivity(detailLog)
            }
        })

    }
}