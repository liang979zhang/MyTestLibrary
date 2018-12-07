package com.yema.retrofittest.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.caimuhao.rxpicker.utils.RxPickerImageLoader

class GlideImageLoader : RxPickerImageLoader {
    override fun display(imageView: ImageView?, path: String?, width: Int, height: Int) {


        val requst = RequestOptions().apply {
            this.error(android.R.drawable.stat_notify_error)
            this.centerCrop()
        }



        Glide.with(imageView!!.context)
            .load(path)
            .apply(requst)
            .into(imageView)
    }


}