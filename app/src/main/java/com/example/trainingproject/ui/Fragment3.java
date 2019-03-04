package com.example.trainingproject.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trainingproject.R;
import com.example.trainingproject.presenter.MainActivityPresenter;
import com.example.trainingproject.ui.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;


public class Fragment3 extends BaseFragment {

    private NavController mNavController;
    private MainActivityPresenter mainActivityPresenter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

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



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        mainActivityPresenter = MainActivityPresenter.getInstance();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainActivityPresenter.initDataForRecyler());
        return view;
    }


}
