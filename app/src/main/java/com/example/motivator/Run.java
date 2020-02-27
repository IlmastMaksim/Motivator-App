package com.example.motivator;

public class Run {
    private int day;
    private int month;
    private int year;
    private int distance; // distance is stored in meters
    private float time;  // time is stored in minutes

    public Run(int day, int month, int year, int distance, float time) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.distance = distance;
        this.time = time;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() { return this.month; }

    public int getYear() {
        return this.year;
    }

    public int getDistance() {
        return this.distance;
    }

    public float getTime() {
        return this.time;
    }
}
