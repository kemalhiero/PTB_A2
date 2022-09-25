package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.a2.e_kp.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val laporanFragment = LaporanFragment()

        setCurrentFragment(homeFragment)

        val naview:BottomNavigationView = findViewById(R.id.navView)
        naview.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> setCurrentFragment(homeFragment)
                R.id.navigation_laporan -> setCurrentFragment(laporanFragment)
            }
            true
        }


    }


    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flFragment, fragment)
            commit()
        }
}