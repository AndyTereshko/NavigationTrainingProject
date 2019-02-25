package com.example.trainingproject.ui;

import android.os.Bundle;

import com.example.trainingproject.R;
import com.example.trainingproject.presenter.MainActivityPresenter;
import com.example.trainingproject.ui.base.BaseFragment;
import com.example.trainingproject.util.Log;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainActivityPresenter mainActivityPresenter = MainActivityPresenter.getInstance();
        mainActivityPresenter.initNavController(this);
        initFragments();
        mainActivityPresenter.buildNavControllerFactory(fragment1, fragment2, fragment3);
    }

    private void initFragments(){
        fragment1 = Fragment1.newInstance();
        fragment2 = Fragment2.newInstance();
        fragment3 = Fragment3.newInstance();
    }


    public void onFragment1BackClick(View view) {
        Log.logToDebugNavigation("onFragment1BackClick");
        fragment1.onFragment1BackClick(view);
    }

    public void onFragment1NextClick(View view) {
        Log.logToDebugNavigation("onFragment1NextClick");
        fragment1.onFragment1NextClick(view);
    }

    public void onFragment2BackClick(View view) {
        Log.logToDebugNavigation("onFragment2BackClick");
        fragment2.onFragment2BackClick(view);
    }

    public void onFragment2NextClick(View view) {
        Log.logToDebugNavigation("onFragment2NextClick");
        fragment2.onFragment2NextClick(view);
    }

    public void onFragment3BackClick(View view) {
        Log.logToDebugNavigation("onFragment3BackClick");
        fragment3.onFragment3BackClick(view);
    }

    public void onFragment3NextClick(View view) {
        Log.logToDebugNavigation("onFragment3NextClick");
        fragment3.onFragment3NextClick(view);
    }



}
