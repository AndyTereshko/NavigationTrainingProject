package com.example.trainingproject.model.factory;

import com.example.trainingproject.ui.base.BaseFragment;
import androidx.navigation.NavController;

public class NavControllerFactory {

    public NavControllerFactory(NavController navController, BaseFragment... fragments){
        for (BaseFragment fragment:fragments) {
            fragment.setmNavController(navController);
        }
    }

}
