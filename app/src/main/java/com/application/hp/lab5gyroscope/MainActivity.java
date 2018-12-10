package com.application.hp.lab5gyroscope;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager sa;
    ImageView imageView;
    int ar[]= new int[4];
    Sensor mGyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        sa = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mGyro = sa.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        ar[0] = R.drawable.pic1;
        ar[1] = R.drawable.pic2;
        ar[2] = R.drawable.pic3;
        ar[3] = R.drawable.pic4;
        imageView.setImageResource(ar[0]);
    }
        @Override
         protected void onResume() {
            super.onResume();
            sa.registerListener(this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
        }
        @Override
                protected void onPause() {
            super.onPause();
            sa.unregisterListener(this);
        }
        @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
        @Override
    public void onSensorChanged(SensorEvent event) {
        float lux=event.values[2];
        if(event.values[2]<-0.1 && event.values[2]>0.9){
                imageView.setImageResource(ar[1]);
                Toast.makeText(getApplicationContext(), "clockwise", Toast.LENGTH_SHORT).show();
            }
            if(event.values[2]>0.1 && event.values[2]<0.9) {
                imageView.setImageResource(ar[2]);
                Toast.makeText(getApplicationContext(), "anticlockwise", Toast.LENGTH_SHORT).show();
            }
            if(event.values[2]>=0.1 && event.values[2]<=0.1) {
                imageView.setImageResource(ar[0]);
            }
            if(event.values[2]>=0.9){
            imageView.setImageResource(ar[3]);

            }

            }
}
