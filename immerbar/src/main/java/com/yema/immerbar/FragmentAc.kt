package com.yema.immerbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyf.barlibrary.ImmersionBar

class FragmentAc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        ImmersionBar.with(this).init()
    }
}
