package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SeminarKpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar_kp)

        lateinit var button : Button
        button  = findViewById(R.id.buttonDaftarSeminarKp)
        button.setOnClickListener{
            intent = Intent(applicationContext, DaftarSeminarKpActivity::class.java)
            startActivity(intent)
        }
    }
}