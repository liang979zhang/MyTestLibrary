package com.yema.mytestlibrary.flyco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.yema.mytestlibrary.R
import kotlinx.android.synthetic.main.activity_flyco.*

class FlycoAc : AppCompatActivity() {
    private val mTitles = arrayOf("推荐", "社区", "频道", "同城")
    private var mTabEntities = arrayListOf<CustomTabEntity>()
    private var managements = mutableListOf<Fragment?>()
    private var fragmentPagerAdapter: FragmentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flyco)

        for (i in 0 until mTitles.size) {
            mTabEntities.add(TabEntity(mTitles[i],   R.drawable.abc_btn_check_material,   R.drawable.abc_btn_check_material))
            managements.add(AFragment())
        }

        top_title.setTabData(mTabEntities)
        top_title.currentTab = 0

        fragmentPagerAdapter = FragmentAdapter(supportFragmentManager, managements)
        fra_viewapger.offscreenPageLimit = 4
        fra_viewapger.currentItem = 0
        fra_viewapger.adapter = fragmentPagerAdapter





    }

    fun setTitleTest() {
//        mTabEntities[3] =TabEntity("测试", R.drawable.abc_btn_check_material, R.drawable.abc_btn_check_material)

        val titleView = top_title.getTitleView(3)

        titleView.setText("测试")

    }
}
