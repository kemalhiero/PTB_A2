package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.models.ListPerusahaanResponse

class ListPerusahaanAdapter(private val data:ArrayList<ListPerusahaanResponse>):
    RecyclerView.Adapter<ListPerusahaanAdapter.ListPerusahaanViewHolder>() {

    class ListPerusahaanViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.tvNamaListPerusahaan)
        val alamat: TextView = itemView.findViewById((R.id.tvAlamatListPerusahaan))
        val status: TextView = itemView.findViewById((R.id.tvStatusListPerusahaan))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPerusahaanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_perusahaan, parent, false)
        return ListPerusahaanViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPerusahaanViewHolder, position: Int) {
        holder.nama.text =
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}