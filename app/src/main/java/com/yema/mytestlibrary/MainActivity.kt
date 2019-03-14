package com.yema.mytestlibrary

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.FragmentActivity
import com.yema.mytestlibrary.flyco.FlycoAc
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.File
import android.media.MediaMetadataRetriever
import android.util.Log
import android.graphics.BitmapFactory
import android.graphics.Bitmap




class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn.setOnClickListener {


//            startActivity(Intent(this@MainActivity,FlycoAc::class.java))


            var intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "audio/*";//设置类型，我这里是任意类型，任意后缀的可以这样写。
//            intent.addCategory(Intent.CATEGORY_OPENABLE);
            var wrapperIntent = Intent.createChooser(intent, "选择音视频")
            startActivityForResult(intent,100)

        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val uri = data!!.data//得到uri，后面就是将uri转化成file的过程。

        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(uri.path)//文件路径
        val title = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE) // api level 10, 即从GB2.3.3开始有此功能
        Log.d("tag", "title:$title")//
        val album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)
        Log.d("tag", "album:$album")
        val mime = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE)
        Log.d("tag", "mime:$mime")
        val artist = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
        Log.d("tag", "artist:$artist")
        val duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION) // 播放时长单位为毫秒
        Log.d("tag", "duration:$duration")
        val bitrate = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_BITRATE) // 从api level 14才有，即从ICS4.0才有此功能
        Log.d("tag", "bitrate:$bitrate")
        val date = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE)
        Log.d("tag", "date:$date")

        val picture = mmr.embeddedPicture
        val bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.size)
//        musicCover.setImageBitmap(bitmap)
        Log.d("tag", "date:$date")


//        val pro = arrayOf(MediaStore.Images.Media.DATA)
//        val actualises = contentResolver.query(uri, pro, null, null, null)
//        val columnIndex = actualises.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
//        actualises.moveToFirst()
//        val pathname = actualises.getString(columnIndex)
//        val file = File(pathname)
//        if (file.isFile) {
//
//
////            RetrofitMamnager.getUserApi().uploadFile()
//
//
//        } else {
//
//        }



    }

}
