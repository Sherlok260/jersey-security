package com.example.jersey_todo.tables;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Arrays;
import java.util.Set;

public class User implements Principal {

    private String firstName;
    private String username;
    private String password;
    private String[] roles;

    @Override
    public String getName() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public User(String firstName, String username, String password) {
        this.firstName = firstName;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String username, String password, String[] roles) {
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }
}

