package com.yema.mytestlibrary.basemvp

interface BaseView{

    //加载的提示
     fun showDialog()

     fun <T>OnSuccess(t: T)

     fun <T> OnError(t: T)
}