package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.adapters.UsulanInstansiAdapter
import id.a2.e_kp.models.UsulanInstansi

class UsulanInstansiActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UsulanInstansiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usulan_instansi)

        val data=ArrayList<UsulanInstansi>()
        data.add(UsulanInstansi(1, "Google", true))
        data.add(UsulanInstansi(2, "Amazon", false))
        data.add(UsulanInstansi(3, "Telkom", false))
        data.add(UsulanInstansi(4, "Asus", false))

        recyclerView=findViewById(R.id.rvUsulanInstansi)
        adapter = UsulanInstansiAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}