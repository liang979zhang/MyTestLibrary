package com.yema.mytestlibrary

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn.setOnClickListener {
            startActivity(Intent(this, TestAc::class.java))
        }



    }


}
