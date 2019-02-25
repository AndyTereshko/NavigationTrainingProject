package com.example.trainingproject.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trainingproject.R;
import com.example.trainingproject.ui.base.BaseFragment;

import androidx.navigation.NavController;


public class Fragment1 extends BaseFragment {

    private NavController mNavController;


    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1, container, false);
    }


    @Override
    public void setmNavController(NavController navController) {
            mNavController = navController;
    }

    static Fragment1 newInstance() {
        return new Fragment1();
    }

    void onFragment1BackClick(View view) {
    }

    void onFragment1NextClick(View view) {
        mNavController.navigate(R.id.action_fragment1_to_fragment2);
    }




}
