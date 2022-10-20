package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailMahasiswaKpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mahasiswa_kp)

        lateinit var btnPembimbingKp : Button
        btnPembimbingKp  = findViewById(R.id.buttonPembimbingKp)
        btnPembimbingKp.setOnClickListener{
            intent = Intent(applicationContext, DosenPembimbingActivity::class.java)
            startActivity(intent)
        }

        lateinit var btnLogbookKp : Button
        btnLogbookKp  = findViewById(R.id.buttonLogbookKp)
        btnLogbookKp.setOnClickListener{
            intent = Intent(applicationContext, LogbookKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var buttonInstansi : Button
        buttonInstansi = findViewById(R.id.buttonInstansi)
        buttonInstansi.setOnClickListener{
            intent = Intent(applicationContext, UsulanInstansiActivity::class.java)
            startActivity(intent)
        }

        lateinit var btnSeminarKp : Button
        btnSeminarKp  = findViewById(R.id.buttonSeminarKp)
        btnSeminarKp.setOnClickListener{
            intent = Intent(applicationContext, SeminarKpActivity::class.java)
            startActivity(intent)
        }

        lateinit var btnNilaiKp : Button
        btnNilaiKp  = findViewById(R.id.buttonNilaiKp)
        btnNilaiKp.setOnClickListener{
            intent = Intent(applicationContext, PersetujuanNilaiActivity::class.java)
            startActivity(intent)
        }

    }

}