package com.yema.retrofittest.Http

import com.yema.retrofittest.dataclass.ServerInfoResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

public interface UrlApi {

    @GET("/get")
    abstract operator fun get(@Query("id") id: Int): Call<ServerInfoResponse>


    //    http://192.168.0.102:5000/upload
    @Multipart
    @POST("/upload")
    fun upload(@Part("description") description: RequestBody,@Part file: MultipartBody.Part ) : Call<String>

}