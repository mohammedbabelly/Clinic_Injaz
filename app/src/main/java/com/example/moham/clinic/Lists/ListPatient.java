package com.example.moham.clinic.Lists;

public class ListPatient {
    String name1,name2,name3,id;

    public ListPatient(String name1, String name2, String name3, String id) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public String getId() {
        return id;
    }
}
