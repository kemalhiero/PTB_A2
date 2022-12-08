package id.a2.e_kp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.a2.e_kp.databinding.ActivityDetailUsulanKpBinding

class DetailUsulanKpActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailUsulanKpBinding

    private val CHANNEL_ID = "channel_id_example1"
    private val notificationId = 100
    private val namaNotif = "Usulan KP"
    private val deskripsiNotif = "KP nya diterima atau tidak"

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
            //Toast.makeText(this@DetailUsulanKpActivity, "Tolak usulan ${getNama}", Toast.LENGTH_SHORT).show()
            showNotifTolak()
        }

        lateinit var ivTerimaUsulan: ImageView
        ivTerimaUsulan = binding.ivTerimaUsulan
        ivTerimaUsulan.setOnClickListener{
            //Toast.makeText(this@DetailUsulanKpActivity, "Terima usulan ${getNama}", Toast.LENGTH_SHORT).show()
            showNotifTerima()
        }

    }

    private fun showNotifTolak(){
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
            val intent = Intent(this, UsulanKpActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon_laporan_kp)
                .setContentTitle("Usulan Ditolak1!1!1")
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

    private fun showNotifTerima(){
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
            val intent = Intent(this, UsulanKpActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon_laporan_kp)
                .setContentTitle("Usulan Diterima 👍")
                .setContentText("Selamat Yaa")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(notificationId, builder.build())
            }
        }
    }
}