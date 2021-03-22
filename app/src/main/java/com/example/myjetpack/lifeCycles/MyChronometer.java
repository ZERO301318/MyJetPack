package com.example.myjetpack.lifeCycles;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyChronometer extends Chronometer implements LifecycleObserver {
    private MyViewModel viewModel;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setViewModel(MyViewModel viewModel){
        this.viewModel = viewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter(){
        viewModel.setElapsedTime(SystemClock.elapsedRealtime() - getBase());
        stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter(){
        setBase(SystemClock.elapsedRealtime() - viewModel.getElapedTime().getValue());
        start();
    }
}