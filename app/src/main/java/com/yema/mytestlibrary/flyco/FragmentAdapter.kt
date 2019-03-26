package com.yema.mytestlibrary.flyco
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager?, mfragments: MutableList<Fragment?>) : FragmentPagerAdapter(fm) {

    private  var fragments: MutableList<Fragment?> = mfragments


    override fun getItem(p0: Int): Fragment {
        return fragments[p0]!!
    }

    override fun getCount(): Int {
        return fragments.size
    }


}