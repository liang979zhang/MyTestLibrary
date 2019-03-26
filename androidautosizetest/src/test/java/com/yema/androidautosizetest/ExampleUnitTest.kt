package com.yema.androidautosizetest

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
        // 要验证的字符串
        val str = "_12adsasdas."
        // 邮箱验证规则
        val regEx = "^[0-9a-zA-Z_.]+\$"

        val matches = Pattern.matches(regEx, str)
        var asda = ""

    }
}
