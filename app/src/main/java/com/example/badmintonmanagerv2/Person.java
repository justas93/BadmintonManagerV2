package com.example.badmintonmanagerv2;

import android.widget.EditText;

public class Person {
    private int id;
    private  String name;
    private String surname;
    private String sex;
    private int level;
    private double balance;
    int phoneNumber;

    public Person(int id, String name, String surname, String sex, int level, double balance, int phoneNumber){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.level = level;
        this.balance = balance;
        this.phoneNumber = phoneNumber;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }






    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " "+surname;
    }
}
