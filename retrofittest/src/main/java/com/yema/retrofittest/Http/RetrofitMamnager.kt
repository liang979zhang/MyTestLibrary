package com.yema.retrofittest.Http

import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class RetrofitMamnager {



    companion object {

        fun getApi(): Class<UrlApi> {
            var aa = RetrofitClienApi2.getApi(UrlApi::class.java)
            return aa
        }

    }


}