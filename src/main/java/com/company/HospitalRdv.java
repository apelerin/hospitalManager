package com.company;

public class HospitalRdv {
    Integer MatriculePractien;
    Integer NumSecu;
    Integer HoursAndDate;
    String Lieu;

    public HospitalRdv(Integer matriculePractien, Integer numSecu, Integer hoursAndDate, String lieu) {
        MatriculePractien = matriculePractien;
        NumSecu = numSecu;
        HoursAndDate = hoursAndDate;
        Lieu = lieu;
    }


    public Integer getMatriculePractien() {
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
