package com.yema.immerbar

import android.app.Application
import me.jessyan.autosize.AutoSize
import me.jessyan.autosize.AutoSizeConfig

class App :Application() {


    override fun onCreate() {
        super.onCreate()


        AutoSize.initCompatMultiProcess(this)
//
        AutoSizeConfig.getInstance().unitsManager
                .setSupportSP(false).isSupportDP = false
    }
}