package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.MahasiswaKp



class MahasiswaKpAdapter (private val data:ArrayList<MahasiswaKp>):
    RecyclerView.Adapter<MahasiswaKpAdapter.MahasiswaKpViewHolder>(){
    private lateinit var MahasiswaKpListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        MahasiswaKpListener = listener
    }

    inner class MahasiswaKpViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val nama:TextView =itemView.findViewById(R.id.textViewNamaMahasiswaKp)
        private val nim:TextView = itemView.findViewById(R.id.textViewNimMahasiswaKp)

        fun bind(data: MahasiswaKp){
            nama.text = data.nama
            nim.text = data.nim
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaKpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa_kp, parent, false)
        return MahasiswaKpViewHolder(view, MahasiswaKpListener)
    }

    override fun onBindViewHolder(holder: MahasiswaKpViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}