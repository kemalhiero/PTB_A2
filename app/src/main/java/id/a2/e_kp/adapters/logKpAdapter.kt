package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.LogKp

class logKpAdapter(private val data:ArrayList<LogKp>):
    RecyclerView.Adapter<logKpAdapter.logKpViewHolder>(){

    private lateinit var logKpListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        logKpListener = listener
    }

    inner class logKpViewHolder(itemView: View, listener: logKpAdapter.clickListener):RecyclerView.ViewHolder(itemView) {
        private val tanggal : TextView = itemView.findViewById(R.id.tvTglLogbook)

        fun bind(data:LogKp){
            tanggal.text = data.tanggal
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): logKpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_log_kp, parent, false)
        return logKpViewHolder(view, logKpListener)
    }

    override fun onBindViewHolder(holder: logKpViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}