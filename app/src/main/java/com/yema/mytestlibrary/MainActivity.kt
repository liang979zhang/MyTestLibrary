package com.yema.mytestlibrary

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.FragmentActivity
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.tools.ToastManage
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn.setOnClickListener {
            ToastManage.s(this,BuildConfig.API_HOST)
//            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//
//
//            startActivityForResult(cameraIntent, PictureConfig.REQUEST_CAMERA)

        }


    }


}
