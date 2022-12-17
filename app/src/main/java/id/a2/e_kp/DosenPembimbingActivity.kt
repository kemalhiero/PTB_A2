package id.a2.e_kp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import id.a2.e_kp.databinding.ActivityDosenPembimbingBinding

class DosenPembimbingActivity : AppCompatActivity() {

    lateinit var binding: ActivityDosenPembimbingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDosenPembimbingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pilihDosen: AutoCompleteTextView = binding.pilihDosen
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