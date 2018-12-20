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



    /**
     * 通过 List<MultipartBody.Part> 传入多个part实现多文件上传
     * @param parts 每个part代表一个
     * @return 状态信息
     */
    @Multipart
//    @POST("intf/patrol/uploadFile.intfe")
    @POST("/intf/patrol/disease/phoneUploadImage.intf")
    fun uploadFilesWithParts(@Part() parts: List<MultipartBody.Part>): Call<UploadFileModel>


    /**
     * 通过 MultipartBody和@body作为参数来上传
     * @param multipartBody MultipartBody包含多个Part
     * @return 状态信息
     */
//    @POST("/intf/patrol/disease/phoneUploadImage.intf")
//    fun uploadFileWithRequestBody(@Body multipartBody: MultipartBody): Call<UploadFileModel>

    /**
     * 通过 MultipartBody和@body作为参数来上传
     * @param multipartBody MultipartBody包含多个Part
     * @return 状态信息
     */
    @POST("/upload")
    fun uploadFileWithRequestBody(@Body multipartBody: MultipartBody): Call<UploadFileModel>
}