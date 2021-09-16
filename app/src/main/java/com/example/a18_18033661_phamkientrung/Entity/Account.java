package com.example.a18_18033661_phamkientrung.Entity;

import java.util.Date;

public class Account {
    private int id;
    private String email;
    private Date timeLogin;

    public Account(String email, Date timeLogin) {
        this.email = email;
        this.timeLogin = timeLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTimeLogin() {
        return timeLogin;
    }

    public void setTimeLogin(Date timeLogin) {
        this.timeLogin = timeLogin;
    }
}
