package com.example.trainingproject.model.factory;

import com.example.trainingproject.R;
import com.example.trainingproject.model.TemperatureRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TemperatureRecordFactory {

    //remembering last position
    private int lastRecordPosition = 1;

    //constants for day generator
    private final static int minDay = 1;
    private final static int maxDay = 28;
    private final static int minMonth = 1;
    private final static int maxMonth = 12;
    private final static int minYear = 1800;
    private final static int maxYear = 2019;
    private final static int minTemperature = 0;
    private final static int maxTemperature = 50;

    /** Factory initialization for PagingLibrary
     *
     * @param startPosition ¯\_(ツ)_/¯ filling random values while remembering last position in this class
     * @param size list size
     * @return generated with random values list
     */
    public List<TemperatureRecord> buildSeveralTemperatureRecords(int startPosition, int size){
        int sortNumber, day, month, year;
        List<TemperatureRecord> temperatureRecordList = new ArrayList<>();
        for(int i=1;i<size;i++){
            day = getRandomIntWithBounds(maxDay, minDay);
            month = getRandomIntWithBounds(maxMonth, minMonth);
            year = getRandomIntWithBounds(maxYear, minYear);
            String dateBuilder = Integer.toString(day) +"."+Integer.toString(month)+"."+Integer.toString(year);
            String temperatureBuilder = getRandomTemperature();
            lastRecordPosition++;
            sortNumber = lastRecordPosition;
            TemperatureRecord temperatureRecord = new TemperatureRecord(sortNumber,dateBuilder,temperatureBuilder);
            temperatureRecordList.add(temperatureRecord);
        }
        return temperatureRecordList;
    }

    /**
     * util helping method to get random values
     * @param maxValue max bound
     * @param minValue min bound
     * @return random int value
     */

    private int getRandomIntWithBounds(int maxValue, int minValue){
        Random random = new Random();
        return random.nextInt(maxValue - minValue) + minValue;
    }

    /**
     * Example -38C
     * @return string of temperature
     */
    private String getRandomTemperature(){
        Random random = new Random();
        boolean minusPlus = random.nextBoolean();
        String minusPlusString;
        int temperature = getRandomIntWithBounds(maxTemperature,minTemperature);
        if (minusPlus)
            minusPlusString = "+";
        else if(temperature==0)
            minusPlusString = "";
        else
            minusPlusString = "-";
        return minusPlusString + Integer.toString(temperature) + "°C";
    }
}
