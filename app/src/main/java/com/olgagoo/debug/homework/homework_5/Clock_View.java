package com.olgagoo.debug.homework.homework_5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.Calendar;

public class Clock_View extends View {
    private int weight, height = 0;
    private int padding = 0;
    private int fontSize = 0;
    private int numbersSapace = 0;
    private int handTruncation, hoursTruncation = 0;
    private int radius = 0;
    private boolean isInit = false;
    private Paint paint;
    private int [] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};
    private Rect rect = new Rect();


    public Clock_View(Context context) {
        super(context);
    }

    public Clock_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Clock_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Clock_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initClock(){
        weight = getWidth();
        height = getHeight();
        padding = numbersSapace + 50;
        fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13, getResources().getDisplayMetrics());
        int min = Math.min(height,weight);
        radius = min/2 - padding;
        handTruncation = min /20;
        hoursTruncation = min /7;
        paint = new Paint();
        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isInit){
            initClock();
        }

        canvas.drawColor(Color.BLACK);
        drawCircle(canvas);
        drawCenter(canvas);
        drawNumeral(canvas);
        drawHands(canvas);

        postInvalidateDelayed(500);
        invalidate();

    }

    private void drawCircle(Canvas canvas) {
        paint.reset();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawCircle(weight/2, height/2,radius + padding - 10, paint);
    }

    private void drawCenter(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(weight/2, height/2, 12, paint);

    }

    private void drawNumeral(Canvas canvas) {
        paint.setTextSize(fontSize);

        for (int number : numbers){
            String item = String.valueOf(number);
            paint.getTextBounds(item, 0, item.length(), rect);
            double angle = Math.PI/6 * (number - 3);
            float x = (float) (weight / 2 + Math.cos(angle) * radius - rect.width()/2);
            float y = (float) (height /2 + Math.sin(angle) * radius - rect.height()/2);
            canvas.drawText(item, x, y, paint);
        }
    }

    private void drawHands(Canvas canvas) {
        Calendar calendar = Calendar.getInstance();
        float hours = calendar.get(Calendar.HOUR_OF_DAY);
        hours = hours > 12 ? hours - 12 : hours;
        drawHaur(canvas, (hours + ((float) calendar.get(Calendar.MINUTE) / 60)) * 5f, true);
        drawHaur(canvas, calendar.get(Calendar.MINUTE), false);
        drawHaur(canvas, calendar.get(Calendar.SECOND), false);
    }

    private void drawHaur(Canvas canvas, double location, boolean isHour){
        double angle = Math.PI * location/30 + Math.PI / 2;
        int handRadius = isHour ? radius - handTruncation - hoursTruncation : radius - handTruncation;
        canvas.drawLine(weight/2, height/2,
                (float) (weight/2 - Math.cos(angle) * handRadius),
                (float) (height/2 - Math.sin(angle) * handRadius), paint );
    }
}
