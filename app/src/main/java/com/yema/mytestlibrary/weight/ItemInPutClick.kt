package com.yema.mytestlibrary.weight

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

interface ItemInPutClick {

    fun itemClick(adapter: BaseQuickAdapter<Any, BaseViewHolder>, position: Int)
    fun itemClick2( position: Int)

}