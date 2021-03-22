package com.example.myjetpack.navigationDemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myjetpack.R;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = getActivity().findViewById(R.id.textView);
//        textView.setText(getArguments().getString("name","ERROR"));
        textView.setText(getArguments().getString("enter_name","ERROR"));
        getView().findViewById(R.id.button8).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_secondFragment2_to_homeFragment3));
    }
}