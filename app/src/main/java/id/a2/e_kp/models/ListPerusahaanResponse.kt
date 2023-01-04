package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName

data class ListPerusahaanResponse(

    @field:SerializedName("companies")
    val companies: List<CompaniesItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)