package com.company;

import java.util.List;

public class RoomReservation {

    Integer registrationNumberPrac;
    String lastNamePrac;
    Integer socialSecurityNumberPat;
    String lastNamePat;
    String infoPat;
    Integer nbOfDays;
    Integer pricePerNight;
    String idRoom;

    public RoomReservation(Integer registrationNumberPrac, String lastNamePrac, Integer socialSecurityNumberPat, String lastNamePat, String infoPat, Integer nbOfDays, String idRoom) {
        this.registrationNumberPrac = registrationNumberPrac;
        this.lastNamePrac = lastNamePrac;
        this.socialSecurityNumberPat = socialSecurityNumberPat;
        this.lastNamePat = lastNamePat;
        this.infoPat = infoPat;
        this.nbOfDays = nbOfDays;
        this.pricePerNight = 45;
        this.idRoom = idRoom;
    }

    public Integer getRegistrationNumberPrac() {
        return registrationNumberPrac;
    }

    public String getLastNamePrac() {
        return lastNamePrac;
    }

    public Integer getSocialSecurityNumberPat() {
        return socialSecurityNumberPat;
    }

    public String getLastNamePat() {
        return lastNamePat;
    }

    public String getInfoPat() {
        return infoPat;
    }

    public Integer getNbOfDays() {
        return nbOfDays;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void generateInvoice() {
        System.out.println("-----------------------------------\n");
        System.out.println("Dear Sir or Madam " + lastNamePat);
        System.out.println("For hospitalisation with : ");
        System.out.println(lastNamePrac + " -------   registration number : " + registrationNumberPrac);
        System.out.println("For " + nbOfDays + " days in the room");
        System.out.println("Room number : " + idRoom);
        Integer price = nbOfDays*pricePerNight;
        System.out.println("\nTotal : " + price + " €");
        System.out.println("\n-----------------------------------");
    }


}
