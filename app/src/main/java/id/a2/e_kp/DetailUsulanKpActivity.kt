package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import id.a2.e_kp.databinding.ActivityDetailUsulanKpBinding

class DetailUsulanKpActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailUsulanKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUsulanKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("namaMahasiswa")
        binding.tvDetailMhsKpNama.text = getNama.toString()
        val getNim = intent.getStringExtra("nimMahasiswa")
        binding.tvDetailMhsKpNim.text = getNim.toString()

        lateinit var ivTolakUsulan: ImageView
        ivTolakUsulan = binding.ivTolakUsulan
        ivTolakUsulan.setOnClickListener{
            Toast.makeText(this@DetailUsulanKpActivity, "Tolak usulan ${getNama}", Toast.LENGTH_SHORT).show()
        }

        lateinit var ivTerimaUsulan: ImageView
        ivTerimaUsulan = binding.ivTerimaUsulan
        ivTerimaUsulan.setOnClickListener{
            Toast.makeText(this@DetailUsulanKpActivity, "Terima usulan ${getNama}", Toast.LENGTH_SHORT).show()
        }

    }
}