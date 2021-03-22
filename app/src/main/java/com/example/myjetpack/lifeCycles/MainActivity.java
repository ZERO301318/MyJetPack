package com.example.myjetpack.lifeCycles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Xml;

import com.example.myjetpack.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyViewModel viewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        MyChronometer myChronometer = findViewById(R.id.chronometer);
        myChronometer.setViewModel(viewModel);
        getLifecycle().addObserver(myChronometer);
    }
}