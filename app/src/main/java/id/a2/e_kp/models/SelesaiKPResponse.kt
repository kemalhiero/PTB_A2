package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName

data class SelesaiKPResponse(
    @field:SerializedName("internships")
    val internships: List<InternshipsItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)
