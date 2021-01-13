package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageRdv {
    private List<Patient> PatientList = new ArrayList();

    public void CreateRdv(){
        Scanner sc = new Scanner(System.in);
        String ClientMenu = "What do you wanna do?\n1. Manage Rdv\n2. List of RDV\n3. Quit";
        int choice;
        String RDVMatriculePractien;
        int RDVNumSecu;
        int RDVHoursAndDate;
        String RDVLieu;
        boolean menu = false;
        while (!menu) {
            System.out.println(ClientMenu);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Matricule Praticien :");
                    RDVMatriculePractien = sc.nextLine();

                    System.out.println("Numero Secu Client :");
                    RDVNumSecu = sc.nextInt();
                    sc.nextLine();

                    System.out.println("hours And Date :");
                    RDVHoursAndDate = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Lieu :");
                    RDVLieu = sc.nextLine();


//                    Patient patient = new Patient(ClientName,ClientFirstName, ClientNumeroSecu, ClientAdresse, ClientNumeroTel, ClientAdresseMail );
//                    PatientList.add(patient);
                    break;
                case 2:
                    for(Patient patients : PatientList){
                        System.out.println("Matricule Praticien :"+patients.getLastName()+" Numero Secu Client :"+patients.getFirstName()+
                                " hours And Date :"+patients.getSocialSecurityNumber()+" Lieu :"+patients.getAddress());
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
