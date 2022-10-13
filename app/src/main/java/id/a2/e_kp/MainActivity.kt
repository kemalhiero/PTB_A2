package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var cardViewUsulanKp: CardView
        cardViewUsulanKp = findViewById(R.id.cardViewUsulanKp)
        cardViewUsulanKp.setOnClickListener {
            intent = Intent(applicationContext, UsulanKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var cardViewMahasiswaKp: CardView
        cardViewMahasiswaKp = findViewById(R.id.cardViewMahasiswaKp)
        cardViewMahasiswaKp.setOnClickListener {
            intent = Intent(applicationContext, MahasiswaKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var cardViewLaporanKp: CardView
        cardViewLaporanKp = findViewById(R.id.cardViewLaporanKp)
        cardViewLaporanKp.setOnClickListener {
            intent = Intent(applicationContext, LaporanActivity::class.java)
            startActivity(intent)
        }
    }

}