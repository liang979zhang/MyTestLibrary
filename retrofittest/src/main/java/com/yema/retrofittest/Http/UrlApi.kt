package com.yema.retrofittest.Http

import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

public interface UrlApi {

    @FormUrlEncoded
    @POST("intf/user/login.intf")
     fun login(@FieldMap params: Map<String, Any>): Call<String>
}