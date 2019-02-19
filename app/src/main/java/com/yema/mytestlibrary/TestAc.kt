package com.yema.mytestlibrary

import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yema.mytestlibrary.adapter.CommentAdapter
import com.yema.mytestlibrary.adapter.CommentData
import com.yema.mytestlibrary.adapter.ReplayMultipleItem
import com.yema.mytestlibrary.test.AAdapter
import com.yema.mytestlibrary.weight.ItemInPutClick
import com.yema.mytestlibrary.weight.TextMsgInputDialog
import kotlinx.android.synthetic.main.activity_test_layout.*


class TestAc : FragmentActivity() {
    lateinit var privateMsgAdapter: CommentAdapter
    var testList = mutableListOf<CommentData>()
    var strings = mutableListOf<ReplayMultipleItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_layout)


        for (y in 0..12) {
            if (y % 2 == 0) {
                strings.add(ReplayMultipleItem(1, "asdasd$y", "我$y", "他$y"))

            } else {
                strings.add(ReplayMultipleItem(2, "asdasd$y", "我$y", "他$y"))
            }


        }
        for (i in 1..10) {
            testList.add(CommentData("asdasd", strings))


        }

        privateMsgAdapter = CommentAdapter()
        privateMsgAdapter.setNewData(testList)
        rl_list.layoutManager = LinearLayoutManager(this)
        rl_list.adapter = privateMsgAdapter



//
        privateMsgAdapter.setInputClick(object : ItemInPutClick {
            override fun itemClick2(position: Int) {

            }

            override fun itemClick(adapter: BaseQuickAdapter<Any, BaseViewHolder>, position: Int) {
//                strings.add(ReplayMultipleItem(2, "", "我", "他"))
                testList[position].strings.add(ReplayMultipleItem(2, "", "我", "他"))
                privateMsgAdapter.notifyDataSetChanged()
//                privateMsgAdapter.addData(CommentData("asdasdasdasd是大大说", strings))



                var mTextMsgInputDialog = TextMsgInputDialog(this@TestAc, R.style.textinputDialog)

                mTextMsgInputDialog.setmOnTextSendListener { msg, tanmuOpen ->
                    strings.add(ReplayMultipleItem(2, "", "我", "他"))
                    privateMsgAdapter.addData(CommentData("asdasdasdasd是大大说", strings))

                }

                val windowManager = this@TestAc.windowManager
                val display = windowManager.getDefaultDisplay()
                val lp = mTextMsgInputDialog.window.attributes

                //            输入框
                lp.width = display.getWidth() //设置宽度
                mTextMsgInputDialog.window.attributes = lp
                mTextMsgInputDialog.setCancelable(true)
                mTextMsgInputDialog.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
//                mTextMsgInputDialog.show()
                mTextMsgInputDialog.setHintData("回复我的:")
            }


        })


    }
}