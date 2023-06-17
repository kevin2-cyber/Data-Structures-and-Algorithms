package com.eduful9877.queue;

public class CustomerJ {

    private int id;
    private String firstName;
    private String secondName;

    public CustomerJ(int id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFullName() {
        return getFirstName() + getSecondName();
    }

    public void setFullName(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        String fullName = getFullName();
        fullName = firstName + secondName;
    }

}
