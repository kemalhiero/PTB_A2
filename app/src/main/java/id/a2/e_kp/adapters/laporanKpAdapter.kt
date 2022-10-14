package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.laporanKp


class laporanKpAdapter(private val data:ArrayList<laporanKp>):
        RecyclerView.Adapter<laporanKpAdapter.laporanKpViewHolder>() {

        private lateinit var laporanKpListener: clickListener

        interface clickListener {
            fun onItemClick(position: Int)
        }

        fun setOnClickListener(listener: clickListener) {
            laporanKpListener = listener
        }

        inner class laporanKpViewHolder(itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView) {
            private val nama: TextView =itemView.findViewById(R.id.tvnamamhsLaporan)
            private val nim: TextView = itemView.findViewById(R.id.tvnimLaporan)

            fun bind(data: laporanKp){
                nama.text = data.nama
                nim.text = data.nim
            }

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
            holder.bind(data[position])
        }

        override fun getItemCount(): Int {
            return data.size
        }


    }