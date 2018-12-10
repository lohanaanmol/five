package com.application.hp.proximityimage;



import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    ImageView img;
    SensorManager sm;
    Sensor s,s1;
    GestureDetectorCompat gestureDetectorCompat;

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    int count=0;
    float height, width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.imageView);


        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        s1=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        width=img.getScaleX();
        height=img.getScaleY();
    }


    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {

            float v=sensorEvent.values[0];
            if(v<s.getMaximumRange()) {

                img.setScaleX((float) (0.5+width));
                img.setScaleY((float) (0.5+height));

            }
            else{
                img.setScaleX(width);
                img.setScaleY(height);
            }
        }

    }




    @Override


    public boolean onTouchEvent(MotionEvent event){



        gestureDetectorCompat.onTouchEvent(event);

        return super.onTouchEvent(event);
    }
}




