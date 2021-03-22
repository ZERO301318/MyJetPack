package com.example.myjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myjetpack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    BaseViewModel baseViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        TextView txt = findViewById(R.id.txt1);
//        baseViewModel.getLiveData().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                txt.setText(String.valueOf(integer));
//            }
//        });
//        findViewById(R.id.plus1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                baseViewModel.setNum(1);
//            }
//        });
//        findViewById(R.id.mins1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                baseViewModel.setNum(-1);
//            }
//        });

        /*dataBinding*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        baseViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(BaseViewModel.class);
        //传递数据
//        binding.setData(baseViewModel);
//        //设置数据观察
//        binding.setLifecycleOwner(this);

    }
}