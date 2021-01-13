package com.company;

public class Practitioner extends Person{
    Integer registrationNumber;
    String speciality;
    String rank;
    Integer hourlyRate;

    public Practitioner(String lastName, String firstName, Integer registrationNumber, String speciality, String rank, Integer hourlyRate) {
        super(lastName, firstName);
        this.registrationNumber = registrationNumber;
        this.speciality = speciality;
        this.rank = rank;
        this.hourlyRate = hourlyRate;
    }

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getRank() {
        return rank;
    }

    public Integer getHourlyRate() {
        return hourlyRate;
    }
}
