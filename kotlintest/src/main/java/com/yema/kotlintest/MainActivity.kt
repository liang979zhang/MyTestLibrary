package com.yema.kotlintest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.florent37.inlineactivityresult.kotlin.startForResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MyViewModel::class.java)
        model.getUsers().observe(this, Observer { })

        tv_clidk.setOnClickListener {



            startActivityForResult(Intent(this@MainActivity,Main2Activity::class.java),0)
//            startForResult(Intent(this@MainActivity, Main2Activity::class.java)) {
//                Log.e("tag", "")
//            }.onFailed {
//                Log.e("tag", "")
//
//            }

//            model.getUsers().observe(this,object :Observer<List<User>>{
//                override fun onChanged(t: List<User>?) {
//
//
//                }
//
//
//            })

        }

        tv_clidk2.setOnClickListener {
            setResult(-1)
            finish()
        }

    }
}
