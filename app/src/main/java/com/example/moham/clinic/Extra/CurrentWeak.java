package com.example.moham.clinic.Extra;

import android.widget.Switch;

public class CurrentWeak {

    int numOfDay;
    public void setDay(String nameOfDay)
    {
        if(nameOfDay.equals("Saturday")) numOfDay=0;
        if(nameOfDay.equals("Sunday")) numOfDay=1;
        if(nameOfDay.equals("Monday")) numOfDay=2;
        if(nameOfDay.equals("Tuesday")) numOfDay=3;
        if(nameOfDay.equals("Wednesday")) numOfDay=4;
        if(nameOfDay.equals("Thursday")) numOfDay=5;

    }

    public int getNumOfDay()
    {
        return numOfDay;
    }
}
