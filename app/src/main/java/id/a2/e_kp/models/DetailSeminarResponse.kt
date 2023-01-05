package id.a2.e_kp.models

import com.google.gson.annotations.SerializedName

data class DetailSeminarResponse(

    @field:SerializedName("DetailSeminarResponse")
    val detailSeminarResponse: List<DetailSeminarResponseItem?>? = null
)

data class DetailSeminarResponseItem(

    @field:SerializedName("end_at")
    val endAt: Any? = null,

    @field:SerializedName("agency")
    val agency: String? = null,

    @field:SerializedName("supervisor_id")
    val supervisorId: Any? = null,

    @field:SerializedName("seminar_room_id")
    val seminarRoomId: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("start_at")
    val startAt: Any? = null,

    @field:SerializedName("seminar_date")
    val seminarDate: String? = null,

    @field:SerializedName("seminar_room_name")
    val seminarRoomName: String? = null,

    @field:SerializedName("grade")
    val grade: String? = null,

    @field:SerializedName("seminar_deadline")
    val seminarDeadline: Any? = null,

    @field:SerializedName("audiences")
    val audiences: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("supervisor")
    val supervisor: Any? = null,

    @field:SerializedName("status")
    val status: Int? = null
)
