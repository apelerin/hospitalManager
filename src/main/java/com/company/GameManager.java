package com.company;

import java.util.HashMap;


public class GameManager {
    private HashMap<Integer, Location> locations;
    private Location currentLocation;

    public GameManager() {
        this.locations = JSONParser.loadLocations();
        this.setCurrentLocation(locations.get(0));
        System.out.println(this.currentLocation.getName());
    }

    private void setCurrentLocation(Location loc) {
        this.currentLocation = loc;
    }

    private Location getCurrentLocation() {
        return this.currentLocation;
    }


}
