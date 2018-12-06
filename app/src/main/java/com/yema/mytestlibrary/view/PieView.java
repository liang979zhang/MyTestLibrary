package com.yema.mytestlibrary.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.yema.mytestlibrary.R;
import com.yema.mytestlibrary.model.Pie;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class PieView extends View {


    private Paint mPaint;
    //饼图和矩形的距离
    private final int PIE_RECT_PADDING = getResources().getDimensionPixelSize(R.dimen.pie_rect_padding);
    //矩形的宽度
    private final int RECT_WIDTH = getResources().getDimensionPixelSize(R.dimen.rect_width);
    //矩形和文字的距离
    private final int RECT_TEXT_PADDING = getResources().getDimensionPixelSize(R.dimen.rect_text_padding);
    //文字的大小
    private final int TEXT_SIZE = getResources().getDimensionPixelSize(R.dimen.text_size);
    //文字的垂直距离
    private final int TEXT_VERTICAL_PADDING = getResources().getDimensionPixelSize(R.dimen.text_vertical_padding);
    //得到文字颜色
    private final int TEXT_COLOR = getResources().getColor(R.color.gray_dark);
    //文字和控件顶部的距离
    private float mPadding;
    //饼图的半径
    private int mPieRadios;
    //所有数值的总和
    private int mMaxValue;
    //饼图开始的角度
    private int mStartAngle;
    //文字的宽度
    private int mTextWidth;
    //控件半高
    private int mControlHalfHeight;
    //当前索引
    private int mCurrentIndex;
    //左边距
    private int mRectMarginLeft;
    private int mTextMarginLeft;
    //当前颜色
    private int mCurrentColor;
    //圆的范围
    private RectF oval;
    //最长的字符串
    private String mMaxString;

    private List<Integer> mPieColorList;
    private List<Integer> mPieValue;
    private List<String> mStringList;
    private ArrayList<Pie> mPieArrayList;

    private RectF rect;

    /**
     * 数据字体大小
     */
    private float dataTextSize = 24;
    /**
     * 数据画笔
     */
    private Paint dataPaint;

    /**
     * 数据文本的大小
     */
    private Rect dataTextBound = new Rect();


    /**
     * 中心坐标
     */
    private int centerX;
    private int centerY;

    /**
     * 半径
     */
    private float radius;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPieColorList = new ArrayList<>();
        mPieValue = new ArrayList<>();
        mStringList = new ArrayList<>();
        mPaint = new Paint();
        mMaxString = "";
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);//画笔宽度
        mPaint.setAntiAlias(true);//抗锯齿


        dataPaint = new Paint();
        dataPaint.setStrokeWidth(2);
        dataPaint.setTextSize(dataTextSize);
        dataPaint.setAntiAlias(true);
        dataPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        mTextWidth = (int) mPaint.measureText(mMaxString);
        mControlHalfHeight = height / 2;
        //饼图半径
        mPieRadios = mControlHalfHeight - 5;
        //控件内容宽度
        int contentWidth = mPieRadios * 2 + PIE_RECT_PADDING + RECT_WIDTH + RECT_TEXT_PADDING + mTextWidth;
        //内容的左边距
        int contentMarginLeft = (width - contentWidth) / 2;
        //矩形的左边距
        mRectMarginLeft = contentMarginLeft + mPieRadios * 2 + PIE_RECT_PADDING;
        //文字的左边距
        mTextMarginLeft = mRectMarginLeft + RECT_WIDTH + RECT_TEXT_PADDING;
        //文字和控件顶部的距离
        mPadding = height / mPieArrayList.size() * 0.8f;
        oval = new RectF(contentMarginLeft, mControlHalfHeight - mPieRadios,
                contentMarginLeft + mPieRadios * 2, mControlHalfHeight + mPieRadios);



        centerX = getMeasuredWidth() / 2;
        centerY = getMeasuredHeight() / 2;
        //设置半径为宽高最小值的1/4
        radius = Math.min(getMeasuredWidth(), getMeasuredHeight()) / 4;
    }

    /**
     * @param pieArrayList
     */
    public void SetPie(ArrayList<Pie> pieArrayList) {
        mPieArrayList = pieArrayList;
        for (Pie mPie : mPieArrayList) {
            mPieColorList.add(mPie.PieColor);
            mPieValue.add(mPie.PieValue);
            mStringList.add(mPie.PieString);
            if (mMaxString.length() > mPie.PieString.length())
                mMaxString = mPie.PieString;
        }

        //使用postInvalidate可以直接在主线程中更新界面
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mStartAngle = -90;
        mCurrentIndex = 0;
        mMaxValue = 100;
        mPaint.setStyle(Paint.Style.FILL);

        for (int i = 0; i < mPieValue.size(); i++) {
            mCurrentColor = mPieColorList.get(mCurrentIndex);
            Log.i("mCurrentColor", "onDraw: " + mCurrentColor);
            drawPie(canvas, mPieValue.get(mCurrentIndex),i);//绘制扇形
            drawRect(canvas);//右边的方块显示
            drawText(canvas, mStringList.get(mCurrentIndex));//右边的文字显示


            mCurrentIndex++;
        }
    }

    /**
     * 绘制饼图
     *  @param canvas
     * @param amount
     * @param i
     */
    private void drawPie(Canvas canvas, int amount, int i) {
        mPaint.setColor(mCurrentColor);
        mPaint.setStyle(Paint.Style.FILL);
        int angle = (int) (360f * amount / mMaxValue);
        Log.d("angle", "drawPie: " + angle);
        canvas.drawArc(oval, mStartAngle, angle, true, mPaint);
        drawData(canvas, angle, i, 0.2f);
        mStartAngle += angle;

//        mPaint.setColor(Color.YELLOW);        //文字颜色
//        float x = (float) (100 / 2 * Math.cos(mStartAngle * Math.PI / 180));    //计算文字位置坐标
//        float y = (float) (100 / 2 * Math.sin(mStartAngle * Math.PI / 180));
//        canvas.drawText(mStringList.get(i), x, y, paint);    //绘制文字
    }


    String[] names = {"猫", "狗", "奶牛", "羊驼", "大象", "狮子", "老虎"};
    /**
     * 绘制数据
     *
     * @param canvas  画布
     * @param degree  第i段弧线中心点相对于纵轴的夹角度数
     * @param i       第i段弧线
     * @param percent 数据百分比
     */
    private void drawData(Canvas canvas, float degree, int i, float percent) {
        //弧度中心坐标
        float startX = calculatePosition(degree)[0];
        float startY = calculatePosition(degree)[1];

        //获取名称文本大小
        dataPaint.getTextBounds(names[i], 0, names[i].length(), dataTextBound);
        //绘制名称数据，20为纵坐标偏移量
        canvas.drawText(names[i],
                startX - dataTextBound.width() / 2,
                startY + dataTextBound.height() / 2,
                dataPaint);


//        //拼接百分比并获取文本大小
//        DecimalFormat df = new DecimalFormat("0.0");
//        String percentString = df.format(percent * 100) + "%";
//        dataPaint.getTextBounds(percentString, 0, percentString.length(), dataTextBound);
//
//        //绘制百分比数据，20为纵坐标偏移量
//        canvas.drawText(percentString,
//                startX - dataTextBound.width() / 2,
//                startY + dataTextBound.height() * 2 - 20,
//                dataPaint);
    }





    /**
     * 计算每段弧度的中心坐标
     *
     * @param degree 当前扇形中心度数
     */
    private float[] calculatePosition(float degree) {
        //由于Math.sin(double a)中参数a不是度数而是弧度，所以需要将度数转化为弧度
        //而Math.toRadians(degree)的作用就是将度数转化为弧度
        //sin 一二正，三四负 sin（180-a）=sin(a)
        //扇形弧线中心点距离圆心的x坐标
        float x = (float) (Math.sin(Math.toRadians(degree)) * mPieRadios);
        //cos 一四正，二三负
        //扇形弧线中心点距离圆心的y坐标
        float y = (float) (Math.cos(Math.toRadians(degree)) * mPieRadios);

        //每段弧度的中心坐标(扇形弧线中心点相对于view的坐标)
        float startX = centerX + x;
        float startY = centerY - y;

        float[] position = new float[2];
        position[0] = startX;
        position[1] = startY;
        return position;
    }
    /**
     * 绘制矩形
     *
     * @param canvas
     */
    private void drawRect(Canvas canvas) {
        if (mCurrentIndex == 0) {
            rect = new RectF(mRectMarginLeft, mPadding, mRectMarginLeft + RECT_WIDTH, mPadding + RECT_WIDTH);
            canvas.drawRect(rect, mPaint);
        } else {
            rect = new RectF(mRectMarginLeft, (mCurrentIndex) * TEXT_VERTICAL_PADDING + mPadding, mRectMarginLeft + RECT_WIDTH, (mCurrentIndex) * TEXT_VERTICAL_PADDING + mPadding + RECT_WIDTH);
            canvas.drawRect(rect, mPaint);
        }
    }

    /**
     * 绘画文字
     *
     * @param canvas
     * @param text
     */
    private void drawText(Canvas canvas, String text) {
        mPaint.setColor(TEXT_COLOR);
        if (mCurrentIndex == 0) {
            canvas.drawText(text, mTextMarginLeft, mPadding + TEXT_SIZE * 0.8f - 5, mPaint);
        } else {
            canvas.drawText(text, mTextMarginLeft, (mCurrentIndex) * TEXT_VERTICAL_PADDING + mPadding + TEXT_SIZE * 0.8f - 5, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();
            Log.e("", x + "-----------");
        }
        return true;
    }
}
