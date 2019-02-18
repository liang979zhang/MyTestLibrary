package com.yema.mytestlibrary

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yema.mytestlibrary.adapter.CommentAdapter
import com.yema.mytestlibrary.adapter.CommentData
import com.yema.mytestlibrary.adapter.MultipleItem
import com.yema.mytestlibrary.adapter.ReplayMultipleItem
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
        for (i in 1..100) {
            testList.add(CommentData("asdasd", strings))


        }

        privateMsgAdapter = CommentAdapter()
        privateMsgAdapter.setNewData(testList)
        rl_list.layoutManager = LinearLayoutManager(this)
        rl_list.adapter = privateMsgAdapter


    }
}