package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.InternshipsSelesai


class laporanKpAdapter() :
    RecyclerView.Adapter<laporanKpAdapter.laporanKpViewHolder>() {

    private lateinit var laporanKpListener: clickListener

    var listMahasiswaa: List<InternshipsSelesai> = ArrayList()

    fun setListMahasiswa(listMahasiswa: List<InternshipsSelesai>){
        this.listMahasiswaa = listMahasiswa
        notifyDataSetChanged()
    }



    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        laporanKpListener = listener
    }

    inner class laporanKpViewHolder(itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView) {
        val name: TextView =itemView.findViewById(R.id.tvnamamhsLaporan)
        val nim: TextView = itemView.findViewById(R.id.tvnimLaporan)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): laporanKpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout_laporan, parent, false)
        return laporanKpViewHolder(view, laporanKpListener)
    }

    override fun onBindViewHolder(holder: laporanKpViewHolder, position: Int) {
        val item : InternshipsSelesai = listMahasiswaa.get(position)
        holder.name.text = item.name
        holder.nim.text = item.nim
    }

    override fun getItemCount(): Int {
        return listMahasiswaa.size
    }


}