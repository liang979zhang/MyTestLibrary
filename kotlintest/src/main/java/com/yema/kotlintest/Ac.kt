package com.yema.kotlintest

abstract class Ac {
    var tag = this.javaClass.simpleName

    abstract var name: String
    abstract fun init()

    open fun aa() {

    }

}