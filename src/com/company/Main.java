package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String whatYouGonnaDo = "What do you wanna do?\n1. Access to hospital manager\n2. Play Colossal Cava\n3. Exit.";
        System.out.println(whatYouGonnaDo);
        int choice = sc.nextInt();
        boolean chosen = false;
        while (!chosen) {
            switch (choice) {
                case 1:
                    //code to go to the hospital manager
                    break;
                case 2:
                    //code to go to the game
                    break;
                case 3:
                    chosen = true;
                    break;
                default:
                    System.out.println("Choice is not available.");
                    System.out.println(whatYouGonnaDo);
                    choice = sc.nextInt();
                    break;
            }
        }
    }
}
