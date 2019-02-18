package com.yema.mytestlibrary.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.util.MultiTypeDelegate
import com.yema.mytestlibrary.R


class PrivateMsgAdapter : BaseQuickAdapter<MultipleItem, BaseViewHolder> {
    override fun convert(helper: BaseViewHolder?, item: MultipleItem?) {
        when (helper!!.itemViewType) {
            MultipleItem.HIS -> {
                helper.setText(com.yema.mytestlibrary.R.id.t_namw2, ":sadasd")

            }
            MultipleItem.MY -> {

                helper.setText(com.yema.mytestlibrary.R.id.tv_name1, ":sadasd")
            }
        }
    }


    constructor() : super(null) {
        multiTypeDelegate = object : MultiTypeDelegate<MultipleItem>() {
            override fun getItemType(entity: MultipleItem): Int {
                //根据你的实体类来判断布局类型
                return entity.itemType
            }
        }

        multiTypeDelegate
                .registerItemType(MultipleItem.HIS, R.layout.item_private_msg_left)
                .registerItemType(MultipleItem.MY, R.layout.item_private_msg_right)
    }


    override fun getItemCount(): Int {
        return 2


    }

}