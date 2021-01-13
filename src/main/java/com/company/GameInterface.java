package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameInterface {
    private ArrayList<Location> locations = new ArrayList<>();

    public GameInterface() {
        loadLocations();
        for(Location location : locations) {
            System.out.println(location.getName());
            System.out.println(Arrays.toString(location.getCanGoTo()));
        }
    }

    private void loadLocations() {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/resources/location.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray locationList = (JSONArray) obj;
            locationList.forEach( loc -> parseLocationObject((JSONObject) loc));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    private void parseLocationObject(JSONObject location) {
        JSONObject locationObject = (JSONObject) location.get("location");
        String name = (String) locationObject.get("name");
        String description = (String) locationObject.get("description");
        int[] canGoTo = jsonArrayToIntArray((JSONArray) locationObject.get("canGoTo"));
        Location loc = new Location(name, description, canGoTo);
        this.locations.add(loc);
    }

    private int[] jsonArrayToIntArray(JSONArray json) {
        int[] results = new int[json.size()];
        String stringJson = json.toJSONString();
        String[] items = stringJson.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                //NOTE: write something here if you need to recover from formatting errors
            };
        }
        return results;
    }

    private class Location {
        private final String name;
        private final String description;
        private final int[] canGoTo;

        public Location(String name, String description, int[] canGoTo) {
            this.name = name;
            this.description = description;
            this.canGoTo = canGoTo;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int[] getCanGoTo() {
            return canGoTo;
        }
    }
}
