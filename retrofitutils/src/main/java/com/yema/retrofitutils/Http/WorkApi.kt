package com.yema.retrofitutils.Http

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WorkApi {

    //    获取评论列表
    @FormUrlEncoded
    @POST("/Works/listComment")
    fun listComment(@Field("token") token: String, @Field("userId") userId: String, @Field("worksId") worksId: String, @Field("pageNum") pageNum: Int, @Field("pageSize") pageSize: Int): Call<CommentListModel>
}