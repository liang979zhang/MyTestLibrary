package com.yema.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MyViewModel::class.java)
        model.getUsers().observe(this, Observer {  })

        tv_clidk.setOnClickListener {

            model.getUsers().observe(this,object :Observer<List<User>>{
                override fun onChanged(t: List<User>?) {


                }


            })

        }

    }
}
