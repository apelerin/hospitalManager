package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManageRdv {
    private List<HospitalRdv> RdvList = new ArrayList();

    public void CreateRdv(){
        Scanner sc = new Scanner(System.in);
        String ClientMenu = "What do you wanna do?\n1. Manage Rdv\n2. List of RDV\n3. Quit";
        int choice;
        boolean isGoodFormat;
        String RDVMatriculePractien;
        String RDVNumSecu;
        int RDVHoursAndDate;
        String RDVLieu;
        boolean menu = false;
        while (!menu) {
            System.out.println(ClientMenu);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do{
                    System.out.println("Matricule Praticien :");
                    RDVMatriculePractien = sc.nextLine();
                        isGoodFormat = Pattern.matches("^\\d+$", RDVMatriculePractien);
                        if (!isGoodFormat){
                            System.out.println("Only number for Matricule praticien");
                        }
                    }
                    while (!isGoodFormat);


                    do{
                    System.out.println("Numero Secu Client :");
                    RDVNumSecu = sc.nextLine();
                        isGoodFormat = Pattern.matches("^\\d+$", RDVNumSecu);
                        if (!isGoodFormat){
                            System.out.println("Only Number for Secu");
                        }
                    }
                    while (!isGoodFormat);


                    System.out.println("hours And Date :");
                    RDVHoursAndDate = sc.nextInt();
                    sc.nextLine();
                    System.out.println(RDVHoursAndDate);
                    while(RDVHoursAndDate <= 9  || RDVHoursAndDate >= 15){
                        System.out.println("Les heures de Rdv se deroule entre 9h et 15h\n");
                        System.out.println("hours And Date :");
                        RDVHoursAndDate = sc.nextInt();
                        sc.nextLine();
                    }

                    do{
                    System.out.println("Lieu :");
                    RDVLieu = sc.nextLine();
                    isGoodFormat = Pattern.matches("^[a-zA-Z]+$", RDVLieu);
                        if (!isGoodFormat){
                            System.out.println("Only letter for lieu");
                        }
                    }
                    while (!isGoodFormat);


                    HospitalRdv RdvClient = new HospitalRdv(Integer.parseInt(RDVMatriculePractien), Integer.parseInt(RDVNumSecu), RDVHoursAndDate, RDVLieu);
                    RdvList.add(RdvClient);
                    break;
                case 2:
                    for(HospitalRdv client : RdvList){
                        System.out.println("Matricule Praticien :"+client.getMatriculePractien()+" Numero Secu Client :"+client.getNumSecu()+
                                " hours And Date :"+client.getHoursAndDate()+" Lieu :"+client.getLieu());
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
