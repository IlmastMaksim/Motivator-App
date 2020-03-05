package com.example.motivator;

public class Run {
    private String date;
    private int distance; // distance is stored in meters
    private float time;  // time is stored in minutes

    public Run(String date, int distance, float time) {
        this.date = date;
        this.distance = distance;
        this.time = time;
    }

    public String getDate() { return this.date; }

    public int getDistance() {
        return this.distance;
    }

    public float getTime() {
        return this.time;
    }
}
