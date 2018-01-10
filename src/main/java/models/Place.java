package models;


import java.util.ArrayList;

public class Place {
    private String name;
    private String weather;
    private String stayLength;
    private String grade;
    private static ArrayList<Place> instances = new ArrayList<>();
    private int id;

    public Place(String name, String weather, String stayLength, String grade) {
        this.name = name;
        this.weather = weather;
        this.stayLength = stayLength;
        this.grade = grade;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public String getWeather() {
        return weather;
    }

    public String getStayLength() {
        return stayLength;
    }

    public String getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Place> getAll() {
        return instances;
    }

    public static void clearAllPlaces() {
        instances.clear();
    }

    public static Place findById(int id){
        return instances.get(id-1);
    }
}
