package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.ProposalsItem

class UsulanKpAdapter():
    RecyclerView.Adapter<UsulanKpAdapter.UsulanKpViewHolder>() {

    private lateinit var usulanKpListener: ClickListener

    var listUsulannnn: List<ProposalsItem> = ArrayList()

    fun setListUsulan(listUsulan: List<ProposalsItem>){
        this.listUsulannnn = listUsulan
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onItemClick(position: Int)//objek usulankp
    }

    fun setOnClickListener(listener: ClickListener) {
        usulanKpListener = listener
    }

    inner class UsulanKpViewHolder(itemView: View, listener: ClickListener):RecyclerView.ViewHolder(itemView) {

        val perusahaan: TextView = itemView.findViewById(R.id.tvUsulanPerusahaanKP)
        val mulai: TextView = itemView.findViewById(R.id.tvUsulanMulaiKp)
        val selesai: TextView = itemView.findViewById(R.id.tvUsulanSelesaiKp)


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
        val item:ProposalsItem = listUsulannnn.get(position)
        holder.perusahaan.text = item.name
        holder.mulai.text = item.startAt
        holder.selesai.text = item.endAt
    }

    override fun getItemCount(): Int {
        return listUsulannnn.size
    }


}