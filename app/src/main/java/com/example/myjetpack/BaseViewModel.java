package com.example.myjetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private SavedStateHandle handle;
//    private MutableLiveData<Integer> num;
    public  final static String TAG = "KEY";

    public BaseViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getData(){
//        if(num == null){
//            num = new MutableLiveData<>();
//            num.setValue(0);
//        }
//        return num;
        if(!handle.contains(TAG)){
            handle.set(TAG,0);
        }
        return handle.getLiveData(TAG);
    }

    public void setNum(int n){
//        num.setValue(getLiveData().getValue() + n);
        getData().setValue(getData().getValue() + n);
    }
}