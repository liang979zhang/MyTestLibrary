package com.yema.mytestlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.yema.mytestlibrary.dialog.LoadingDialog
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn.setOnClickListener {
            LoadingDialog().setHintMsg("aasdadsad").show(this@MainActivity.supportFragmentManager,"asda")
        }
    }


}
