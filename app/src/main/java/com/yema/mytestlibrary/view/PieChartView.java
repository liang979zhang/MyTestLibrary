package com.yema.mytestlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.yema.mytestlibrary.model.PieData;

import java.util.List;


public class PieChartView extends View {

    private Paint mPaint;
    public List<PieData> pieDataList;
    // 饼状图初始绘制角度
    private float mStartAngle = 0;

    public PieChartView(Context context) {
        this(context, null);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setData(List<PieData> dataList){
        if (null == dataList || dataList.size() == 0)
            return;
        pieDataList = dataList;

        invalidate(); //触发onDraw
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(4);

        rectF = new RectF(100f, 100f, 600f, 600f); //正方形背景
    }

    private RectF rectF;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == pieDataList || pieDataList.size() == 0)
            return;

        float currentAngle = mStartAngle;
        for (int i = 0;i<pieDataList.size();i++){
            PieData pieData = pieDataList.get(i);
            mPaint.setColor(pieData.color);
            canvas.drawArc(rectF,currentAngle,pieData.angle,true,mPaint); //画弧
            currentAngle += pieData.angle;
        }

    }

}
