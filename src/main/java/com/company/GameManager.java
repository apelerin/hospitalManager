package com.company;

import java.util.*;
import java.util.regex.Pattern;


public class GameManager {
    private HashMap<Integer, Location> locations;
    private Location currentLocation;
    private ArrayList<Integer> previousMoves;
    private String nickname;
    private GameJSONSaveManager save;

    public GameManager() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your nickname ?");
        this.setNickname(sc.nextLine());

        this.setSave(new GameJSONSaveManager(this.getNickname()));

        System.out.printf("Welcome %s !\n", this.getNickname());

        this.locations = GameJSONParser.loadLocations();

        this.setCurrentLocation(locations.get(0));
        System.out.println("You woke up, you don't know where you are, you might want to get around, or stay there, but why would you do that ?");
        System.out.println("You can save your \"progression\" by typing 'S', see where you have been with 'J' or leave the game with 'Q'.");
        boolean gameIsOn = true;
        String choice;
        while(gameIsOn) {
            System.out.println(this.getCurrentLocation().getDescription());
            System.out.println("Where do you want to go ?");
            choice = sc.nextLine();
            boolean isFound;
            if (choice.equalsIgnoreCase("Q")) {
                gameIsOn = false;
            } else if (choice.equalsIgnoreCase("S")) {
                this.save.saveToJson();
            } else if (choice.equalsIgnoreCase("J")) {
                this.displayVisitedLocations();
            }else {
                isFound = false;
                for(Map.Entry<Integer, Location> entry : locations.entrySet()) {
                    Integer key = entry.getKey();
                    Location value = entry.getValue();

                    if (choice.equalsIgnoreCase(this.getCurrentLocation().getName())) {
                        System.out.println("You are already there you pinecone.");
                        isFound = true;
                        break;
                    }
                    if(choice.equalsIgnoreCase(value.getName()) && Arrays.stream(this.getCurrentLocation().getCanGoTo()).anyMatch(i -> i == key)) {
                        this.setCurrentLocation(value);
                        this.save.addToSave(value.getIndex());
                        isFound = true;
                        break;
                    }
                }
                if(!isFound) {
                    System.out.println("Either the place you want to go doesn't exist or is not accessible from here.");
                }
            }
        }
    }

    private void displayVisitedLocations() {
        System.out.println("You have been to these places: ");
        for (Integer index: this.save.savedLocation) {
            System.out.println(this.locations.get(index).getName());
        }
    }

    private void setSave(GameJSONSaveManager save) {
        this.save = save;
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String getNickname() {
        return this.nickname;
    }

    private void setCurrentLocation(Location loc) {
        this.currentLocation = loc;
    }

    private Location getCurrentLocation() {
        return this.currentLocation;
    }

    public GameJSONSaveManager getSave() {
        return save;
    }
}
