package com.yema.retrofittest.Http

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.concurrent.TimeUnit

class RetrofitClienApi2 {


    companion object {


        private var retrofit: Retrofit? = null

        /**
         *  实例化Retrofit
         *  url  为baseurl
         */
        private fun getRetrofitClient(url: String): Retrofit {
            if (retrofit == null) {
                synchronized(RetrofitClienApi2::class.java) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(url)
                        .client(clientSSOServer)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }

            return this!!.retrofit!!

        }

        fun changeApiBaseUrl(newUrl: String): Retrofit? {
            retrofit = Retrofit.Builder()
                .baseUrl(newUrl)
                .client(clientSSOServer)
//                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit


        }


        /**
         * 实例化okhttpclient
         */
        val clientSSOServer by lazy {
            OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).addNetworkInterceptor(loggingInterceptor())
                .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()
        }

        /**
         * 添加请求log日志
         *
         * @return
         */
        private fun loggingInterceptor(): HttpLoggingInterceptor {

            val interceptor = HttpLoggingInterceptor { message ->
                try {
                    val text = URLDecoder.decode(message, "utf-8")
                    Log.e("OKHttp-----", text)
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                    Log.e("OKHttp-----", message)
                }
            }

            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }

        fun <T> getApi(url: String, a: Class<T>): T {
            var t: T? = null
            if (t == null) {
                synchronized(RetrofitClienApi::class.java) {
                    t = getRetrofitClient(url).create(a)
                }
            }
            return t!!
        }


    }


}