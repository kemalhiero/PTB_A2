package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName

data class ListUsulanProposalResponse(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("proposals")
    val proposals: List<ProposalsItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
)