package com.example.moham.clinic.Extra;

import java.text.DateFormat;
import java.util.Calendar;

public class CurrentDate {
    public String currentDate;

    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        calendar.get(Calendar.DAY_OF_WEEK);
        return currentDate;

    }

    public int getNumOfToday() {

        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    public int test() {

        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int []getWeakRenge()
    {
        int a[]=new int[2];
        Calendar calendar = Calendar.getInstance();


        int plus=7- calendar.get(Calendar.DAY_OF_WEEK);
        int min= calendar.get(Calendar.DAY_OF_WEEK);
        if(plus==0)
        {
            plus=7;
            min=0;
        }
        a[0]= calendar.get(Calendar.DAY_OF_MONTH)-min;
        a[1]= calendar.get(Calendar.DAY_OF_MONTH)+plus;
        return a;
    }


}
