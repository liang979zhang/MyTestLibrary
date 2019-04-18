package com.yema.viewpagertest

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var lists = mutableListOf<String>()

    var mPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (a in 0..8) {
            lists.add("${a}aadsadasda撒大大双$a")
        }

        var pager = Myadapter()

        vertical_view_pager.offscreenPageLimit = 3
        vertical_view_pager.adapter = pager
        pager.setlist(lists)

        vertical_view_pager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                mPosition = position


            }
        })

        vertical_view_pager.setPageTransformer(false, ViewPager.PageTransformer { page, position ->
            if (position != 0f) {
                return@PageTransformer
            }


            val view = page as ViewGroup

//
            var text = view.findViewById<TextView>(R.id.tx_video_review_status)
//
            text.setOnClickListener {
                lists.removeAt(mPosition)
                pager.notifyDataSetChanged()
            }
        })
    }
}
