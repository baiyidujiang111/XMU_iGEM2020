package com.example.igem2020;

import android.app.Application;

public class MyApplication extends Application {
    private String username="";
    private String phone="";
    private String email="";
    private String address="";

    private String teatype="";
    private String date="";
    private String place="";

    private String ip_url="http://81.68.78.174:9090";



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeatype() {
        return teatype;
    }

    public void setTeatype(String teatype) {
        this.teatype = teatype;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getIp_url() {
        return ip_url;
    }

    public void setIp_url(String ip_url) {
        this.ip_url = ip_url;
    }
}
