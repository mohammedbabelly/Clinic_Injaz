package com.example.moham.clinic.Lists;

public class ListDay {

    String patientName;
    String patientStatus;
    String time;

    public ListDay(String patientName, String patientStatus, String time) {
        this.patientName = patientName;
        this.patientStatus = patientStatus;
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public String getTime() {
        return time;
    }
}
