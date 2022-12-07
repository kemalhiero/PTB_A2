package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.a2.e_kp.databinding.ActivityDetailLogKpBinding

class DetailLogKpActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailLogKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLogKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("nama")
        binding.tvNamaMhsDetailLog.text = getNama.toString()
        val getNim = intent.getStringExtra("nim")
        binding.tvNimMhsDetailLog.text = getNim.toString()
    }
}