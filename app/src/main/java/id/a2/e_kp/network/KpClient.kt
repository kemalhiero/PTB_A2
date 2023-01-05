package id.a2.e_kp.network

import id.a2.e_kp.models.*
import retrofit2.Call
import retrofit2.http.*


interface KpClient {
    @FormUrlEncoded
    @POST("/api/login")
    fun login(@Field("username") username: String, @Field("password") password:String): Call<LoginResponse>

    @POST("/api/logout")
    fun logout(@Header("Authorization") token:String): Call<LogoutResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String): Call<ProfileResponse>

    @POST("/api/me/update")
    fun updateProfile(@Field("email") email: String, @Field("name") name:String): Call<UpdateProfileResponse>

    @POST("/api/password")
    fun changePassword(@Field("old_password") old_password: String, @Field("new_password") new_password:String, @Field("confirm_password") confirm_password:String): Call<ChangePasswordResponse>

    @GET("/api/finished-internships")
    fun selesaikp(@Header("Authorization") token:String
        ) : Call<SelesaiKP>

    @PATCH("/api/internship-grade/2/approval")
    fun setujunilai(@Header("Authorization") token: String
        ) : Call<setujuNilai>

}