package com.yema.retrofittest.Http

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 *  文件上传处理类
 *   接口文件必须定义为 @Body multipartBody: MultipartBody 的形式不用加 @Multipart
 *    @POST("/upload")
        fun uploadFileWithRequestBody(@Body multipartBody: MultipartBody): Call<UploadFileModel>
 */
class MultipartBuilder {

    companion object {
        fun onlyFile(file: File, filekey: String = "file"): MultipartBody {
            var builder = MultipartBody.Builder()
            val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
            builder.addFormDataPart(filekey, file.name, requestBody)
            builder.setType(MultipartBody.FORM)

            return builder.build()
        }

        /**
         * 单文件+参数上传
         */
        fun oneFileAndDatabody(
            file: File,
            mutableMap: MutableMap<String, String>,
            filekey: String = "file"
        ): MultipartBody {

            var builder = MultipartBody.Builder()
            val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
            builder.addFormDataPart(filekey, file.name, requestBody)
            builder.setType(MultipartBody.FORM)
            for (key in mutableMap.keys) {
                builder.addFormDataPart(key, mutableMap.values.toString())
            }

            return builder.build()
        }


        /**
         * @param filekey
         * @param files
         * @param mutableMap
         * @param isjava  是否适用于java
         *          true: 适合java后台的图片上传 false  适用于php,python图片上传
         * 多图片+参数上传
         * python 或者php上传图片
         */
        fun multipleImgAnddData(
            filekey: String,
            files: MutableList<File>, mutableMap: MutableMap<String, String>,
            isjava: Boolean = false
        ): MultipartBody {
            var builder = MultipartBody.Builder()
            for ((index, file) in files.withIndex()) {
                val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
                if (isjava) {
                    builder.addFormDataPart(filekey, file.name, requestBody)
                } else {
                    builder.addFormDataPart(filekey + "$index", file.name, requestBody)
                }
            }
            builder.setType(MultipartBody.FORM)
            for (key in mutableMap.keys) {
                builder.addFormDataPart(key, mutableMap.values.toString())
            }
            return builder.build()
        }


    }


}