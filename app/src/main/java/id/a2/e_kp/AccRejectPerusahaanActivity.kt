package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.a2.e_kp.databinding.ActivityAccRejectPerusahaanBinding

class AccRejectPerusahaanActivity : AppCompatActivity() {

    lateinit var binding: ActivityAccRejectPerusahaanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccRejectPerusahaanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("nama")
        binding.tvNamaPerusahaanAccReject.text = getNama.toString()
    }
}