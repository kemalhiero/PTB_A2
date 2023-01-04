package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName

data class ProposalsItem(

    @field:SerializedName("end_at")
    val endAt: String? = null,

    @field:SerializedName("num")
    val num: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("start_at")
    val startAt: String? = null
)