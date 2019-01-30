package com.yema.mytestlibrary.basemvp

import android.app.Activity
import android.os.Bundle

abstract class BaseActivity<V : BaseView,P : BasePresenter<V>>: Activity(){
    private lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //创建Presenter
        mPresenter = initPresenter()
        //类似fragment的绑定.拿到引用
        mPresenter.attachView(this as V)

    }


    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

    /**
     * 创建prensenter
     * @return <T extends BasePresenter> 必须是BasePresenter的子类
    </T> */
    protected abstract fun initPresenter(): P
}
