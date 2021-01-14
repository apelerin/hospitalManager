package com.company;

import java.util.Scanner;

public class HospitalManager {

    public void Hospital() {
        Scanner sc = new Scanner(System.in);
        String HopitalMenu = "What do you wanna do?\n1. Manege Client\n2. Manege praticiens\n3. Manege RDV.\n4.Reservation Hostel\n5.Quit";
        int choice;
        boolean menu = false;
        while (!menu) {
            System.out.println(HopitalMenu);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new MangeClient().CreateClient();
                    break;
                case 2:
                    new ManagePractient().CreatePractient();
                    break;
                case 3:
                    new ManageRdv().CreateRdv();
                case 4:
                    new ManageRoomReservation().createRoomReservation();
                case 5:
                    menu = true;
                    System.out.println("GoodBye.");
                    break;
                default:
                    System.out.println("Choice is not available.");
                    break;
            }
        }
    }
}
