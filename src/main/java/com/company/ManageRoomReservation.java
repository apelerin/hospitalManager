package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManageRoomReservation {

    public static List<RoomReservation> listReservations = new ArrayList<>();
    public static Hospital myHospital = new Hospital("quimper", 8, 20);

    private static Scanner scan = new Scanner(System.in);
    public void createRoomReservation(){
        int choice;
        String menu = "What do you want to do ?\n" +
                "1. Reserve room\n" +
                "2. List reservations\n" +
                "3. Delete reservation\n" +
                "4. List reserved rooms\n" +
                "5. Exit";
        System.out.println(menu);
        choice = scan.nextInt();
        switch (choice){
            case 1:
                doReservation(myHospital);
                createRoomReservation();
                break;
            case 2:
                displayReservations(listReservations);
                createRoomReservation();
                break;
            case 3:
                deleteReservation(listReservations);
                createRoomReservation();
                break;
            case 4:
                myHospital.displayReservedRooms();
                createRoomReservation();
                break;
            case 5:
                return;
            default:
                System.out.println("Choice is not available.");
        }

    }

    public static void doReservation(Hospital hospital){
        boolean isGoodFormat;
        String registrationNumber;
        String pracLastName;
        String socialSecurityNumber;
        String patLastName;
        String info;
        String nbDays;

        do {
            System.out.println("Practitioner registration number ?");
            registrationNumber = scan.next();
            isGoodFormat = Pattern.matches("^\\d+$", registrationNumber);
            if (!isGoodFormat){
                System.out.println("Wrong format of registration number (only digits)");
            }
        }
        while (!isGoodFormat);

        do {
            System.out.println("Practitioner last name ?");
            pracLastName = scan.next();
            isGoodFormat = Pattern.matches("^[a-zA-Z]+$", pracLastName);
            if (!isGoodFormat){
                System.out.println("Only letters for names");
            }
        }
        while (!isGoodFormat);

        do {
            System.out.println("Your social security number ?");
            socialSecurityNumber = scan.next();
            isGoodFormat = Pattern.matches("^\\d{13}+$", socialSecurityNumber);
            if (!isGoodFormat){
                System.out.println("Wrong format of social security number (13 digits)");
            }
        }
        while (!isGoodFormat);

        do{
            System.out.println("Your last name ?");
            patLastName = scan.next();
            isGoodFormat = Pattern.matches("^[a-zA-Z]+$", patLastName);
            if (!isGoodFormat){
                System.out.println("Only letters for names");
            }
        }
        while (!isGoodFormat);

        System.out.println("more information ?");
        info = scan.next();

        do {
            System.out.println("Number of days ?");
            nbDays = scan.next();
            isGoodFormat = Pattern.matches("^\\d+$", nbDays);
            if (!isGoodFormat){
                System.out.println("Wrong format of days (only digits)");
            }
        }
        while (!isGoodFormat);

        Room roomReserved = hospital.getAvailableRoom();

        RoomReservation resa = new RoomReservation(Integer.parseInt(registrationNumber), pracLastName, socialSecurityNumber, patLastName, info, Integer.parseInt(nbDays), roomReserved.getIdRoom());

        roomReserved.setReserved(true);
        System.out.println("Your room : " + roomReserved.getIdRoom());

        listReservations.add(resa);

        resa.generateInvoice();

    }

    public static void displayReservations(List<RoomReservation> list) {
        if (list.isEmpty()){
            System.out.println("No reservation");
        }
        else {
            for (RoomReservation resa : list) {
                resa.generateInvoice();
            }
        }
    }

    public static void deleteReservation(List<RoomReservation> list) {
        if (list.isEmpty()){
            System.out.println("No reservation");
        }
        else {
            System.out.println("Reservation to delete : ");
            Integer index = 0;
            for (RoomReservation resa:list){
                System.out.println("----   Index : " + index + "   ----");
                resa.generateInvoice();
            }
            Integer choice = scan.nextInt();

            RoomReservation resaChoosed = list.get(choice);

            // set isreserved on room to false
            Room searchRoom = new Room(resaChoosed.getIdRoom(), false);
            int indexRoom = Collections.binarySearch(myHospital.getListRooms(), searchRoom);
            searchRoom = myHospital.getListRooms().get(indexRoom);


            resaChoosed.generateInvoice();
            System.out.println("Confirm delete (y/n)");
            String confirm = scan.next();
            switch (confirm){
                case "y":
                    list.remove(resaChoosed);
                    searchRoom.setReserved(false);
                    break;
                case "n":
                    System.out.println("no delete");
                    deleteReservation(list);
                    break;
                default:
                    System.out.println("Not recognize");
                    deleteReservation(list);
            }
        }
    }
}
