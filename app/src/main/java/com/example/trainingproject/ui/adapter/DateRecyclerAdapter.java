package com.example.trainingproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trainingproject.R;
import com.example.trainingproject.model.TemperatureRecord;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DateRecyclerAdapter extends PagedListAdapter<TemperatureRecord, DateRecyclerAdapter.TemperatureRecordViewHolder> {

    public DateRecyclerAdapter(DiffUtil.ItemCallback<TemperatureRecord> diffUtilCallback) {
        super(diffUtilCallback);
    }

    @NonNull
    @Override
    public TemperatureRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new TemperatureRecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemperatureRecordViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class TemperatureRecordViewHolder extends RecyclerView.ViewHolder{

        TextView dateTV;
        TextView numberTV;
        TextView temperatureTV;

        TemperatureRecordViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTV = itemView.findViewById(R.id.date_tv);
            numberTV = itemView.findViewById(R.id.number_tv);
            temperatureTV = itemView.findViewById(R.id.temperature_tv);
        }

        void bind(TemperatureRecord temperatureRecord){
            if (temperatureRecord.getDate()!=null && temperatureRecord.getTemperature()!=null){
                dateTV.setText(temperatureRecord.getDate());
                numberTV.setText(String.format(Locale.US,"%04d", temperatureRecord.getNumber()));
                temperatureTV.setText(temperatureRecord.getTemperature());
            }

        }
    }

}
