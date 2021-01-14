package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //myHospital.displayRooms();
        Scanner sc = new Scanner(System.in);
        String whatYouGonnaDo = "What do you wanna do?\n1. Access to hospital manager\n2. Play Colossal Cava\n3. Exit.";
        int choice;
        boolean chosen = false;
        while (!chosen) {
            System.out.println(whatYouGonnaDo);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //code to go to the hospital manager
                    break;
                case 2:
                    new ManageRoomReservation().createRoomReservation();
                    break;
                case 3:
                    chosen = true;
                    System.out.println("GoodBye.");
                    break;
                default:
                    System.out.println("Choice is not available.");
                    break;
            }
        }
    }

}
