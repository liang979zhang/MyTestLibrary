package com.yema.bluetest

import com.google.gson.Gson
import org.json.JSONObject
import org.json.JSONTokener
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun aa() {
        val aas = "{\"_ALIYUN_NOTIFICATION_PRIORITY_\":\"1\",\"className\":\"roadpatrol\",\"_ALIYUN_NOTIFICATION_ID_\":\"377800\",\"type\":\"1\",\"params\":\"{\\\"dataId\\\":1020,\\\"type\\\":\\\"1\\\"}\"}"
//        val JSONText = "{\"id\":20130001,\"phone\":\"13579246810\",\"name\":\"Jason\"}"


        var gson = Gson()
        var aasBean = gson.fromJson<Aas>(aas, Aas::class.java)

//        var className = jsonob.getString("className")
//        var type = jsonob.getString("type")
//        var params = jsonob.getString("params")
//        var ss = params.substring(1, params.length - 1)
        System.out.print("a")


    }

}
