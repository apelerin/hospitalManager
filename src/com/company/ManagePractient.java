package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagePractient {
    private List<Practitioner> PractitionerList = new ArrayList();

    public void CreatePractient(){
        Scanner sc = new Scanner(System.in);
        String PractientMenu = "What do you wanna do?\n1. Créate Practient\n2. List of Practitioner\n3. Quit";
        int choice;
        String PractientName;
        String PractientFirstName;
        int PractientregistrationNumber;
        String Practientspeciality;
        String Practientrank;
        int PractienthourlyRate;
        boolean menu = false;
        while (!menu) {
            System.out.println(PractientMenu);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Name :");
                    PractientName = sc.nextLine();

                    System.out.println("FirstName :");
                    PractientFirstName = sc.nextLine();

                    System.out.println("Registration Number :");
                    PractientregistrationNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Speciality :");
                    Practientspeciality = sc.nextLine();

                    System.out.println("Rank :");
                    Practientrank = sc.nextLine();


                    System.out.println("Hourly Rate :");
                    PractienthourlyRate = sc.nextInt();
                    sc.nextLine();

                    Practitioner practient = new Practitioner(PractientName,PractientFirstName, PractientregistrationNumber, Practientspeciality, Practientrank, PractienthourlyRate );
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
