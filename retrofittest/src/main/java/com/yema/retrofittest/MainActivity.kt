package com.yema.retrofittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yema.retrofittest.Http.RetrofitMamnager
import com.yema.retrofittest.dataclass.ServerInfoResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import com.yema.retrofittest.image.GlideImageLoader
import com.caimuhao.rxpicker.RxPicker
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Callback
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tv_click.setOnClickListener {
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
                Log.e("tag", "${list.size}")
                upLoad(list.get(0).path)


            }


        }


    }

    private fun upLoad(path: String) {
        val file = File(path)


        val api = RetrofitMamnager.getApi()
//        val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val requestFile = RequestBody.create(MediaType.parse("image/jpg"), file)


        val bodypart = MultipartBody.Part.createFormData("image", file.name, requestFile)

        // 添加描述
        val descriptionString = "hello, 这是文件描述";
        val description =
            RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString)


        val upload = api.upload(description, bodypart)
        upload.enqueue(object : retrofit2.Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("tag", "")

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                val body = response.body()
                Log.e("tag", "")

            }
        })


    }
}
