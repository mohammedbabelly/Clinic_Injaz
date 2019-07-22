package com.example.moham.clinic.Extra;

import java.util.ArrayList;

public class test {
    public ArrayList<String> time = new ArrayList<String>();
    public ArrayList<String> firstName = new ArrayList<String>();
    public ArrayList<String> lastName = new ArrayList<String>();
    public  ArrayList<String> type = new ArrayList<String>();
    public int size=1;

    public void setData(String name1,String name2,String type,String time)
    {
        firstName.add(name1);
        lastName.add(name2);
        this.type.add(type);
        this.time.add(time);
    }

    public ArrayList<String> getFirstName()
    {
        return firstName;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public ArrayList<String> getLastName() {
        return lastName;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public int getSize() {
        return firstName.size();
    }
}
