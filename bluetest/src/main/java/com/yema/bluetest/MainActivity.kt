package com.yema.bluetest

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.bluetooth.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val REQUEST_ENABLE_BT: Int = 1003
    private var mScanning: Boolean = false
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var cameraFilePath = ""


    private lateinit var bluetoothDeviceArrayList: MutableList<BluetoothDevice>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bluetoothDeviceArrayList = mutableListOf<BluetoothDevice>()
        open.setOnClickListener {
            initBlueTooth()

        }

        btn_conn.setOnClickListener {
//            if (bluetoothDeviceArrayList.size > 0) {
//                conn(bluetoothDeviceArrayList[0])
//            }




        }

        btn_sleep.setOnClickListener {
//            SystemClock.sleep(60000)
            var mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var builder2 = Notification.Builder(this)
            builder2.setContentTitle("title")
                    .setContentText("测试内容") //<span style="font-family: Arial;">/设置通知栏显示内容</span>
//                    .setContentIntent(this.getDefalutIntent(Notification.FLAG_AUTO_CANCEL)) //设置通知栏点击意图
                    //  .setNumber(number) //设置通知集合的数量
                    .setTicker("测试通知来啦") //通知首次出现在通知栏，带上升动画效果的
                    .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                    .setPriority(Notification.PRIORITY_DEFAULT) //设置该通知优先级
                    .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                    .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                    .setDefaults(Notification.DEFAULT_VIBRATE)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合
                    //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                    .setSmallIcon(R.mipmap.ic_launcher);//设置通知小ICON

            var clickIntent = Intent(this, MyReceiver::class.java); //点击通知之后要发送的广播
            var contentIntent = PendingIntent.getBroadcast(this.applicationContext, 1003, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            var notification = builder2.build()
            notification.contentIntent =contentIntent
            mNotificationManager.notify(1003, notification)


        }

    }

    private fun conn(bluetoothDevice: BluetoothDevice) {
        bluetoothDevice.connectGatt(this@MainActivity, false, BluetoothGat())

    }


    fun initBlueTooth() {
        val manager: BluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        if (manager != null) {
            bluetoothAdapter = manager.adapter
            if (bluetoothAdapter != null) {
                if (!bluetoothAdapter!!.isEnabled) {
                    openBle()
                } else {
                    Toast.makeText(this@MainActivity, "已经打开", Toast.LENGTH_SHORT).show()
                    scanDevice(true)
                }
            }
        }

    }


    /**
     * 扫描或停止扫描
     */
    private fun scanDevice(enable: Boolean) {
        if (enable) {
            mScanning = true
            bluetoothAdapter!!.startLeScan(aa)
        }

    }

    /**
     * 打开蓝牙
     */
    private fun openBle() {
        //提示用户正在打开蓝牙
        val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == REQUEST_ENABLE_BT) {
            scanDevice(true)
        }
    }


    val aa = BluetoothAdapter.LeScanCallback { device, rssi, scanRecord ->
        if (device.name != null) {
            if (!bluetoothDeviceArrayList.contains(device)) {//去重
                bluetoothDeviceArrayList.add(device)
            }
            Log.e("tag", device.name)

        }
    }

    /**
     * 蓝牙连接成功回调
     */
    open class BluetoothGat : BluetoothGattCallback() {

        override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            super.onConnectionStateChange(gatt, status, newState)
            if (newState == BluetoothProfile.STATE_CONNECTED) {//连接成功
                Log.e("tag", "onConnectionStateChange 蓝牙连接")
                //这里要执行以下方法，会在onServicesDiscovered这个方法中回调，如果在                        //onServicesDiscovered方法中回调成功，设备才真正连接起来，正常通信
                gatt!!.discoverServices()
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                Log.e("tag", "onConnectionStateChange 蓝牙断连");
//                if (mBluetoothDevice != null) {
//                    //关闭当前新的连接
//                    gatt!!.close()
//                    characteristic = null;
//
//                }
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
            super.onServicesDiscovered(gatt, status)


            //回调之后，设备之间才真正通信连接起来
//            if (status === BluetoothGatt.GATT_SUCCESS) {
//                Log.e(TAG, "onServicesDiscovered 蓝牙连接正常")
//                val service = gatt.getService(UUID.fromString(BleConstantValue.serverUuid))//uuid从硬件工程师获取
//                characteristic = service.getCharacteristic(UUID.fromString(BleConstantValue.charaUuid))
//                gatt.readCharacteristic(characteristic)//执行之后，会执行下面的                onCharacteristicRead的回调方法
//                //设置通知，一般设备给手机发送数据，需要以下监听
//                setCharacteristicNotification(characteristic, true)
//                //耗时操作，如果有ui操作，需要用到handler
//                adapterFreshHandler.sendEmptyMessage(0)
//            } else {
//                Log.e(TAG, "onServicesDiscovered 蓝牙连接失败")
//            }
        }

    }


}


