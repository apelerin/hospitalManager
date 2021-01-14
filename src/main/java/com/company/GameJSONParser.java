package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameJSONParser {

    static HashMap<Integer, Location> loadLocations() {

        HashMap<Integer, Location> locations = new HashMap<>();

        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/resources/location.json"))
        {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            ArrayList<Location> tmpListLoc = new ArrayList<>();
            JSONArray locationList = (JSONArray) obj;
            locationList.forEach( loc -> tmpListLoc.add(parseLocationObject((JSONObject) loc)));
            tmpListLoc.forEach(loc -> locations.put(loc.getIndex(), loc));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return locations;
    }

    private static Location parseLocationObject(JSONObject location) {
        JSONObject locationObject = (JSONObject) location.get("location");
        String name = (String) locationObject.get("name");
        String description = (String) locationObject.get("description");
        long index = (Long) locationObject.get("index");
        int[] canGoTo = jsonArrayToIntArray((JSONArray) locationObject.get("canGoTo"));
        return new Location(name, description, canGoTo, (int)index);
    }

    public static int[] jsonArrayToIntArray(JSONArray json) {
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
}
