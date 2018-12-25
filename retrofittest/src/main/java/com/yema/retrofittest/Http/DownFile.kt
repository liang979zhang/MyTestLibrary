package com.yema.retrofittest.Http

import android.content.Context
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

class DownFile {
    companion object {
        fun writeResponseBodyToDisk(context: Context, body: ResponseBody) {
            var futureStudioIconFile = File("${context.cacheDir}${File.separator}/aa.apk")
            var inputStream: InputStream? = null
            var outputStream: FileOutputStream? = null
            var fileReader = ByteArray(1024)
            val fileSize = body.contentLength()
            var fileSizeDownloaded = 0L

             inputStream = body.byteStream()

            outputStream = FileOutputStream(futureStudioIconFile)


            while (inputStream!!.read(fileReader) != -1) {
                val read = inputStream!!.read(fileReader)
                if (read == -1) {
                    break
                }
                outputStream.write(fileReader, 0, read)
                fileSizeDownloaded += read
                outputStream.flush()


            }
            outputStream.close()
            inputStream.close()
        }
    }

//    private boolean writeResponseBodyToDisk(ResponseBody body) {
//        try {
//            // todo change the file location/name according to your needs
//            File futureStudioIconFile = new File(getExternalFilesDir(null) + File.separator + "Future Studio Icon.png");
//
//            InputStream inputStream = null;
//            OutputStream outputStream = null;
//
//            try {
//                byte[] fileReader = new byte[4096];
//
//                long fileSize = body.contentLength();
//                long fileSizeDownloaded = 0;
//
//                inputStream = body.byteStream();
//                outputStream = new FileOutputStream(futureStudioIconFile);
//
//                while (true) {
//                    int read = inputStream.read(fileReader);
//
//                    if (read == -1) {
//                        break;
//                    }
//
//                    outputStream.write(fileReader, 0, read);
//
//                    fileSizeDownloaded += read;
//
//                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
//                }
//
//                outputStream.flush();
//
//                return true;
//            } catch (IOException e) {
//                return false;
//            } finally {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            }
//        } catch (IOException e) {
//            return false;
//        }
//    }


}