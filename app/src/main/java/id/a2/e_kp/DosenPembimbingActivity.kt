package id.a2.e_kp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class DosenPembimbingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dosen_pembimbing)

        val pilihDosen: AutoCompleteTextView = findViewById(R.id.pilihDosen)
        val listNumber = ArrayList<String>()
        listNumber.add("Husnil Kamil")
        listNumber.add("Surya Afnarius")
        listNumber.add("Hasdi Putra")
        listNumber.add("Dwi Welly Sukma")
        listNumber.add("Meza Silvana")

        val numberAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,listNumber)

        pilihDosen.setAdapter(numberAdapter)
        pilihDosen.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show()
        }


    }
}