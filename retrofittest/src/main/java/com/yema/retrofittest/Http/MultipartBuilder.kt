package com.yema.retrofittest.Http

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class MultipartBuilder {

    companion object {
        fun filesToMultipartBody(files: List<File>): MultipartBody {
            val builder = MultipartBody.Builder()
            for (file in files) {
                val requestBody = RequestBody.create(MediaType.parse("image/*"), file)
                builder.addFormDataPart("file", file.name, requestBody)
            }
            builder.setType(MultipartBody.FORM)
            return builder.build()
        }


        fun filesToMultipartBodyParts(files: List<File>): List<MultipartBody.Part> {
//        var parts: List<MultipartBody.Part> = ArrayList(files.size)
            var parts = mutableListOf<MultipartBody.Part>()
            for (file in files) {
                val requestBody = RequestBody.create(MediaType.parse("image/*"), file)
                val part = MultipartBody.Part.createFormData("file", file.name, requestBody)
                parts.add(part)
            }

            return parts
        }


        fun fileAdndData(
            filekey:String,
            files: MutableList<File>, mutableMap: MutableMap<String, String>
        ) :MultipartBody{
            var builder = MultipartBody.Builder()
            for (file in files) {

                val requestBody = RequestBody.create(MediaType.parse("image/png"), file)
                builder.addFormDataPart(filekey, file.name, requestBody)

                /**  这两部等同于上一部
                var bestPart = MultipartBody.Part.createFormData("picture[]", file.getName(), requestBody)
                builder.addPart(bestPart)
                 */

            }
            builder.setType(MultipartBody.FORM)
            for (key in mutableMap.keys) {
                builder.addFormDataPart(key, mutableMap.values.toString())
            }
            return  builder.build()
        }


    }


}