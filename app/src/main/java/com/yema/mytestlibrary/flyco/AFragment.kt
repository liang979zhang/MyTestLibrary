package com.yema.mytestlibrary.flyco

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yema.mytestlibrary.R
import kotlinx.android.synthetic.main.activity_mvp.*

class AFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_mvp, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        btn.setOnClickListener {

            var flycoAc = activity as FlycoAc


            flycoAc.setTitleTest()


        }
    }


}