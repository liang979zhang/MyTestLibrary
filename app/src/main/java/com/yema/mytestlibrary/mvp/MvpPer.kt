package com.yema.mytestlibrary.mvp

import com.yema.mytestlibrary.basemvp.BasePresenter

class MvpPer: BasePresenter<MvpView>() {

    private var mdoel: MvpMdoel = MvpMdoel()


    fun loadData() {
        mdoel.loadData(view)

    }

}