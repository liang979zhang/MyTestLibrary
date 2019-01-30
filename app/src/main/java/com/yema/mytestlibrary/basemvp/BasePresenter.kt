package com.yema.mytestlibrary.basemvp

import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView> {

    private var mReference: WeakReference<V>? = null//使用弱引用,避免内存泄漏

    protected val view: V
        get() = mReference!!.get()!!

    /**
     * 连接上View模型，类型于Activity与Fragment的连接onTachActivity()
     */
    fun attachView(view: V) {
        mReference = WeakReference(view)

    }


    /**
     * 断开与View模型的连接，类型于Activity与Fragment的断开onDetach() 防止后面做一些无用的事情
     */
    fun detachView() {
        if (mReference != null) {
            mReference!!.clear()
        }
    }
}
