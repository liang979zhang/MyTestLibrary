package com.yema.retrofittest

import okhttp3.Headers
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.URLDecoder
import java.net.URLEncoder


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4,2 + 2)
    }


    @Test
    fun one() {
        var aa = "form-data; name=file;filename=asdadadadasd.mp3"
        try {
            val encode = URLEncoder.encode(aa,"utf-8")
            val saa = URLDecoder.decode(encode,"utf-8")

            Headers.of("Content-Disposition",encode)

        } catch (e: Exception) {
            System.out.println("asdasd")
        }
    }


    @Test
    fun numtexthandle() {

    }
}
