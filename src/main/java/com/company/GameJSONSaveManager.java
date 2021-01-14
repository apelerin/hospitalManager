package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GameJSONSaveManager {
    private String nickname;
    private int[] savedLocation;

    public GameJSONSaveManager(String nickname) {
        this.setNickname(nickname);
        this.readSave();
    }

    private void readSave() {

        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/resources/saveGame.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray listSaves = (JSONArray) obj;

            listSaves.forEach( save -> {
                if(isPlayer((JSONObject) save)) {
                    setTheSave((JSONObject) save);
                    return;
                }
            });
            // TODO create new save there

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    // Method to save

    private boolean isPlayer(JSONObject save) {
        String nickToTest = (String) save.get("nickname");
        return nickToTest.equalsIgnoreCase(this.getNickname());
    }

    private void setTheSave(JSONObject save) {
        this.savedLocation = GameJSONParser.jsonArrayToIntArray((JSONArray) save.get("savedLocations"));
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
