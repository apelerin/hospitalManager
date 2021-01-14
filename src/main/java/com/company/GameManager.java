package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;


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
            boolean isFound;
            if (choice.equals("Q")) {
                gameIsOn = false;
            } else {
                isFound = false;
                for(Map.Entry<Integer, Location> entry : locations.entrySet()) {
                    Integer key = entry.getKey();
                    Location value = entry.getValue();

                    if(choice.equalsIgnoreCase(value.getName()) && Arrays.stream(this.getCurrentLocation().getCanGoTo()).anyMatch(i -> i == key)) {
                        this.setCurrentLocation(value);
                        isFound = true;
                        break;
                    }
                }
                if(!isFound) {
                    System.out.println("Either the place you want to go doesn't exist or is not accessible from here.");
                }
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
