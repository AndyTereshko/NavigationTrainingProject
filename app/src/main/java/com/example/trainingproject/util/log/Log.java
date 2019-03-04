package com.example.trainingproject.util.log;

import com.example.trainingproject.util.ConstStrings;

public class Log {

    public static void logToDebugNavigation(String msg){
        android.util.Log.d(ConstStrings.navigationTag, msg);
    }
    public static void logToDebugLoadInitial(String msg){
        android.util.Log.d(ConstStrings.loadInitialTag, msg);
    }
    public static void logToDebugLoadRange(String msg){
        android.util.Log.d(ConstStrings.loadRangeTag, msg);
    }

}
