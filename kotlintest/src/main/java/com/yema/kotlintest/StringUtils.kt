package com.yema.kotlintest

import kotlin.concurrent.thread

class StringUtils {


    companion object {
        fun longestCommonSubstring(first: String, second: String): String {
            var tmp = ""
            var max = ""
            thread {
                for (i in 0 until first.length) {
                    for (j in 0 until second.length) {
                        var k = 1
                        while (k + i <= first.length && k + j <= second.length) {
                            if (first.substring(i, k + i) == second.substring(j, k + j)) {
                                tmp = first.substring(i, k + i)
                            } else {
                                if (tmp.length > max.length)
                                    max = tmp
                                tmp = ""
                            }
                            k++
                        }
                        if (tmp.length > max.length)
                            max = tmp
                        tmp = ""
                    }
                }
            }

            return max
        }

    }

}