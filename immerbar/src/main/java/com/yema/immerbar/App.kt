package com.yema.immerbar

import android.app.Application
import android.util.Log
import me.jessyan.autosize.AutoSize
import me.jessyan.autosize.AutoSizeConfig

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        Log.e("tag", "重新启动")
        AutoSize.initCompatMultiProcess(this)
//
        AutoSizeConfig.getInstance().unitsManager
                .setSupportSP(false).isSupportDP = false

    }
}