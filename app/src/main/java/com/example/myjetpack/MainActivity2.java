package com.example.myjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.myjetpack.databinding.ActivityMainBinding;
import com.example.myjetpack.myClass.ShpSavedState;

public class MainActivity2 extends AppCompatActivity {

    ShpSavedState shpSavedState;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        shpSavedState = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(ShpSavedState.class);

        binding.setData(shpSavedState);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        shpSavedState.save();
    }
}