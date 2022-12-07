package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.DaftarSeminar


class DaftarSeminarAdapter(private val data:ArrayList<DaftarSeminar>):
    RecyclerView.Adapter<DaftarSeminarAdapter.DaftarSeminarViewHolder>() {


    inner class DaftarSeminarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nama: TextView =itemView.findViewById(R.id.tvNamaPesertaSeminarKp)
        private val nim: TextView = itemView.findViewById(R.id.tvNimPesertaSeminarKp)

        fun bind(data: DaftarSeminar){
            nama.text = data.nama
            nim.text = data.nim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaftarSeminarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daftar_seminar, parent, false)
        return DaftarSeminarViewHolder(view)
    }

    override fun onBindViewHolder(holder: DaftarSeminarViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}