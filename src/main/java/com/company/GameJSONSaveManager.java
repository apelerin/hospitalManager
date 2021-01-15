package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GameJSONSaveManager {
    private String nickname;
    public ArrayList<Integer> savedLocation;
    private JSONObject player;
    private JSONArray players;
    private boolean playerAlreadyExist = false;

    public GameJSONSaveManager(String nickname) {
        this.setNickname(nickname);
        this.readSave();
    }

    private boolean readSave() {

        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/resources/saveGame.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray listSaves = (JSONArray) obj;
            this.players = listSaves;
            listSaves.forEach( save -> {
                if(isPlayer((JSONObject) save)) {
                    setTheSave((JSONObject) save);
                    this.playerAlreadyExist = true;
                }
            });
            if (!this.playerAlreadyExist) {
                this.savedLocation = new ArrayList<>();
                this.savedLocation.add(0);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to save

    private boolean isPlayer(JSONObject save) {
        String nickToTest = (String) save.get("nickname");
        if (nickToTest != null) {
            return nickToTest.equalsIgnoreCase(this.getNickname());
        }
        return false;
    }

    private void setTheSave(JSONObject save) {
        this.player = save;
        this.savedLocation = jsonArrayToIntArrayList((JSONArray) save.get("savedLocations"));
    }

    private ArrayList<Integer> jsonArrayToIntArrayList(JSONArray save) {
        ArrayList<Integer> savedLoc = new ArrayList<>();
        String stringJson = save.toJSONString();
        String[] items = stringJson.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        for (String item : items) {
            try {
                savedLoc.add(Integer.parseInt(item));
            } catch (NumberFormatException ignored) {
            }

        }
        return savedLoc;
    }

    public void saveToJson() {
        JSONArray list= new JSONArray();
        JSONObject currentSave = new JSONObject();
        currentSave.put("nickname", this.getNickname());
        currentSave.put("savedLocations", this.savedLocation);
        this.players.forEach( save -> {
            if(((String)((JSONObject) save).get("nickname")).equalsIgnoreCase(this.getNickname())) {
                list.add(currentSave);
            } else {
                list.add(save);
            }
        });
        if (!this.playerAlreadyExist) {
            list.add(currentSave);
        }
        try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/resources/saveGame.json")) {
            file.write(list.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToSave(int index) {
        this.savedLocation.add(index);
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
