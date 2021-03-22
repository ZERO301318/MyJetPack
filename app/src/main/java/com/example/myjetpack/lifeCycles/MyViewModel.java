package com.example.myjetpack.lifeCycles;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Long> elapsedTime;

    MutableLiveData<Long> getElapedTime(){
        if(elapsedTime == null) {
            elapsedTime = new MutableLiveData<>();
            elapsedTime.setValue((long) 0);
        }
        return elapsedTime;
    }

    public void setElapsedTime(long n){
        getElapedTime().setValue(n);
    }
}