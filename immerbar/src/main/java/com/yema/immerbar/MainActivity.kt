package com.yema.immerbar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.gyf.barlibrary.ImmersionBar
import com.yema.immerbar.fragment.*
import face.com.zdl.cctools.Permission2.OnPermission
import face.com.zdl.cctools.Permission2.Permission
import face.com.zdl.cctools.Permission2.XXPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    val mTitles = arrayOf("首页", "消息", "联系人", "我的")
    private val mNorIcons = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher
    )
    private val mSelIcons = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher)

    private var mTabEntities = arrayListOf<CustomTabEntity>()

    private lateinit var fragmentPagerAdapter: FragmentAdapter
    private var mfragments = mutableListOf<Fragment?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).init()
        if (savedInstanceState == null) {
            Log.e("tag", "null----------")

        } else {
            Log.e("tag", "Nonull----------")
            try {
                Log.e("tag", "Nonull----------$packageName.WelComeActivity")
//                startActivity(Intent(applicationContext, WelComeActivity::class.java))
                val intent = packageManager.getLaunchIntentForPackage("$packageName")
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            } catch (e: Exception) {

                Log.e("tag", "Nonull----------Exception")

            }
            finish()
            return
        }
        setContentView(R.layout.activity_main)

        val homeThreeFragment = OneFragment()
        val categoryThreeFragment = TwoFragment()
        val serviceThreeFragment = ThreeFragment()
        val mineThreeFragment = FourFragment()
        mfragments!!.add(homeThreeFragment)
        mfragments!!.add(categoryThreeFragment)
        mfragments!!.add(serviceThreeFragment)
        mfragments!!.add(mineThreeFragment)

        fragmentPagerAdapter = FragmentAdapter(supportFragmentManager, mfragments)
        fl_change.adapter = fragmentPagerAdapter
        fl_change.offscreenPageLimit = 3
        fl_change.currentItem = 0


        for (i in 0 until mTitles.size) {
            mTabEntities.add(TabEntity(mTitles[i], mSelIcons[i], mNorIcons[i]))
        }

        tl_3.setTabData(mTabEntities)
        tl_3.currentTab = 0
        tl_3.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                Log.e("tag", "切换$position")
                if (position == 2) {
                    return
                }
                fl_change.currentItem = position
            }

            override fun onTabReselect(position: Int) {
            }
        })

        fl_change.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tl_3.currentTab = position
            }
        })



        XXPermissions.with(this).permission(Permission.Group.CALENDAR, Permission.Group.STORAGE).request(object : OnPermission {
            override fun noPermission(denied: MutableList<String>?, quick: Boolean) {

            }

            override fun hasPermission(granted: MutableList<String>?, isAll: Boolean) {


            }
        })

    }
}
