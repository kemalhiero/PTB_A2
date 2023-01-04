package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName

data class DetailUsulanProposalResponse(

    @field:SerializedName("end_at")
    val endAt: String? = null,

    @field:SerializedName("jumlah")
    val jumlah: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("students")
    val students: List<Any?>? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("start_at")
    val startAt: String? = null,

    @field:SerializedName("status")
    val status: Any? = null
)