package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.a2.e_kp.databinding.ActivityDetailLaporanBinding


class DetailLaporanKpActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailLaporanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getName = intent.getStringExtra("namaMahasiswa")
        binding.tvNamaMhsDetailLaporan.text = getName.toString()
        val getNim = intent.getStringExtra("nimMahasiswa")
        binding.tvNimMhsDetailLaporan.text = getNim.toString()

    }
}