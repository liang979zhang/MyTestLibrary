package com.yema.immerbar.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gyf.barlibrary.ImmersionBar
import com.gyf.barlibrary.ImmersionFragment
import com.yema.immerbar.FragmentAdapter
import com.yema.immerbar.R
import kotlinx.android.synthetic.main.aa_layout.*
import kotlinx.android.synthetic.main.frag_layout.*

@SuppressLint("ValidFragment")
class AaFragment : ImmersionFragment() {
    override fun initImmersionBar() {
//        ImmersionBar.with(this).titleBar(viewaa).reset().init()
//        ImmersionBar.setTitleBar(activity,viewaa)
    }

    override fun immersionBarEnabled(): Boolean {
        return true
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.aa_layout,container,false)
        return view
    }
}