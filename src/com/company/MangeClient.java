package com.company;

import java.util.Scanner;

public class MangeClient {

    public void CreateClient(){
        Scanner sc = new Scanner(System.in);
        String ClientMenu = "What do you wanna do?\n1. Créate clients\n2. List of client\n3. Quit";
        int choice;
        String ClientName;
        String ClientFirstName;
        String ClientAdresse;
        int ClientNumeroTel;
        String ClientAdresseMail;
        boolean menu = false;
        while (!menu) {
            System.out.println(ClientMenu);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Name :");
                    ClientName = sc.nextLine();
                    System.out.println("FirstName :");
                    ClientFirstName = sc.nextLine();
                    System.out.println("Adresse :");
                    ClientAdresse = sc.nextLine();
                    System.out.println("numeroDeTel :");
                    ClientNumeroTel = sc.nextInt();
                    System.out.println("Adresse Mail :");
                    ClientAdresseMail = sc.nextLine();
                    break;
                case 2:

                    break;
                case 3:
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
