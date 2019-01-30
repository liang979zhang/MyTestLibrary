package com.yema.immerbar.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gyf.barlibrary.ImmersionBar
import com.gyf.barlibrary.ImmersionFragment
import com.yema.immerbar.FragmentAdapter
import com.yema.immerbar.R
import kotlinx.android.synthetic.main.frag_layout.*

@SuppressLint("ValidFragment")
class OneFragment : ImmersionFragment() {
    override fun initImmersionBar() {
        ImmersionBar.with(this).titleBar(view).init()
    }

    override fun immersionBarEnabled(): Boolean {
        return false
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.frag_layout,container,false)

        return view
    }
    private var mfragments = mutableListOf<Fragment?>()
    private lateinit var fragmentPagerAdapter :FragmentAdapter
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val homeThreeFragment = AaFragment()
        val categoryThreeFragment = AsFragment()
        mfragments!!.add(homeThreeFragment)
        mfragments!!.add(categoryThreeFragment)

        fragmentPagerAdapter = FragmentAdapter(childFragmentManager, mfragments)
        fl_aa_change.offscreenPageLimit = 1
        fl_aa_change.currentItem = 0
        fl_aa_change.adapter = fragmentPagerAdapter
        fl_aa_change.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                ImmersionBar.with(activity as Activity).navigationBarColor(R.color.colorPrimary).init()
            }
        })


    }
}