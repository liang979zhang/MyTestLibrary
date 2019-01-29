package com.yema.mytestlibrary.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.yema.mytestlibrary.R

class LoadingDialog : DialogFragment() {

    /**
     * 默认点击外面无效
     */
    private var onTouchOutside: Boolean = false;

    /**
     * 加载框提示信息 设置默认
     */
    private var hintMsg = "正在加载，请稍后...";


    public fun setOnTouchOutside(onTouchOutside: Boolean): LoadingDialog {
        this.onTouchOutside = onTouchOutside;
        return this
    }


    public fun setHintMsg(msg: String): LoadingDialog {
        if (!msg.isEmpty()) {
            this.hintMsg = msg
        }
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 设置背景透明
        dialog.window.setBackgroundDrawableResource(android.R.color.transparent)
        // 去掉标题
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set cancel on touch outside
        dialog.setCanceledOnTouchOutside(onTouchOutside);
        var  view = inflater.inflate(R.layout.activity_main2,container)

        return view
    }

}