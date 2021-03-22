package com.example.myjetpack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myjetpack.myClass.MyData;

public class Sharedpereference extends AppCompatActivity {
    final static String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpereference);
        MyData myData = new MyData(getApplicationContext());//不能用this，容易内存泄漏(浪费资源)
        myData.num = 1000;
        myData.save();
        Log.d(TAG, "onCreate: "+myData.load());
    }
}