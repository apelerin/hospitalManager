package com.company;

public class Patient extends Person{
    Integer socialSecurityNumber;
    String address;
    String phone;
    String mail;

    public Patient(String lastName, String firstName, Integer socialSecurityNumber, String address, String phone, String mail) {
        super(lastName, firstName);
        this.socialSecurityNumber = socialSecurityNumber;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }
}
