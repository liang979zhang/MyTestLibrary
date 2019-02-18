package com.yema.mytestlibrary.adapter

import com.chad.library.adapter.base.entity.MultiItemEntity

class MultipleItem(private val itemType: Int) : MultiItemEntity {

    override fun getItemType(): Int {
        return itemType
    }

    companion object {
        val MY = 1
        val HIS = 2
    }
}