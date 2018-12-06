package com.yema.mytestlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yema.mytestlibrary.model.Pie
import com.yema.mytestlibrary.model.ShanXinViewData
import kotlinx.android.synthetic.main.activity_main.*
import com.yema.mytestlibrary.view.PercentPieView



class MainActivity : AppCompatActivity() {

    companion object {
        var pre = intArrayOf(20, 30, 10, 10, 10, 20)
        var arr = arrayOf("C#", "C", "C++", "JAVA", "JavaScript", "Object-C")


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pieArrayList = ArrayList<Pie>()
//        var values = intArrayOf(30, 40, 50)
//        var pieDataList = mutableListOf<PieData>();
//        var pieData1 = PieData()
//        pieData1.percentage = ((values[0]) / 100).toFloat();
//        pieData1.angle = pieData1.percentage * 360;
//        pieData1.color = Color.RED;
//        pieDataList.add(pieData1);
//
//        var pieData2 = PieData();
//        pieData2.percentage = (values[1] / 100).toFloat();
//        pieData2.angle = pieData2.percentage * 360;
//        pieData2.color = Color.GREEN;
//        pieDataList.add(pieData2);
//
//        var pieData3 = PieData()
//        pieData3.percentage = (values[2] / 100).toFloat();
//        pieData3.angle = pieData3.percentage * 360;
//        pieData3.color = Color.YELLOW;
//        pieDataList.add(pieData3);
//
//
////        var pieChartView = PieChartView(this);
//        ll_bg.setData(pieDataList);
//        ll_bg.invalidate()
//        ll_bg.addView(pieChartView)
//        this.addView(pieChartView);




        ///////view2
        var pieColor = intArrayOf(
            resources.getColor(R.color.blue),
            resources.getColor(R.color.red),
            resources.getColor(R.color.gray_dark),
            resources.getColor(R.color.dark),
            resources.getColor(R.color.colorPrimary),
            resources.getColor(R.color.black_alpha_light)
        )
        for ((index, value) in arr.withIndex()) {
            var pie = Pie(pre[index], arr[index], pieColor[index])
            pieArrayList.add(pie);
        }
        PieView.SetPie(pieArrayList);



        ///////view3
//
        val data2 = intArrayOf(10, 10, 20)
        val name2 = arrayOf("猫", "狗", "奶牛")
        pieView2.setData(data2, name2)


        //////pieView4

        var shanxlist = ArrayList<ShanXinViewData>()

        for (i in 0..2) {
            var shanx = ShanXinViewData(20,"adad")
            shanxlist.add(shanx)
        }
        pieView3.setData(shanxlist)

    }
}
