package com.example.booking.Model;

public class User {
    private  String Name;
    private  String Surname;
    private  String Email;
    private  String Password;

    public User() {

    }

    public User(String name, String surname, String email, String password) {
        Name = name;
        Surname = surname;
        Email = email;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {Surname = surname;}

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {Email = email;}

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) { Password = password; }
}
