package com.example.myjetpack.myClass;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.example.myjetpack.R;

public class MyData {
    private Context context;
    private Resources res;
    public int num;
    public MyData(Context context) {
        this.context = context;
        res = context.getResources();
    }

    public void save(){
        SharedPreferences sp = context.getSharedPreferences(res.getString(R.string.SP_TAG),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(res.getString(R.string.KEY),num);
        editor.apply();//异步，
//        editor.commit();同步容易出错，不建议使用
    }

    public int load(){
        SharedPreferences sp = context.getSharedPreferences(res.getString(R.string.SP_TAG),Context.MODE_PRIVATE);
        int tmp = sp.getInt(res.getString(R.string.KEY),res.getInteger(R.integer.defValue));
        tmp = num;
        return num;
    }

}