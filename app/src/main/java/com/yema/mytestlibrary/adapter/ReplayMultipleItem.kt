package com.yema.mytestlibrary.adapter

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 *  itemType : 类型
 *  content  : 内容
 *  responde : 回复者
 *  replied : 被回复者
 *
 */
class ReplayMultipleItem(private val itemType: Int,  val content: String,  val responde: String,  val replied: String) : MultiItemEntity {
    override fun getItemType(): Int {
        return itemType
    }

    companion object {
        @JvmField
        val NORME = 1
        @JvmField
        val TOMMAIN = 2
    }

}