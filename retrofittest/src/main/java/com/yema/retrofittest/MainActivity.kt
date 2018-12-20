package com.yema.retrofittest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.caimuhao.rxpicker.RxPicker
import com.caimuhao.rxpicker.bean.ImageItem
import com.yema.retrofittest.Http.MultipartBuilder
import com.yema.retrofittest.Http.RetrofitMamnager
import com.yema.retrofittest.dataclass.ServerInfoResponse
import com.yema.retrofittest.dataclass.UploadFileModel
import com.yema.retrofittest.image.GlideImageLoader
import kotlinx.android.synthetic.main.activity_main.*
import kotterknife.bindView
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    val aa: TextView by bindView(R.id.tv_click)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        aa.setOnClickListener {
            val api = RetrofitMamnager.getApi()
            api.get(3).enqueue(object : retrofit2.Callback<ServerInfoResponse> {
                override fun onFailure(call: Call<ServerInfoResponse>, t: Throwable) {
                    Log.e("tag", "")
                }

                override fun onResponse(call: Call<ServerInfoResponse>, response: Response<ServerInfoResponse>) {
                    val body = response.body()
                    Log.e("tag", body.toString())
                    println(body.toString())
                }
            })

        }

        tvUpload.setOnClickListener {

            RxPicker.init(GlideImageLoader())
            RxPicker.of().start(this).subscribe { list ->

                val thread = thread {
                    list.addAll(list)
                    list.addAll(list)
                    Log.e("tag", "${list.size}")
                    UploadAndData(list)


                }


            }


        }


    }

    private fun UploadAndData(list: List<ImageItem>) {
        var files = mutableListOf<File>()

        for (path in list) {
            var file = File(path.path)
            files.add(file)
        }

        var datas = mutableMapOf<String, String>()
        datas["uid"] = "505"
        val fileAdndData = MultipartBuilder.fileAdndData("file", files, datas)
        val uploadFileWithRequestBody = RetrofitMamnager.getApi().uploadFileWithRequestBody(fileAdndData)
        uploadFileWithRequestBody.enqueue(object :Callback<UploadFileModel>{
            override fun onFailure(call: Call<UploadFileModel>, t: Throwable) {
                Log.e("tag","")
            }

            override fun onResponse(call: Call<UploadFileModel>, response: Response<UploadFileModel>) {
                Log.e("tag","")
            }


        })

    }


    private fun upLoad(path: String) {
        val file = File(path)

        val api = RetrofitMamnager.getApi()
        val requestFile = RequestBody.create(MediaType.parse("application/otcet-stream"), file)
        val bodypart = MultipartBody.Part.createFormData("file", file.name, requestFile)
        // 添加描述
        val descriptionString = "hello,这是文件描述";
        val description =
            RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString)


        val upload = api.upload(description, bodypart)
        upload.enqueue(object : retrofit2.Callback<UploadFileModel> {
            override fun onFailure(call: Call<UploadFileModel>, t: Throwable) {
                Log.e("tag", "")

            }

            override fun onResponse(call: Call<UploadFileModel>, response: Response<UploadFileModel>) {
                val body = response.body()
                Log.e("tag", body!!.data)

            }
        })


    }
}
