package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Hospital {
    String name;
    int nbFloors;
    int nbRoomsPerFloor;
    List<Room> listRooms;

    public Hospital(String name, int nbFloors, int nbRoomsPerFloor) {
        this.name = name;
        this.nbFloors = nbFloors;
        this.nbRoomsPerFloor = nbRoomsPerFloor;
        this.listRooms = createRooms();
    }

    public String getName() {
        return name;
    }

    public int getNbFloors() {
        return nbFloors;
    }

    public int getNbRoomsPerFloor() {
        return nbRoomsPerFloor;
    }

    public List<Room> getListRooms() {
        return listRooms;
    }

    public List<Room> createRooms(){

        List<Room> listToReturn = new ArrayList<>();
        for (int i = 1; i <= this.nbFloors; i++){
            for (int j = 1; j <= this.nbRoomsPerFloor; j++){
                String idRoom = ""+i+String.format("%02d", j);
                listToReturn.add(new Room(idRoom, false));

            }
        }
        return listToReturn;
    }

    public void displayRooms(){
        for (Room room:listRooms){
            System.out.println("id room : " + room.getIdRoom() + "// is reserved : "+ room.isReserved );
        }
    }

    public Room getAvailableRoom(){
        List<Room> availableRooms = new ArrayList<>();
        for (Room room:listRooms){
            if (!room.isReserved()){
                availableRooms.add(room);
            }
        }
        Random rand = new Random();
        System.out.println("Number of unreserved rooms : " + availableRooms.size());
        int randomIndex = rand.nextInt(availableRooms.size());
        Room roomReserved = availableRooms.get(randomIndex);
        roomReserved.setReserved(true);

        return roomReserved;

    }

    public void displayReservedRooms() {
        Integer i = 0;
        System.out.println("Reserved rooms :");
        for (Room room : this.getListRooms()) {
            if (room.isReserved()) {
                System.out.println("Room : " + room.getIdRoom());
                i++;
            }
        }
        if (i.equals(0)){
            System.out.println("NO ROOM RESERVED YET");
        }
    }
}
