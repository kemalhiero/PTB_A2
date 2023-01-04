package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.CompaniesItem

class ListPerusahaanAdapter():
RecyclerView.Adapter<ListPerusahaanAdapter.InstansiViewHolder>(){

    private lateinit var InstansiListener: clickListener

    var listIntansii: List<CompaniesItem> = ArrayList()

    fun setListIntansi(listIntansi: List<CompaniesItem>){
        this.listIntansii = listIntansi
        notifyDataSetChanged()
    }

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        InstansiListener = listener
    }

    inner class InstansiViewHolder(itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView){
        val nama: TextView =itemView.findViewById(R.id.tvNamaListPerusahaan)
        val alamat: TextView = itemView.findViewById(R.id.tvAlamatListPerusahaan)
        val status: TextView = itemView.findViewById(R.id.tvStatusListPerusahaan)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstansiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_perusahaan, parent, false)

        return InstansiViewHolder(view, InstansiListener)
    }

    override fun getItemCount(): Int {
        return listIntansii.size
    }

    override fun onBindViewHolder(holder: InstansiViewHolder, position: Int) {
        val item: CompaniesItem = listIntansii.get(position)
        holder.nama.text = item.name
        holder.alamat.text = item.address

        if (item.status==0){
            holder.status.text = "Di Blacklist"
        }else if(item.status==1){
            holder.status.text = "Baguss"
        }

    }
}

