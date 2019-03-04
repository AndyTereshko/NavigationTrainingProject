package com.example.trainingproject.model;

public class TemperatureRecord {
    public int id;
    private int number;
    private String date;
    private String temperature;

    public TemperatureRecord(int number, String date, String temperature){
        this.id = number;
        this.number = number;
        this.date = date;
        this.temperature = temperature;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getTemperature() {
        return temperature;
    }
}
