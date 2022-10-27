package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.databinding.ItemMahasiswaKpBinding
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

    inner class MahasiswaKpViewHolder(val itemBinding: ItemMahasiswaKpBinding, listener: clickListener):RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: MahasiswaKp){
            itemBinding.tvNamaMahasiswaKp.text = data.nama
            itemBinding.tvNimMahasiswaKp.text = data.nim
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaKpViewHolder {
        val view = ItemMahasiswaKpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MahasiswaKpViewHolder(view, MahasiswaKpListener)
    }

    override fun onBindViewHolder(holder: MahasiswaKpViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}