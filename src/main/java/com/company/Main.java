package com.company;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        //myHospital.displayRooms();
        HospitalManager hospital;
        String whatYouGonnaDo = "What do you wanna do?\n1. Access to hospital manager\n2. Play Colossal Cava\n3. Exit.";
        int choice;
        Scanner sc = new Scanner(System.in);
        boolean chosen = false;
        while (!chosen) {
            System.out.println(whatYouGonnaDo);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new HospitalManager().Hospital();
                    break;
                case 2:
                    GameManager game = new GameManager();
                    break;
                case 3:
                    chosen = true;
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Choice is not available.");
                    break;
            }
        }
        sc.close();
    }

}
