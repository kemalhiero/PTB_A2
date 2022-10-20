package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailMahasiswaKpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mahasiswa_kp)

        lateinit var button : Button
        button  = findViewById(R.id.buttonPembimbingKp)
        button.setOnClickListener{
            intent = Intent(applicationContext, DosenPembimbingActivity::class.java)
            startActivity(intent)
        }

        lateinit var button1 : Button
        button1  = findViewById(R.id.buttonLogbookKp)
        button1.setOnClickListener{
            intent = Intent(applicationContext, LogbookKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var button4 : Button
        button4  = findViewById(R.id.buttonNilaiKp)
        button4.setOnClickListener{
            intent = Intent(applicationContext, PersetujuanNilaiActivity::class.java)
            startActivity(intent)
        }

    }

}