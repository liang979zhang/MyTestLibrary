package com.yema.androidautosizetest

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ymlogion.*
import kotlinx.android.synthetic.main.title_bar_two.*

/**
 * 登录
 */
class YMLogionActivity : AppCompatActivity(), View.OnClickListener {


    override fun onClick(v: View?) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ymlogion)
        tv_title.text = "登录"
        ll_left.setOnClickListener(this)
        ll_login.setOnClickListener(this)
        tv_forget_pass.setOnClickListener(this)
        tv_regis_account.setOnClickListener(this)
        iv_webchat.setOnClickListener(this)
        iv_qq.setOnClickListener(this)

    }

}
