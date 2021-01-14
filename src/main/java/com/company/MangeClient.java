package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MangeClient {
    private List<Patient> PatientList = new ArrayList();

    public void CreateClient(){
        Scanner sc = new Scanner(System.in);
        String ClientMenu = "What do you wanna do?\n1. Créate clients\n2. List of client\n3. Quit";
        int choice;
        String ClientName;
        String ClientFirstName;
        String ClientAdresse;
        String ClientNumeroTel;
        int ClientNumeroSecu;
        String ClientAdresseMail;
        boolean menu = false;
        while (!menu) {
            System.out.println(ClientMenu);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Name :");
                    ClientName = sc.nextLine();

                    System.out.println("FirstName :");
                    ClientFirstName = sc.nextLine();

                    System.out.println("Adresse :");
                    ClientAdresse = sc.nextLine();

                    System.out.println("numeroDeTel :");
                    ClientNumeroTel = sc.nextLine();

                    System.out.println("Numero de secu :");
                    ClientNumeroSecu = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Adresse Mail :");
                    ClientAdresseMail = sc.nextLine();

                    Patient patient = new Patient(ClientName,ClientFirstName, ClientNumeroSecu, ClientAdresse, ClientNumeroTel, ClientAdresseMail );
                    PatientList.add(patient);
                    break;
                case 2:
                    for(Patient patients : PatientList){
                        System.out.println("Name:"+patients.getLastName()+" FirstName:"+patients.getFirstName()+
                                " NumeroSecu:"+patients.getSocialSecurityNumber()+" Adresse:"+patients.getAddress()+
                                " Phone:"+patients.getPhone()+" Mail:"+patients.getMail());
                    }
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
