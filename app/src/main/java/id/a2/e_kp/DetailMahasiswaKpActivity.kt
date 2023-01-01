package id.a2.e_kp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.a2.e_kp.databinding.ActivityDetailMahasiswaKpBinding

class DetailMahasiswaKpActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailMahasiswaKpBinding

    private val CHANNEL_ID = "notifBatalKP"
    private val notificationId = 100
    private val namaNotif = "Batalkan KP"
    private val deskripsiNotif = "KP nya dibatalkan"

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
            //Toast.makeText(this@DetailMahasiswaKpActivity, "Batalkan KP ${getNama}", Toast.LENGTH_SHORT).show()
            showNotifKpBatal()
        }

    }

    private fun showNotifKpBatal(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = namaNotif
            val descriptionText = deskripsiNotif
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply{
                description = descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            // Create an explicit intent for an Activity in your app
            val intent = Intent(this, DetailMahasiswaKpActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo_unand_ketek)
                .setContentTitle("KP ini dibatalkan")
                .setContentText("Mohon maaf🙏")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(notificationId, builder.build())
            }
        }
    }

}