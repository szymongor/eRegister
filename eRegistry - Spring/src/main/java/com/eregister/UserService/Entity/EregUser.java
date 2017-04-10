package com.eregister.UserService.Entity;

/**
 * Created by Szymon on 07.04.2017.
 */
public class EregUser {
    int id;
    String login;
    String password;
    String role;

    public EregUser(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public EregUser(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
