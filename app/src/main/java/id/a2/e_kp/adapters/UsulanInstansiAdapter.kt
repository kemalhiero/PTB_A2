package id.a2.e_kp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.a2.e_kp.R
import id.a2.e_kp.databinding.ItemUsulanInstansiBinding
import id.a2.e_kp.models.UsulanInstansi

class UsulanInstansiAdapter(private val data:ArrayList<UsulanInstansi>):
    RecyclerView.Adapter<UsulanInstansiAdapter.UsulanInstansiViewHolder>() {

    inner class UsulanInstansiViewHolder(val itemBinding: ItemUsulanInstansiBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(data:UsulanInstansi){
            itemBinding.tvNamaPerusahaan.text = data.nama
            if(data.status==true){
                itemBinding.ivStatusUsulanInstansi.setImageResource(R.drawable.ikon_y_petak)
            }else{
                itemBinding.ivStatusUsulanInstansi.setImageResource(R.drawable.ikon_x_petak)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsulanInstansiViewHolder {
        val view = ItemUsulanInstansiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsulanInstansiViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsulanInstansiViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}