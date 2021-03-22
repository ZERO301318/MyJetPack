package com.example.myjetpack.myClass;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.myjetpack.R;

public class ShpSavedState extends AndroidViewModel {
    private final SavedStateHandle handle;
    private final String KEY = getApplication().getResources().getString(R.string.KEY);
    private final String SHP_NAME = getApplication().getResources().getString(R.string.SP_TAG);

    public ShpSavedState(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if(!handle.contains(KEY)){
            load();
        }
    }

    public MutableLiveData<Integer> getNumber(){
        return handle.getLiveData(KEY);
    }

    private void load(){
        SharedPreferences shp = getApplication().getSharedPreferences(SHP_NAME,Context.MODE_PRIVATE);
        handle.set(KEY,shp.getInt(KEY,0));
    }

    public void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(SHP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(KEY,getNumber().getValue());
        editor.apply();
    }

    public void add(int n){
        handle.set(KEY,getNumber().getValue() + n);
    }

}