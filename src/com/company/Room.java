package com.company;

public class Room implements Comparable<Room>{
    String idRoom;
    boolean isReserved;

    public Room(String idRoom, boolean isReserved) {
        this.idRoom = idRoom;
        this.isReserved = isReserved;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public int compareTo(Room o) {
        return this.idRoom.compareTo(o.getIdRoom());
    }
}
