package com.yema.retrofittest.Http


/**
 * 设置api接口类  api类需要自己去实现
 */
class RetrofitMamnager {
//    http://t.patrol-rest.jsti-smart.cn/intf/patrol/uploadFile.intf
    companion object {

        fun getApi(): UrlApi {
            var aa = RetrofitClienApi2.getApi("http://t.patrol-rest.jsti-smart.cn/", UrlApi::class.java)
            return aa
        }

    }

}