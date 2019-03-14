package com.yema.retrofittest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.caimuhao.rxpicker.RxPicker
import com.caimuhao.rxpicker.bean.ImageItem
import com.yema.retrofittest.Http.DownFile
import com.yema.retrofittest.Http.DownFileJava
import com.yema.retrofittest.Http.MultipartBuilder
import com.yema.retrofittest.Http.RetrofitMamnager
import com.yema.retrofittest.dataclass.ServerInfoResponse
import com.yema.retrofittest.dataclass.UploadFileModel
import com.yema.retrofittest.image.GlideImageLoader
import kotlinx.android.synthetic.main.activity_main.*
import kotterknife.bindView
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.tv_click -> {
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

            R.id.tvUpload -> {

                RxPicker.init(GlideImageLoader())
                RxPicker.of()
                        .single(false)
                        .start(this).subscribe { list ->

                            thread {
                                Log.e("tag", "${list.size}")
                                uploadAndData(list)


                            }


                        }


            }
            R.id.tvOneFileAnddata -> {
                RxPicker.init(GlideImageLoader())
                RxPicker.of()
                        .single(true)
                        .start(this).subscribe { list ->

                            thread {
                                Log.e("tag", "${list.size}")
                                uploadAndData2(list)


                            }


                        }
            }
            R.id.tv_onlyone -> {
            }
            R.id.tvdown->{

                downFile()

            }


        }
    }


    private var intance: MainActivity? = null


    val aa: TextView by bindView(R.id.tv_click)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intance = this
        aa.setOnClickListener(this)

        tvUpload.setOnClickListener(this)
        tvOneFileAnddata.setOnClickListener(this)
        tv_onlyone.setOnClickListener(this)
        tvdown.setOnClickListener(this)


    }

    private fun uploadAndData(list: List<ImageItem>) {
        var files = mutableListOf<File>()

        for (path in list) {
            var file = File(path.path)
            files.add(file)
        }

        var datas = mutableMapOf<String, String>()
        datas["uid"] = "505"
        val fileAdndData = MultipartBuilder.multipleImgAnddData("file", files, datas)
        val uploadFileWithRequestBody = RetrofitMamnager.getApi().uploadFileWithRequestBody(fileAdndData)
        uploadFileWithRequestBody.enqueue(object : Callback<UploadFileModel> {
            override fun onFailure(call: Call<UploadFileModel>, t: Throwable) {
                Log.e("tag", "")
            }

            override fun onResponse(call: Call<UploadFileModel>, response: Response<UploadFileModel>) {
                Log.e("tag", "")
            }


        })

    }



    @JvmOverloads
    private fun downFile() {
        val downFile = RetrofitMamnager.getApi().downFile()

        downFile.enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("tag","")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val writeResponseBodyToDisk = DownFileJava.writeResponseBodyToDisk(intance, response.body())
                Log.e("tag","")
            }
        })



    }

    private fun uploadAndData2(list: List<ImageItem>) {
        var file = File(list[0].path)
        var datas = mutableMapOf<String, String>()
        datas["token"] = "asdsad"
        val oneFileAndDatabody = MultipartBuilder.oneFileAndDatabody(file, datas)

        val uploadFileWithRequestBody = RetrofitMamnager.getApi().uploadFileWithRequestBody(oneFileAndDatabody)
        uploadFileWithRequestBody.enqueue(object : Callback<UploadFileModel> {
            override fun onFailure(call: Call<UploadFileModel>, t: Throwable) {
                Log.e("tag", "")
            }

            override fun onResponse(call: Call<UploadFileModel>, response: Response<UploadFileModel>) {
                Log.e("tag", "")
            }


        })
    }


}
