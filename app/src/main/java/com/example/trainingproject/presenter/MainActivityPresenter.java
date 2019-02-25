package com.example.trainingproject.presenter;

import android.app.Activity;

import com.example.trainingproject.R;
import com.example.trainingproject.ui.base.BaseFragment;
import com.example.trainingproject.util.NavControllerFactory;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * Singleton presenter
 */
public class MainActivityPresenter {

    private NavController mNavController;

    private static MainActivityPresenter instance = null;

    private MainActivityPresenter(){
    }

    public static MainActivityPresenter getInstance()
    {
        if(instance==null)
        {
            instance = new MainActivityPresenter();
        }
        return instance;
    }

    public void initNavController(Activity activity){
        mNavController = Navigation.findNavController(activity, R.id.nav_host_fragment);
    }

    public void buildNavControllerFactory(BaseFragment... baseFragments){
        new NavControllerFactory(mNavController, baseFragments);
    }

}
