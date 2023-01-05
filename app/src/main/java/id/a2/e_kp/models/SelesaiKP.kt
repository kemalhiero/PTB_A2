package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName


data class SelesaiKP (

  @field:SerializedName("status"      ) val status      : String?                = null,
  @field:SerializedName("count"       ) val count       : Int?                   = null,
  @field:SerializedName("internships" ) val internships : ArrayList<InternshipsSelesai> = arrayListOf()

) {

}