package com.company;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class HospitalManager {

    public void Hospital() throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        String HopitalMenu = "What do you wanna do?\n1. Manage Client\n2. Manage practitioners\n3. Manage RDV.\n4. Manage Room Reservation\n5.Quit";
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
