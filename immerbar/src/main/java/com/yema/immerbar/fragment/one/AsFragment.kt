package com.yema.immerbar.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.gyf.barlibrary.ImmersionBar
import com.gyf.barlibrary.ImmersionFragment
import com.gyf.barlibrary.SimpleImmersionFragment
import com.yema.immerbar.R
import kotlinx.android.synthetic.main.frag_layout.*

@SuppressLint("ValidFragment")
class AsFragment : SimpleImmersionFragment() {
    override fun initImmersionBar() {
//        ImmersionBar.with(this).reset().titleBar(view).init()

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.as_layout, container, false)

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

    }
}