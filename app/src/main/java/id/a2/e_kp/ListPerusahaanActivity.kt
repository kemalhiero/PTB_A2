package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.databinding.ActivityLaporanBinding
import id.a2.e_kp.databinding.ActivityListPerusahaanBinding

class ListPerusahaanActivity : AppCompatActivity() {

    lateinit var binding: ActivityListPerusahaanBinding
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPerusahaanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvListPerusahaan
    }
}