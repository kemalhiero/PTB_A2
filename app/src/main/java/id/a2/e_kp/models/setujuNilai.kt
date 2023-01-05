package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName


data class setujuNilai (

    @SerializedName("status") var status  : String? = null,
    @field:SerializedName("message")
    val message: String? = null

)