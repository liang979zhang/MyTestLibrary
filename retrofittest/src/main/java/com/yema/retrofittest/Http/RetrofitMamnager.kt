package com.yema.retrofittest.Http


/**
 * 设置api接口类  api类需要自己去实现
 */
class RetrofitMamnager {

    companion object {

        fun getApi(): UrlApi {
            var aa = RetrofitClienApi2.getApi("http://192.168.0.102:5000", UrlApi::class.java)
            return aa
        }

    }

}