package com.company;

public class HospitalRdv {
    String MatriculePractien;
    Integer NumSecu;
    Integer HoursAndDate;
    String Lieu;

    public HospitalRdv(String matriculePractien, Integer numSecu, Integer hoursAndDate, String lieu) {
        MatriculePractien = matriculePractien;
        NumSecu = numSecu;
        HoursAndDate = hoursAndDate;
        Lieu = lieu;
    }


    public String getMatriculePractien() {
        return MatriculePractien;
    }

    public Integer getNumSecu() {
        return NumSecu;
    }

    public Integer getHoursAndDate() {
        return HoursAndDate;
    }

    public String getLieu() {
        return Lieu;
    }



}
