package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.UsulanKp

class UsulanKpAdapter(private val data:ArrayList<UsulanKp>):
    RecyclerView.Adapter<UsulanKpAdapter.UsulanKpViewHolder>() {

    private lateinit var usulanKpListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)//objek usulankp
    }

    fun setOnClickListener(listener: clickListener) {
        usulanKpListener = listener
    }

    inner class UsulanKpViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val nama:TextView = itemView.findViewById(R.id.textViewNamaMahasiswaUsulanKp)
        private val nim:TextView = itemView.findViewById(R.id.textViewNimUsulanKp)

        fun bind(data: UsulanKp){
            nama.text = data.nama
            nim.text = data.nim
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsulanKpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usulan_kp, parent, false)
        return UsulanKpViewHolder(view, usulanKpListener)
    }

    override fun onBindViewHolder(holder: UsulanKpViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}