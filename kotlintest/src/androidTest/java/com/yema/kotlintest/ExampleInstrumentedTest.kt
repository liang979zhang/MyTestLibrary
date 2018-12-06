package com.yema.kotlintest

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4

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
        assertEquals("com.yema.kotlintest", appContext.packageName)
    }

    @Test
    fun stringiest() {
        val str1 = "abc"
        val str2 = """line1\n
        line2
        line3
        """
        val js = """
        function myFunction()
        {
            document.getElementById("demo").innerHTML="My First JavaScript Function";
        }
        """.trimIndent()
        println(str1)
        println(str2)
        println(js)
    }


}
