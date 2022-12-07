package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import id.a2.e_kp.databinding.ActivityDetailMahasiswaKpBinding

class DetailMahasiswaKpActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailMahasiswaKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMahasiswaKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("namaMahasiswa")
        binding.tvDetailMhsKpNama.text = getNama.toString()
        val getNim = intent.getStringExtra("nimMahasiswa")
        binding.tvDetailMhsKpNim.text = getNim.toString()

        lateinit var btnPembimbingKp : Button
        btnPembimbingKp  = binding.buttonPembimbingKp
        btnPembimbingKp.setOnClickListener{
            intent = Intent(applicationContext, DosenPembimbingActivity::class.java)
            startActivity(intent)
        }

        lateinit var btnLogbookKp : Button
        btnLogbookKp  = binding.buttonLogbookKp
        btnLogbookKp.setOnClickListener{

            val nama = binding.tvDetailMhsKpNama.text.toString()
            val nim = binding.tvDetailMhsKpNim.text.toString()

            intent = Intent(applicationContext, LogbookKpActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("nim", nim)
            startActivity(intent)
        }

        lateinit var btnSeminarKp : Button
        btnSeminarKp  = binding.buttonSeminarKp
        btnSeminarKp.setOnClickListener{

            val nama = binding.tvDetailMhsKpNama.text.toString()
            val nim = binding.tvDetailMhsKpNim.text.toString()

            intent = Intent(applicationContext, SeminarKpActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("nim", nim)
            startActivity(intent)
        }

        lateinit var btnNilaiKp : Button
        btnNilaiKp  = binding.buttonNilaiKp
        btnNilaiKp.setOnClickListener{

            val nama = binding.tvDetailMhsKpNama.text.toString()
            val nim = binding.tvDetailMhsKpNim.text.toString()

            intent = Intent(applicationContext, PersetujuanNilaiActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("nim", nim)
            startActivity(intent)
        }

        lateinit var btnInstansi : Button
        btnInstansi = binding.buttonInstansi
        btnInstansi.setOnClickListener{

            val nama = binding.tvDetailMhsKpNama.text.toString()
            val nim = binding.tvDetailMhsKpNim.text.toString()

            val intent = Intent(applicationContext, UsulanInstansiActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("nim", nim)
            startActivity(intent)
        }

        lateinit var btnBatalkanKp : Button
        btnBatalkanKp = binding.btnBatalkanKp
        btnBatalkanKp.setOnClickListener{
            Toast.makeText(this@DetailMahasiswaKpActivity, "Batalkan KP ${getNama}", Toast.LENGTH_SHORT).show()
        }

    }

}