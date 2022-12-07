package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.a2.e_kp.databinding.ActivityPersetujuanNilaiBinding

class PersetujuanNilaiActivity : AppCompatActivity() {

    lateinit var binding: ActivityPersetujuanNilaiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersetujuanNilaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("nama")
        binding.tvNamaMhsPersetujuanNilai.text = getNama.toString()
        val getNim = intent.getStringExtra("nim")
        binding.tvNimMhsPersetujuanNilai.text = getNim.toString()

    }
}