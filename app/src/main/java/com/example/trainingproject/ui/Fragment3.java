package com.example.trainingproject.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trainingproject.R;
import com.example.trainingproject.ui.base.BaseFragment;

import androidx.navigation.NavController;


public class Fragment3 extends BaseFragment {

    private NavController mNavController;

    public Fragment3() {
        // Required empty public constructor
    }

   static Fragment3 newInstance() {
        return new Fragment3();
    }

    @Override
    public void setmNavController(NavController navController) {
        mNavController = navController;
    }

    void onFragment3BackClick(View view) {
        mNavController.navigate(R.id.fragment2);
    }

    void onFragment3NextClick(View view) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment3, container, false);
    }


}
