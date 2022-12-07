package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import id.a2.e_kp.databinding.ActivitySeminarKpBinding

class SeminarKpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySeminarKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeminarKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("nama")
        binding.tvNamaMhsSeminar.text = getNama.toString()
        val getNim = intent.getStringExtra("nim")
        binding.tvNimMhsSeminar.text = getNim.toString()

        lateinit var button : Button
        button  = binding.buttonDaftarSeminarKp
        button.setOnClickListener{
            intent = Intent(applicationContext, DaftarSeminarKpActivity::class.java)
            startActivity(intent)
        }
    }
}