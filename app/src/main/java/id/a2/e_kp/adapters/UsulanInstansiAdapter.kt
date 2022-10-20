package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.UsulanInstansi

class UsulanInstansiAdapter(private val data:ArrayList<UsulanInstansi>):
    RecyclerView.Adapter<UsulanInstansiAdapter.UsulanInstansiViewHolder>() {

    inner class UsulanInstansiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val namaPerusahaan:TextView = itemView.findViewById(R.id.tvNamaPerusahaan)
        //private val status: ImageView = itemView.findViewById(R.id.ivStatusUsulanInstansi)

        fun bind(data:UsulanInstansi){
            namaPerusahaan.text = data.nama
            //status.setImageResource(R.drawable.ikon_y_petak)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsulanInstansiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usulan_instansi, parent, false)
        return UsulanInstansiViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsulanInstansiViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}