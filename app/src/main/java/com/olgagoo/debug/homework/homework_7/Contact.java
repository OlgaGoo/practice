package com.olgagoo.debug.homework.homework_7;

public class Contact {
    private String name;
    private String lastname;
    private int photo;


    public Contact(){
    }

    public Contact(String name, String lastname, int photo) {
        this.name = name;
        this.lastname = lastname;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
