package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName


data class Internships_selesai (

  @field:SerializedName("id"            ) val id           : Int?    = null,
  @field:SerializedName("name"          ) val name         : String? = null,
  @field:SerializedName("nim"           ) val nim          : String? = null,
  @field:SerializedName("agency"        ) val agency       : String? = null,
  @field:SerializedName("title"         ) val title        : String? = null,
  @field:SerializedName("start_at"      ) val startAt      : String? = null,
  @field:SerializedName("end_at"        ) val endAt        : String? = null,
  @field:SerializedName("status"        ) val status       : Int?    = null,
  @field:SerializedName("supervisor_id" ) val supervisorId : String? = null,
  @field:SerializedName("supervisor"    ) val supervisor   : String? = null

)