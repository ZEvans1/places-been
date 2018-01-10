package models;


import java.util.ArrayList;

public class Place {
    private String name;
    private static ArrayList<Place> instances = new ArrayList<>();
    private int id;

    public Place(String name) {
        this.name = name;
        instances.add(this);
        this.id = instances.size();

    }

    public String getName() {
        return name;
    }

    public static ArrayList<Place> getAll() {
        return instances;
    }
}
