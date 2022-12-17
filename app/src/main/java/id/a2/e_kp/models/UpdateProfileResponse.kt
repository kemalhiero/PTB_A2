package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName

data class UpdateProfileResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)