package com.yema.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yema.retrofittest.Http.RetrofitMamnager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitMamnager.getApi()

    }
}
