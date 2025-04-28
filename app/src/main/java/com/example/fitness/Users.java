package com.example.fitness;

public class Users {
    String name, email, password, confirmPass;

    public Users() {}


    public Users(String name, String email, String password, String confirmPass) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
}
