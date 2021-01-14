package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("Practitioner registration number ?");
        Integer registrationNumber = scan.nextInt();
        System.out.println("Practitioner last name ?");
        String pracLastName = scan.next();
        System.out.println("Your social security number ?");
        Integer socialSecurityNumber = scan.nextInt();
        System.out.println("Your last name ?");
        String patLastName = scan.next();
        System.out.println("more information ?");
        String info = scan.next();
        System.out.println("Number of days ?");
        Integer nbDays = scan.nextInt();

        Room roomReserved = hospital.getAvailableRoom();

        RoomReservation resa = new RoomReservation(registrationNumber, pracLastName, socialSecurityNumber, patLastName, info, nbDays, roomReserved.getIdRoom());

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
