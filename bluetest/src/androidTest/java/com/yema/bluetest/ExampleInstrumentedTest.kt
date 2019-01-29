package com.yema.bluetest

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.google.gson.Gson
import org.json.JSONObject
import org.json.JSONTokener

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.yema.bluetest", appContext.packageName)
    }


    @Test
    fun aa() {
//        val aas = "{\"_ALIYUN_NOTIFICATION_PRIORITY_\":\"1\",\"className\":\"roadpatrol\",\"_ALIYUN_NOTIFICATION_ID_\":\"188785\",\"type\":\"1\"}"
        val JSONText = "{\"id\":20130001,\"phone\":\"13579246810\",\"name\":\"Jason\"}"


        var gson = Gson()


        val jsonTokener = JSONTokener(JSONText)

        var jsonob = JSONObject(JSONText)



//        var className = jsonob.getString("className")
//        var type = jsonob.getString("type")
//        var params = jsonob.getString("params")
//        var ss = params.substring(1, params.length - 1)
        System.out.print("a")


    }
}
