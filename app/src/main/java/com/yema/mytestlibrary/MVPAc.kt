package com.yema.mytestlibrary

import android.os.Bundle
import android.widget.Toast
import com.yema.mytestlibrary.basemvp.BaseActivity
import kotlinx.android.synthetic.main.activity_mvp.*

class MVPAc : BaseActivity<MvpView, MvpPer>(), MvpView {
    override fun <Aa> OnSuccess(t: Aa) {
        t as com.yema.mytestlibrary.Aa

        Toast.makeText(this, t.name, Toast.LENGTH_SHORT).show()


    }

    override fun <Aa> OnError(t: Aa) {
        t as com.yema.mytestlibrary.Aa
        Toast.makeText(this, t.toString(), Toast.LENGTH_SHORT).show()

    }

    private lateinit var per: MvpPer
    override fun showDialog() {
    }


    override fun initPresenter(): MvpPer {
        per = MvpPer()
        return per
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        btn.setOnClickListener {
            per.loadData()
        }



    }
}
