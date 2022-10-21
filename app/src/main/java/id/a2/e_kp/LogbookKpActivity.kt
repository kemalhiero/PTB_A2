package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.logKpAdapter
import id.a2.e_kp.models.LogKp

class LogbookKpActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: logKpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logbook_kp)

        val data=ArrayList<LogKp>()
        data.add(LogKp(1,"7 September 2022", "Membuat folder","14.00", "Wahyudi"))
        data.add(LogKp(1,"8 September 2022", "Membuat file","14.00", "Wahyudi"))
        data.add(LogKp(1,"9 September 2022", "Membuat folder","14.00", "Wahyudi"))
        data.add(LogKp(1,"10 September 2022", "Membuat file","14.00", "Wahyudi"))

        recyclerView =findViewById(R.id.rvLogKp)
        adapter = logKpAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object : logKpAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val detailLog = Intent(this@LogbookKpActivity, DetailLogKpActivity::class.java)
                startActivity(detailLog)
            }
        })

    }
}