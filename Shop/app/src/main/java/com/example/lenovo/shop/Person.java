package com.example.lenovo.shop;

/**
 * Created by lenovo on 2018/11/19.
 */

public class Person {
    private String name;
    private String phoneNumber;
    private String passWord;
    public  Person(){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.passWord=passWord;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
