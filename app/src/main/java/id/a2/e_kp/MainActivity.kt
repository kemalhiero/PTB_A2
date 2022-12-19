package id.a2.e_kp

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.cardview.widget.CardView
import id.a2.e_kp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var btnkeluar : Button


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnkeluar = findViewById(R.id.btnkeluar)
        btnkeluar.setOnClickListener {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setContentView(R.layout.custom_dialog)

            val btnyakin = dialog.findViewById<Button>(R.id.btnyakin)
            btnyakin.setOnClickListener{

                val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
                with (sharedPref.edit()) {
                    putString("token", null)
                    apply()
                }

                intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
                dialog.dismiss()
            }
            dialog.show()
        }

        val sharedPref = getSharedPreferences("prefs",Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


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

