package com.example.shubham.engifestapp.CustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shubham.engifestapp.R;
import com.example.shubham.engifestapp.Interfaces.OnIndexChangeListener;


/**
 * Created by mohitkumar on 10/12/17.
 */

public class CircularIndexView extends ViewGroup {

    private boolean isShowCircle = true;
    private Context context;
    private Bitmap bitmap;
    private static float sPerAngle = 360.0f/14;
    private float angle = 0;
    private float startAngle = 0;
    private float centerXY;

      String[] places = new String[]{"BR Ambedkar Auditorium",
              "Wind Point",
              "Convocation Hall",
              "OAT",
              "Mini OAT",
              "MECH C",
              "Sports Complex",
              "SPS HALLS",
              "Clock Tower",
              "Edusat Hal",
              "Hostel Road",
              "DTU Entrance Gate",
              "DTU Lake",
              "Transit Hostel Ground"
      };


    private OnIndexChangeListener onIndexChangeListener;

    public CircularIndexView(Context context) {
        this(context,null);
    }

    public CircularIndexView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CircularIndexView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ring);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = 0;
        int height = 0;

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if(widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = bitmap.getWidth();
        }

        if(heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = bitmap.getHeight();
        }

        int layoutSize = Math.max(width,height);
        centerXY = layoutSize/2.0f;
        setMeasuredDimension(layoutSize,layoutSize);

        int count = getChildCount();
        for (int i=0;i<count;i++) {
            View child = getChildAt(i);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.save();
        Paint paint = new Paint(Paint.LINEAR_TEXT_FLAG);
        if(isShowCircle) {
            canvas.rotate((angle + startAngle), getWidth() / 2, getHeight() / 2);
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }
        canvas.restore();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        if(b) {
            View view = getChildAt(0);
            int childW = view.getMeasuredWidth();
            int childH = view.getMeasuredHeight();

            int left = getWidth()/2 - childW/2;
            int top = getHeight()/2 - childH/2;
            view.layout(left,top,left + childW,top + childH);
        }
    }

    private float lastX;
    private float lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        float startAngle = 0;

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                isShowCircle = true;
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE :
                isShowCircle = true;
                startAngle = getTranslateAngle(lastX,lastY);
                float endAngle = getTranslateAngle(x,y);
                int quadrant = getQuadrant(x,y);
                switch (quadrant) {
                    case 2:
                    case 3:
                        angle += startAngle - endAngle;
                        break;
                    case 1:
                    case 4:
                        angle += endAngle - startAngle;
                        break;
                }

                if(angle >= 360 || angle <= -360) {
                    angle = 0;
                }
                performAction();

                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_CANCEL :
            case MotionEvent.ACTION_UP :
                isShowCircle = true;
                break;
        }
        postInvalidate();
        return true;
    }

    private void performAction() {
        int index = (int)((angle + startAngle)/sPerAngle);
        int length = places.length;
        if (index > 0) {
            index = (length - index) % length;
        } else {
            index = Math.abs(index);
        }
        showTheChange(places[index]);
        if(onIndexChangeListener!=null) {
            onIndexChangeListener.OnIndexChange(places[index]);
        }
        requestLayout();
    }

    private void showTheChange(String place) {
        Toast.makeText(context,"Venue is" + place,Toast.LENGTH_SHORT);
    }

    private int getPlacePosition(String place) {
        int length = places.length;
        for(int i=0;i<length;i++) {
            if(place.equals(places[i])) {
                return i;
            }
        }
        return 0;
    }
    
    private float getPlacesAngle(String place) {
        int pos = getPlacePosition(place);
        return -1*sPerAngle*pos;
    }

    public void setIndexPlace(String place) {
        if(place == null) {
            return;
        }
        showTheChange(place);
        startAngle = getPlacesAngle(place);
        invalidate();
    }

    private int getQuadrant(float x,float y) {
        float tempX = x - centerXY;
        float tempY = y - centerXY;

        if(tempX >= 0 && tempY <= 0) {
            return 1;
        } else if (tempX >= 0 && tempY >= 0) {
            return 4;
        } else if (tempX <= 0 && tempY <= 0) {
            return 2;
        } else {
            return 3;
        }
    }

    private float getTranslateAngle(float xTouch, float yTouch) {
        float x = xTouch - centerXY;
        float y = yTouch - centerXY;
        float distance = (float) Math.sqrt(x*x + y*y);
        return (float)(Math.asin(y/distance)*180 / Math.PI);
    }

    public void setOnIndexChangeListener(OnIndexChangeListener onIndexChangeListener) {
        this.onIndexChangeListener = onIndexChangeListener;
    }
}
