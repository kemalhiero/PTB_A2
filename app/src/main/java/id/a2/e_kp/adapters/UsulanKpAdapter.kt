package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.databinding.ItemUsulanKpBinding
import id.a2.e_kp.models.ListUsulanProposalResponse
import id.a2.e_kp.models.UsulanKp

class UsulanKpAdapter(private val data:ArrayList<ListUsulanProposalResponse>):
    RecyclerView.Adapter<UsulanKpAdapter.UsulanKpViewHolder>() {

    private lateinit var usulanKpListener: ClickListener

    interface ClickListener {
        fun onItemClick(position: Int)//objek usulankp
    }

    fun setOnClickListener(listener: ClickListener) {
        usulanKpListener = listener
    }

    inner class UsulanKpViewHolder(val itemBinding: ItemUsulanKpBinding, listener: ClickListener):RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: ListUsulanProposalResponse){
            itemBinding.tvUsulanPerusahaanKP.text = data.proposals?.get(0)?.name
            itemBinding.tvUsulanMulaiKp.text = data.proposals?.get(0)?.startAt
            itemBinding.tvUsulanSelesaiKp.text = data.proposals?.get(0)?.endAt
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsulanKpViewHolder {
        val view = ItemUsulanKpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsulanKpViewHolder(view, usulanKpListener)
    }

    override fun onBindViewHolder(holder: UsulanKpViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


}