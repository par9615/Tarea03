package com.iteso.pdm18_scrollabletabs.beans;

/**
 * Created by par9615 on 11/03/18.
 */

public class User {
    private String name;
    private String password;
    private boolean isLogged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
