package com.yema.retrofittest.Http

import com.yema.retrofittest.dataclass.ServerInfoResponse
import com.yema.retrofittest.dataclass.UploadFileModel
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface UrlApi {
    @GET("/get")
    fun get(@Query("id") id: Int): Call<ServerInfoResponse>

    /**
     * 通过 MultipartBody和@body作为参数来上传
     * @param multipartBody MultipartBody包含多个Part
     * @return 状态信息
     */
    @POST("/upload")
    fun uploadFileWithRequestBody(@Body multipartBody: MultipartBody): Call<UploadFileModel>

    //下载文件
    @Streaming
    @GET("/note/youdaonote_android_6.5.1_youdaoweb.apk")
    fun downFile(): Call<ResponseBody>


    @Streaming //大文件时要加不然会OOM
    @GET
    fun downloadFile(@Url fileUrl: String): Call<ResponseBody>
}