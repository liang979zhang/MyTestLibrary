package com.yema.androidautosizetest

import android.util.Log
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class TestAdapter :BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_view) {
    override fun convert(helper: BaseViewHolder?, item: String?) {

        val textView = helper!!.getView<ExpandTextView>(R.id.tv_name)



        textView.setText(item,false,object :ExpandTextView.Callback{
            override fun getStr(str: String?) {
                Log.e("tag","")
                val highlight = TextUtilTools.highlight(str,"打撒十")
                textView.text = highlight
            }

            override fun onExpand() {
                helper.setText(R.id.tv_status,"展开")
            }

            override fun onCollapse() {
                helper.setText(R.id.tv_status,"收起")

            }

            override fun onLoss() {
                helper.setText(R.id.tv_status,"隐藏")
            }
        })

    }
}