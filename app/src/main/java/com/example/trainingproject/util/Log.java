package com.example.trainingproject.util;

public class Log {

    public static void logToDebugNavigation(String msg){
        android.util.Log.d(ConstStrings.navigationTag, msg);
    }

}
