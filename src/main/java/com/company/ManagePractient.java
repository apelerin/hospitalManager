package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagePractient {
    private List<Practitioner> PractitionerList = new ArrayList();

    public void CreatePractient(){
        Scanner sc = new Scanner(System.in);
        String PractientMenu = "What do you wanna do?\n1. Créate Practient\n2. List of Practitioner\n3. Quit";
        boolean isGoodFormat;
        int choice;
        String PractientName;
        String PractientFirstName;
        String PractientregistrationNumber;
        String Practientspeciality;
        String Practientrank;
        String PractienthourlyRate;
        boolean menu = false;
        while (!menu) {
            System.out.println(PractientMenu);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Name :");
                        PractientName = sc.nextLine();
                        isGoodFormat = Pattern.matches("^[a-zA-Z]+$",PractientName );
                        if (!isGoodFormat){
                            System.out.println("Only letters for names");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                        System.out.println("FirstName :");
                        PractientFirstName = sc.nextLine();
                        isGoodFormat = Pattern.matches("^[a-zA-Z]+$",PractientFirstName );
                        if (!isGoodFormat){
                            System.out.println("Only letters for Firstname");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("Registration Number :");
                    PractientregistrationNumber = sc.nextLine();
                    isGoodFormat = Pattern.matches("^\\d+$", PractientregistrationNumber);
                        if (!isGoodFormat){
                            System.out.println("Only number for Register Number");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("Speciality :");
                    Practientspeciality = sc.nextLine();
                        isGoodFormat = Pattern.matches("^[a-zA-Z]+$", Practientspeciality);
                        if (!isGoodFormat){
                            System.out.println("Only letters for Speciality");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("Rank :");
                    Practientrank = sc.nextLine();
                        isGoodFormat = Pattern.matches("^[a-zA-Z]+$", Practientrank);
                        if (!isGoodFormat){
                            System.out.println("Only letters for Rank");
                        }
                    }
                    while (!isGoodFormat);

                    do {
                    System.out.println("Hourly Rate :");
                    PractienthourlyRate = sc.nextLine();
                        isGoodFormat = Pattern.matches("^\\d+$", PractienthourlyRate);
                        if (!isGoodFormat){
                            System.out.println("Only Number for Hourly Rate");
                        }
                    }
                    while (!isGoodFormat);

                    Practitioner practient = new Practitioner(PractientName,PractientFirstName, Integer.parseInt(PractientregistrationNumber), Practientspeciality, Practientrank, Integer.parseInt(PractienthourlyRate ));
                    PractitionerList.add(practient);
                    break;
                case 2:
                    for(Practitioner Practient : PractitionerList){
                        System.out.println("Name:"+Practient.getLastName()+" FirstName:"+Practient.getFirstName()+
                                " RegistrationNumber:"+Practient.getRegistrationNumber()+" Speciality:"+Practient.getSpeciality()+
                                " Rank:"+Practient.getRank()+" HourlyRate:"+Practient.getHourlyRate());
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
