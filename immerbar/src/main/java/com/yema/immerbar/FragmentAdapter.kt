package com.yema.immerbar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter : FragmentPagerAdapter {

    private  var fragments: MutableList<Fragment?>


    constructor(fm: FragmentManager?, mfragments: MutableList<Fragment?>) : super(fm) {
        this.fragments = mfragments
    }

    override fun getItem(p0: Int): Fragment {
        return fragments[p0]!!
    }

    override fun getCount(): Int {
        return fragments.size
    }


}