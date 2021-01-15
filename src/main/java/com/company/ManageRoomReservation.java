package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ManageRoomReservation {

    public static List<RoomReservation> listReservations = new ArrayList<>();
    public static Hospital myHospital = new Hospital("quimper", 8, 20);
    public static JSONParser jsonParser = new JSONParser();

    private static Scanner scan = new Scanner(System.in);
    public void createRoomReservation() throws IOException, ParseException {
        uploadReservations();

        int choice;
        String menu = "What do you want to do ?\n" +
                "1. Reserve room\n" +
                "2. List reservations\n" +
                "3. Delete reservation\n" +
                "4. List reserved rooms\n" +
                "5. Exit";
        System.out.println(menu);
        choice = scan.nextInt();
        switch (choice){
            case 1:
                doReservation(myHospital);
                createRoomReservation();
                break;
            case 2:
                displayReservations(listReservations);
                createRoomReservation();
                break;
            case 3:
                deleteReservation(listReservations);
                createRoomReservation();
                break;
            case 4:
                myHospital.displayReservedRooms();
                createRoomReservation();
                break;
            case 5:
                return;
            default:
                System.out.println("Choice is not available.");
        }

    }

    public static void doReservation(Hospital hospital) throws IOException {
        boolean isGoodFormat;
        String registrationNumber;
        String pracLastName;
        String socialSecurityNumber;
        String patLastName;
        String info;
        String nbDays;

        do {
            System.out.println("Practitioner registration number ?");
            registrationNumber = scan.next();
            isGoodFormat = Pattern.matches("^\\d+$", registrationNumber);
            if (!isGoodFormat){
                System.out.println("Wrong format of registration number (only digits)");
            }
        }
        while (!isGoodFormat);

        do {
            System.out.println("Practitioner last name ?");
            pracLastName = scan.next();
            isGoodFormat = Pattern.matches("^[a-zA-Z]+$", pracLastName);
            if (!isGoodFormat){
                System.out.println("Only letters for names");
            }
        }
        while (!isGoodFormat);

        do {
            System.out.println("Your social security number ?");
            socialSecurityNumber = scan.next();
            isGoodFormat = Pattern.matches("^\\d{13}+$", socialSecurityNumber);
            if (!isGoodFormat){
                System.out.println("Wrong format of social security number (13 digits)");
            }
        }
        while (!isGoodFormat);

        do{
            System.out.println("Your last name ?");
            patLastName = scan.next();
            isGoodFormat = Pattern.matches("^[a-zA-Z]+$", patLastName);
            if (!isGoodFormat){
                System.out.println("Only letters for names");
            }
        }
        while (!isGoodFormat);

        System.out.println("more information ?");
        info = scan.next();

        do {
            System.out.println("Number of days ?");
            nbDays = scan.next();
            isGoodFormat = Pattern.matches("^\\d+$", nbDays);
            if (!isGoodFormat){
                System.out.println("Wrong format of days (only digits)");
            }
        }
        while (!isGoodFormat);

        Room roomReserved = hospital.getAvailableRoom();

        RoomReservation resa = new RoomReservation(Integer.parseInt(registrationNumber), pracLastName, socialSecurityNumber, patLastName, info, Integer.parseInt(nbDays), roomReserved.getIdRoom());

        roomReserved.setReserved(true);
        System.out.println("Your room : " + roomReserved.getIdRoom());

        listReservations.add(resa);

        resa.generateInvoice();

        writeInJson();

    }

    public static void displayReservations(List<RoomReservation> list) {
        if (list.isEmpty()){
            System.out.println("No reservation");
        }
        else {
            for (RoomReservation resa : list) {
                resa.generateInvoice();
            }
        }
    }

    public static void deleteReservation(List<RoomReservation> list) throws IOException, ParseException {
        if (list.isEmpty()){
            System.out.println("No reservation");
        }
        else {
            System.out.println("Reservation to delete : ");
            Integer index = 0;
            for (RoomReservation resa:list){
                System.out.println("----   Index : " + index + "   ----");
                resa.generateInvoice();
                index++;
            }
            Integer choice = scan.nextInt();

            RoomReservation resaChoosed = list.get(choice);

            // set isreserved on room to false
            Room searchRoom = new Room(resaChoosed.getIdRoom(), false);
            int indexRoom = Collections.binarySearch(myHospital.getListRooms(), searchRoom);
            searchRoom = myHospital.getListRooms().get(indexRoom);


            resaChoosed.generateInvoice();
            System.out.println("Confirm delete (y/n)");
            String confirm = scan.next();
            switch (confirm){
                case "y":
                    list.remove(resaChoosed);
                    searchRoom.setReserved(false);
                    listReservations.remove(resaChoosed);
                    writeInJson();
                    break;
                case "n":
                    System.out.println("no delete");
                    deleteReservation(list);
                    break;
                default:
                    System.out.println("Not recognize");
                    deleteReservation(list);
            }
        }
    }
    public static void writeInJson() throws IOException {

        JSONArray resaList = new JSONArray();
        for (RoomReservation resa:listReservations)
        {
            JSONObject resaJson = new JSONObject();
            resaJson.put("registration_number_prac", resa.getRegistrationNumberPrac().toString());
            resaJson.put("last_name_prac", resa.getLastNamePrac());
            resaJson.put("social_security_number", resa.getSocialSecurityNumberPat());
            resaJson.put("last_name_pat", resa.getLastNamePat());
            resaJson.put("info_pat", resa.getInfoPat());
            resaJson.put("nb_of_days", resa.getNbOfDays().toString());
            resaJson.put("price_per_night", resa.getPricePerNight());
            resaJson.put("idRoom", resa.getIdRoom());

            resaList.add(resaJson);
        }

        FileWriter file = new FileWriter("dataReservations.json");
        file.write(resaList.toString());
        file.flush();
    }
    public static void uploadReservations() throws IOException, ParseException {
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("dataReservations.json"));

        for (Object o:jsonArray){
            JSONObject obj = (JSONObject) o;
            String regis = (String) obj.get("registration_number_prac");
            String lastNamePrac = (String) obj.get("last_name_prac");
            String security = (String)  obj.get("social_security_number");
            String lastNamePat = (String) obj.get("last_name_pat");
            String info =(String)  obj.get("info_pat");
            String days = (String) obj.get("nb_of_days");
            String id = (String)  obj.get("idRoom");
            RoomReservation resa = new RoomReservation(Integer.parseInt(regis), lastNamePrac, security, lastNamePat, info, Integer.parseInt(days), id);
            listReservations.add(resa);
        }
    }
}
