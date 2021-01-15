package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MangeClient {
    private List<Patient> PatientList = new ArrayList();

    public void CreateClient(){
        Scanner sc = new Scanner(System.in);
        String ClientMenu = "What do you wanna do?\n1. Créate clients\n2. List of client\n3. Quit";
        int choice;
        boolean isGoodFormat;
        String ClientName;
        String ClientFirstName;
        String ClientAdresse;
        String ClientNumeroTel;
        String ClientNumeroSecu;
        String ClientAdresseMail;
        boolean menu = false;
        while (!menu) {
            System.out.println(ClientMenu);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:

                    do {
                    System.out.println("Name :");
                    ClientName = sc.nextLine();
                    isGoodFormat = Pattern.matches("^[a-zA-Z]+$", ClientName);
                        if (!isGoodFormat){
                            System.out.println("Only letter for Name");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("FirstName :");
                    ClientFirstName = sc.nextLine();
                    isGoodFormat = Pattern.matches("^[a-zA-Z]+$", ClientFirstName);
                        if (!isGoodFormat){
                            System.out.println("Only letter for FirstName");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("Adresse :");
                    ClientAdresse = sc.nextLine();
                        isGoodFormat = Pattern.matches("^[a-zA-Z]+$", ClientAdresse);
                        if (!isGoodFormat){
                            System.out.println("Only letter for Adress");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("numeroDeTel :");
                    ClientNumeroTel = sc.nextLine();
                    isGoodFormat = Pattern.matches("^\\d+$", ClientNumeroTel);
                    if (!isGoodFormat){
                        System.out.println("Only Number for numberTel");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("Numero de secu :");
                    ClientNumeroSecu = sc.nextLine();
                    isGoodFormat = Pattern.matches("^\\d+$", ClientNumeroSecu);
                    if (!isGoodFormat){
                        System.out.println("Only Number for Numbersecu");
                        }
                    }
                    while (!isGoodFormat);

                    do{
                    System.out.println("Adresse Mail :");
                    ClientAdresseMail = sc.nextLine();
                    isGoodFormat = Pattern.matches("^[a-zA-Z]+$", ClientAdresseMail);
                    if (!isGoodFormat){
                        System.out.println("Only letter for adress Mail");
                        }
                    }
                    while (!isGoodFormat);

                    Patient patient = new Patient(ClientName,ClientFirstName, Integer.parseInt(ClientNumeroSecu), ClientAdresse, ClientNumeroTel, ClientAdresseMail );
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
