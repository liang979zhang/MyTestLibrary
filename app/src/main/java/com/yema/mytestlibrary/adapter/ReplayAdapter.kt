package com.yema.mytestlibrary.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yema.mytestlibrary.MySpannableString
import com.yema.mytestlibrary.R

/**
 * 回复adapter
 */
class ReplayAdapter : BaseMultiItemQuickAdapter<ReplayMultipleItem, BaseViewHolder> {
    override fun convert(helper: BaseViewHolder?, item: ReplayMultipleItem?) {
        when (helper!!.itemViewType) {
            ReplayMultipleItem.NORME -> {
                val content1 = MySpannableString(mContext, "${item!!.responde}:  ${item.content}")
                        .first("${item.responde}:").size2(28).textColor(R.color.colorAccent)
                        .first(item.content).size2(28).textColor(R.color.blue)
                helper.setText(R.id.tv_repla_nor, content1)

            }
            ReplayMultipleItem.TOMMAIN -> {
                val content1 = MySpannableString(mContext, "${item!!.responde} 回复${item.replied}:  ${item.content}")
                        .first(item.responde).size2(28).textColor(R.color.colorAccent)
                        .first("回复").size2(28).textColor(R.color.c606060)
                        .first(item.replied).size2(28).textColor(R.color.colorPrimary)
                        .first(item.content).size2(28).textColor(R.color.blue)
                helper.setText(R.id.tv_repla_to, content1)
            }
        }
    }


    constructor() : super(null) {
        addItemType(ReplayMultipleItem.NORME, R.layout.itme_replay_layout)
        addItemType(ReplayMultipleItem.TOMMAIN, R.layout.itme_a_replay_b_layout)
    }

}