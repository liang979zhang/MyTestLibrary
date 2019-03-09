package com.yema.retrofittest.Http

import com.yema.retrofitutils.Http.WorkApi


/**
 * 设置api接口类  api类需要自己去实现
 */
class RetrofitMamnager {
//    http://t.patrol-rest.jsti-smart.cn/intf/patrol/uploadFile.intf
    companion object {

        fun getApi(): UrlApi {
//            var aa = RetrofitClienApi.getApi("http://t.patrol-rest.jsti-smart.cn/", UrlApi::class.java)
//            var aa = RetrofitClienApi.getApi("http://t.maintain-xpn.jsti-smart.cn", UrlApi::class.java)
            var aa = RetrofitClienApi.getApi(" http://codown.youdao.com", UrlApi::class.java)//我自己的
            return aa
        }


    fun getWorkApi(): WorkApi {
        val workApi = RetrofitClienApi.getApi("http://139.219.1.156:8816", WorkApi::class.java)
        return workApi

    }

    }

}