package com.yema.immerbar.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gyf.barlibrary.ImmersionBar
import com.gyf.barlibrary.ImmersionFragment
import com.yema.immerbar.R
import kotlinx.android.synthetic.main.aa_layout.*

@SuppressLint("ValidFragment")
class AaFragment : ImmersionFragment() {
    override fun initImmersionBar() {

        if (activity == null) {
            Log.e("tag", "activity===null")
        } else {
            Log.e("tag", "activity===Nonull")

        }
        ImmersionBar.with(this).titleBar(ll_aa).reset().init()
//        ImmersionBar.setTitleBar(activity,viewaa)

    }

    override fun immersionBarEnabled(): Boolean {
        return true
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.aa_layout, container, false)
        return view
    }

}