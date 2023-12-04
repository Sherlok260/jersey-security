package com.example.jersey_todo.payload;

public class RegisterDto {

    private String firstName;
    private String username;
    private String password;

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

    public RegisterDto(String firstName, String username, String password) {
        this.firstName = firstName;
        this.username = username;
        this.password = password;
    }

    public RegisterDto() {
    }

    @Override
    public String toString() {
        return "RegisterDto{" +
                "firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
