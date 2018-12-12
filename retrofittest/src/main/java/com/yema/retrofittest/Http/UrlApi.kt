package com.yema.retrofittest.Http

import com.yema.retrofittest.dataclass.ServerInfoResponse
import com.yema.retrofittest.dataclass.UploadFileModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

public interface UrlApi {

    @GET("/get")
    fun get(@Query("id") id: Int): Call<ServerInfoResponse>


    //    http://192.168.0.102:5000/upload
    @Multipart
    @POST("intf/patrol/uploadFile.intf")
    fun upload(@Part("type") description: RequestBody, @Part file: MultipartBody.Part): Call<UploadFileModel>

//    http://t.patrol-rest.jsti-smart.cn/intf/patrol/uploadFile.intf

}