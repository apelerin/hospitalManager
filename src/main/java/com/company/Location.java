package com.company;

public class Location {
    private final int index;
    private final String name;
    private final String description;
    private final int[] canGoTo;

    public Location(String name, String description, int[] canGoTo, int index) {
        this.name = name;
        this.description = description;
        this.canGoTo = canGoTo;
        this.index = index;
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

    public int getIndex() {
        return index;
    }
}
