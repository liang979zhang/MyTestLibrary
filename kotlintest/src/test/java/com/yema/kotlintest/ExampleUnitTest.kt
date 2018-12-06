package com.yema.kotlintest

import org.junit.Test

import org.junit.Assert.*

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

        val strings = arrayListOf("abc", "efd", "gfg")
        println("First content is $strings")
        println("First content is ${strings[0]}")
        println("First content is ${if (strings.size > 0) strings[0] else "null"}")
        println("First content is \$strings")
        println("First content is ${'$'}strings")
    }


    @Test
    fun printList() {

        val list = listOf(2, 4, 0)
        // 不标明参数名
        println(joinToString(list, " - ", "[", "]"))
        // 显式的标明参数名称
        println(joinToString(list, separator = " - ", prefix = "[", postfix = "]"))
    }

    /*
    * 打印列表的内容
    * */
    fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
    ): String {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }


    /*
* 扩展函数
* */
    private fun String.lastChar(): Char = this[this.length - 1]

    val String.lastChar: Char
        get() = get(length - 1)

    var StringBuilder.lastChar: Char
        get() = get(length - 1)
        set(value: Char) {
            setCharAt(length - 1, value)
        }

    @Test
    fun aa() {
        val str = "test extension fun"
        println(str.lastChar())

        val s = "abc"
        println(s.lastChar)
        val sb = StringBuilder("abc")
        println(sb.lastChar)
    }

}
