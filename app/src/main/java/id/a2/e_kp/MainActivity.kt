package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import id.a2.e_kp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var cardViewUsulanKp: CardView
        cardViewUsulanKp = binding.cardViewUsulanKp
        cardViewUsulanKp.setOnClickListener {
            intent = Intent(applicationContext, UsulanKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var cardViewMahasiswaKp: CardView
        cardViewMahasiswaKp = binding.cardViewMahasiswaKp
        cardViewMahasiswaKp.setOnClickListener {
            intent = Intent(applicationContext, MahasiswaKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var cardViewLaporanKp: CardView
        cardViewLaporanKp = binding.cardViewLaporanKp
        cardViewLaporanKp.setOnClickListener {
            intent = Intent(applicationContext, LaporanActivity::class.java)
            startActivity(intent)
        }
    }

}