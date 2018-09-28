package com.olgagoo.debug.homework.homework_4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class PieChartDrawer extends View{
    Paint paint;
    float value1;
    float value2;
    float value3;

    public PieChartDrawer(Context context) {
        super(context);
    }

    public PieChartDrawer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartDrawer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PieChartDrawer(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public  void setPieparts(int v1, int v2, int v3){
        int total = v1+v2+v3;
        this.value1 = ((float)v1/total)*360;
        this.value2 = ((float)v2/total)*360;
        this.value3 = ((float)v3/total)*360;
        invalidate();
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();

        RectF rectf = new RectF(0, 0, getHeight(), getHeight());

        paint.setColor(Color.GREEN);
        canvas.drawArc(rectf,0,value1,true,paint);

        paint.setColor(Color.RED);
        canvas.drawArc(rectf,value1,value2,true,paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(rectf,value1+value2, value3,true,paint);

    }

}
