package com.yema.androidautosizetest

import android.app.Application
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits

class App  :Application() {


    override fun onCreate() {
        super.onCreate()
        AutoSizeConfig.getInstance().unitsManager
                .setSupportSP(false)
                .setSupportDP(false)
                .supportSubunits = Subunits.MM;

    }


}