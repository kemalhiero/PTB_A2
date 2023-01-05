package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.databinding.ItemMahasiswaKpBinding
import id.a2.e_kp.models.InternshipsItem
import id.a2.e_kp.models.MahasiswaKp

class MahasiswaKpAdapter ():
    RecyclerView.Adapter<MahasiswaKpAdapter.MahasiswaKpViewHolder>(){

    private lateinit var MahasiswaKpListener: clickListener

    var listMahasiswaa: List<InternshipsItem> = ArrayList()

    fun setListMahasiswa(listMahasiswa : List<InternshipsItem>){
        this.listMahasiswaa = listMahasiswa
        notifyDataSetChanged()
    }

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        MahasiswaKpListener = listener
    }

    inner class MahasiswaKpViewHolder(itemView : View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
            val nama : TextView = itemView.findViewById(R.id.tvNamaMahasiswaKp)
            val nim : TextView = itemView.findViewById(R.id.tvNimMahasiswaKp)


        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaKpViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa_kp, parent,false)
        return MahasiswaKpViewHolder(view, MahasiswaKpListener)
    }

    override fun onBindViewHolder(holder: MahasiswaKpViewHolder, position: Int) {
        val item : InternshipsItem = listMahasiswaa.get(position)
        holder.nama.text = item.name
        holder.nim.text = item.nim
    }

    override fun getItemCount(): Int {
        return listMahasiswaa.size
    }

}