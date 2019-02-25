package com.example.trainingproject.ui;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trainingproject.R;
import com.example.trainingproject.ui.base.BaseFragment;

import androidx.navigation.NavController;


public class Fragment2 extends BaseFragment {

    private NavController mNavController;

    public Fragment2() {
        // Required empty public constructor
    }

    static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public void setmNavController(NavController navController) {
        mNavController = navController;
    }

    void onFragment2BackClick(View view) {
        mNavController.navigate(R.id.fragment1);
    }

    void onFragment2NextClick(View view) {
        mNavController.navigate(R.id.fragment3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }


}
