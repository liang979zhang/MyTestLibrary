package com.yema.immerbar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class WelComeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wel_come)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 5000)
    }
}
