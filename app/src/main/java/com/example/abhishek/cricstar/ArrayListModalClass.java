package com.example.abhishek.cricstar;

/**
 * Created by abhishek on 14/07/17.
 */

public class ArrayListModalClass {

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int serial;
    private String name;

    public  ArrayListModalClass(int serial, String name){
        this.serial=serial;
        this.name=name;

    }
}
