package com.example.trainingproject.model;

import com.example.trainingproject.model.factory.TemperatureRecordFactory;
import com.example.trainingproject.util.log.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

public class MyPositionalDataSource extends PositionalDataSource<TemperatureRecord> {

    private final TemperatureRecordFactory temperatureRecordFactory;

    public MyPositionalDataSource(TemperatureRecordFactory temperatureRecordFactory) {
        this.temperatureRecordFactory = temperatureRecordFactory;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<TemperatureRecord> callback) {
        Log.logToDebugLoadInitial( " requestedStartPosition = " + params.requestedStartPosition +
                ", requestedLoadSize = " + params.requestedLoadSize);
        List<TemperatureRecord> result = temperatureRecordFactory.buildSeveralTemperatureRecords(params.requestedStartPosition, params.requestedLoadSize);
        callback.onResult(result, 0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<TemperatureRecord> callback) {
        Log.logToDebugLoadRange( " startPosition = " + params.startPosition + ", loadSize = " + params.loadSize);
        List<TemperatureRecord> result = temperatureRecordFactory.buildSeveralTemperatureRecords(params.startPosition, params.loadSize);
        callback.onResult(result);
    }

}
