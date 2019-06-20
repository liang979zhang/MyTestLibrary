package com.yema.androidautosizetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stx.xhb.xbanner.entity.SimpleBannerInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var testAdapter: TestAdapter

   var  testdata  = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rl_list.layoutManager = LinearLayoutManager(this)
        testAdapter = TestAdapter()
        rl_list.adapter = testAdapter

        for (a in 0..10) {
            testdata.add("啊打打打打打打打撒十大覅三个色哦i猴儿大会对哈对哈是大厦送到哈怂到底阿斯哦对爱的啥事都阿斯道道道谁都爱哦哈都会奥回到收到dssdfsdfsdfds大师傅十分发达石帆胜丰石帆胜丰士大夫是啊的士大夫士大夫石帆胜丰是否发的都是是")
        }
        testAdapter.setNewData(testdata)
        val highlight = TextUtilTools.highlight(testdata[0], "打撒十")

        tv_test.text = highlight

    }
}
