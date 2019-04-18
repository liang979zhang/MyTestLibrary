package com.yema.viewpagertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter

class Myadapter : PagerAdapter() {

    private var list = mutableListOf<String>()


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return list.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(container.context).inflate(R.layout.tem_text, null)
//        var textView = view.findViewById<TextView>(R.id.tv_text)
//        textView.text = list[position]
        container.addView(view)
        return view
    }

    fun setlist(lists: MutableList<String>) {
        this.list = lists
        this.notifyDataSetChanged()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


    override fun getItemPosition(@NonNull `object`: Any): Int {
        return POSITION_NONE
    }

}