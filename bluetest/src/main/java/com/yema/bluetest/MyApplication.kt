package com.yema.bluetest

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport

class MyApplication :Application() {


    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(applicationContext, "0b25cc35c7", true) //腾讯bugly  bug收集
        CrashHandler.getInstance().init(this)
        CrashReport.setUserId("9527")

    }
}