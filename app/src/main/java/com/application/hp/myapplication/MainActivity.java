package com.application.hp.myapplication;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener
{
ImageView v;
TextView tv;
int ar[]= new int[4];
int counter=0;
GestureDetectorCompat gestureDetectorCompat;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v=findViewById(R.id.imageView);
        //tv=findViewById(R.id.textView);
        gestureDetectorCompat = new GestureDetectorCompat(this,this);
        //gestureDetectorCompat.setIsLongpressEnabled(true);

        ar[0]=R.drawable.img1;
        ar[1]=R.drawable.img2;
        ar[2]=R.drawable.img3;
        ar[3]=R.drawable.img4;

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float x1 = e1.getX();
        float x2 = e2.getX();
        if (x1 < x2){
            if(counter<ar.length) {

                v.setImageResource(ar[counter]);
                Toast.makeText(getApplicationContext(), "image" + counter, Toast.LENGTH_SHORT).show();
                counter++;
            }
        }
        else if (x1 > x2){
            if(counter>0) {
                counter--;
                v.setImageResource(ar[counter]);
                Toast.makeText(getApplicationContext(), "image" + counter, Toast.LENGTH_SHORT).show();
            }
        }

        return true;
    }
}
