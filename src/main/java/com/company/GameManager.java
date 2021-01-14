package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GameManager {
    private HashMap<Integer, Location> locations;
    private Location currentLocation;

    public GameManager() {
        this.locations = GameJSONParser.loadLocations();
        this.setCurrentLocation(locations.get(0));
        System.out.println("You woke up, you don't know where you are, you might want to get around, or stay there, but why would you do that ?");
        boolean gameIsOn = true;
        Scanner sc = new Scanner(System.in);
        String choice;
        while(gameIsOn) {
            System.out.println(this.getCurrentLocation().getDescription());
            System.out.println("Where do you want to go ?");
            choice = sc.nextLine();
            for(Map.Entry<Integer, Location> entry : locations.entrySet()) {
                Integer key = entry.getKey();
                Location value = entry.getValue();

                if(choice.equals(value.getName())) {
                    this.setCurrentLocation(value);
                }
            }
            if (choice.equals("Q")) {
                gameIsOn = false;
            }
        }
        sc.close();
    }

    private void setCurrentLocation(Location loc) {
        this.currentLocation = loc;
    }

    private Location getCurrentLocation() {
        return this.currentLocation;
    }
}
