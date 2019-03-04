package com.example.trainingproject.presenter;

import android.app.Activity;

import com.example.trainingproject.R;
import com.example.trainingproject.model.MyPositionalDataSource;
import com.example.trainingproject.model.TemperatureRecord;
import com.example.trainingproject.model.factory.TemperatureRecordFactory;
import com.example.trainingproject.ui.adapter.DateRecyclerAdapter;
import com.example.trainingproject.ui.base.BaseFragment;
import com.example.trainingproject.util.executors.MainThreadExecutor;
import com.example.trainingproject.model.factory.NavControllerFactory;

import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil;

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

    public DateRecyclerAdapter initDataForRecyler(){
        // DataSource
        DiffUtil.ItemCallback<TemperatureRecord> temperatureRecordItemCallback = new DiffUtil.ItemCallback<TemperatureRecord>() {
            @Override
            public boolean areItemsTheSame(@NonNull TemperatureRecord oldItem, @NonNull TemperatureRecord newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull TemperatureRecord oldItem, @NonNull TemperatureRecord newItem) {
                return oldItem.equals(newItem);
            }
        };
        MyPositionalDataSource dataSource = new MyPositionalDataSource(new TemperatureRecordFactory());

        // PagedList
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setPageSize(10)
                        .build();

                PagedList<TemperatureRecord> pagedList = new PagedList.Builder<>(dataSource, config)
                        .setNotifyExecutor(new MainThreadExecutor())
                        .setFetchExecutor(Executors.newSingleThreadExecutor())
                        .build();


        // Adapter
        DateRecyclerAdapter adapter = new DateRecyclerAdapter(temperatureRecordItemCallback);
        adapter.submitList(pagedList);
        return adapter;
    }

}
