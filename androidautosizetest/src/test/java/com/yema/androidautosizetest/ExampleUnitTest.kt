package com.yema.androidautosizetest

import android.util.SparseArray
import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Pattern


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
    fun one() {
        val regEx = "^[0-9a-zA-Z_.\\u4e00-\\u9fa5]+$"
        val matches = Pattern.matches(regEx, "aaAAAas+s_.")
        print("")

    }


    @Test
    fun numtexthandle() {

        var data = "223"
        var isdel = true
        var tempData = ""
        if ("0".equals(data)) {
            if (isdel) {
                tempData = "0"
            } else {
                tempData = "1"
            }
        } else if (data.contains("w")) {
            tempData = data
        } else {
            var tempint = data.toInt()
            if (isdel) {
                tempint--
            } else {
                tempint++

            }
            tempData = tempint.toString()
        }

        print(tempData)
    }
}
