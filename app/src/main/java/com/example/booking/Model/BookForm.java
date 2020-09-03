package com.example.booking.Model;

import android.widget.Spinner;

public class BookForm {
    private String Name;
    private String Surname;
    private String Email;
    private String ClassT;
    private String Ticket;




    public BookForm(){

    }

    public BookForm(String name, String surname, String email, String classT, String ticket) {
        Name = name;
        Surname = surname;
        Email = email;
        ClassT = classT;
        Ticket = ticket;




    }


    public String getName(){
        return Name;
    }

    public void setName(String name){
        Name = name;
    }

    public String getSurname(){
        return Surname;
    }

    public void setSurname(String surname){
        Surname = surname;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String email){
        Email = email;
    }

    public String getClassT() {return ClassT;}

    public void setClassT(String classT) {ClassT = classT;}

    public String getTicket() {return Ticket;}

    public void setTicket(String ticket) {Ticket = ticket;}




}
