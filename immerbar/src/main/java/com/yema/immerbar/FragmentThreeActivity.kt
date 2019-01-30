package com.yema.immerbar

import android.view.View
import android.widget.LinearLayout

import com.gyf.barlibrary.ImmersionBar
import com.yema.immerbar.fragment.AaFragment
import com.yema.immerbar.fragment.AsFragment

import java.util.ArrayList

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_fragment_one.*
import kotlinx.android.synthetic.main.tab_bottom.*

/**
 * @author geyifeng
 * @date 2017/5/8
 */
class FragmentThreeActivity : BaseActivity(), View.OnClickListener, ViewPager.OnPageChangeListener {

    private var mFragments: ArrayList<Fragment>? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_fragment_one
    }

    override fun initImmersionBar() {
        super.initImmersionBar()
        ImmersionBar.with(this).navigationBarColor(R.color.colorPrimary).init()
    }

    override fun initData() {

        mFragments = ArrayList()
        val homeThreeFragment = AaFragment()
        val categoryThreeFragment = AsFragment()
        mFragments!!.add(homeThreeFragment)
        mFragments!!.add(categoryThreeFragment)
    }

    override fun initView() {
        viewPager!!.adapter = MyAdapter(supportFragmentManager)
        viewPager!!.offscreenPageLimit = 3
        ll_home.isSelected = true
    }

    override fun setListener() {
        ll_home.setOnClickListener(this)
        ll_category.setOnClickListener(this)
        ll_service.setOnClickListener(this)
        ll_mine.setOnClickListener(this)
        viewPager!!.addOnPageChangeListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ll_home -> {
                viewPager!!.currentItem = 0
                tabSelected(ll_home)
            }
            R.id.ll_category -> {
                viewPager!!.currentItem = 1
                tabSelected(ll_category)
            }
            R.id.ll_service -> {
                viewPager!!.currentItem = 2
                tabSelected(ll_service)
            }
            R.id.ll_mine -> {
                viewPager!!.currentItem = 3
                tabSelected(ll_mine)
            }
            else -> {
            }
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                tabSelected(ll_home)
//                ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(false).navigationBarColor(R.color.colorPrimary).init()
            }
            1 -> {
                tabSelected(ll_category)
//                ImmersionBar.with(this).keyboardEnable(true).statusBarDarkFont(true, 0.2f).navigationBarColor(R.color.btn3).init()
            }
            2 -> {
                tabSelected(ll_service)
//                ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(false).navigationBarColor(R.color.btn13).init()
            }
            3 -> {
                tabSelected(ll_mine)
//                ImmersionBar.with(this).keyboardEnable(true).statusBarDarkFont(true).navigationBarColor(R.color.btn1).init()
            }
            else -> {
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    private fun tabSelected(linearLayout: LinearLayout) {
        ll_home.isSelected = false
        ll_category.isSelected = false
        ll_service.isSelected = false
        ll_mine.isSelected = false
        linearLayout.isSelected = true
    }

    private inner class MyAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return mFragments!![position]
        }

        override fun getCount(): Int {
            return mFragments!!.size
        }
    }
}
