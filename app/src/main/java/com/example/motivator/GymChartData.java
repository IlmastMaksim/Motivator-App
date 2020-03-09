package com.example.motivator;

import com.anychart.chart.common.dataentry.ValueDataEntry;

import java.util.ArrayList;
import java.util.List;

public class GymChartData {
    private List<CustomDataEntry> gymActivities;
    private static final GymChartData ourInstance = new GymChartData();

    public static GymChartData getInstance() {
        return ourInstance;
    }

    private GymChartData() {
        // test data
        gymActivities = new ArrayList<>();
        gymActivities.add(new CustomDataEntry("12.03.2020", "squat", 9, 12, 40));
        gymActivities.add(new CustomDataEntry("13.03.2020", "bench", 11, 10 ,30));
        gymActivities.add(new CustomDataEntry("14.03.2020", "deadlift", 8, 11, 222));
        gymActivities.add(new CustomDataEntry("15.03.2020", "squat", 32, 12, 40));
        gymActivities.add(new CustomDataEntry("16.03.2020", "bench", 12, 13 ,340));
        gymActivities.add(new CustomDataEntry("17.03.2020", "deadlift", 5, 11, 222));
        gymActivities.add(new CustomDataEntry("18.03.2020", "squat", 10, 12, 40));
        gymActivities.add(new CustomDataEntry("19.03.2020", "bench", 13, 10 ,304));
        gymActivities.add(new CustomDataEntry("20.03.2020", "deadlift", 4, 13, 222));
    }

    public List<CustomDataEntry> getRuns() {
        return gymActivities;
    }

    public CustomDataEntry getRun(int index) {
        return gymActivities.get(index);
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String date, String exerciseName, Number reps, Number sets, Number weight) {
            super(date, weight);
            setValue("exerciseName", exerciseName);
            setValue("reps", reps);
            setValue("sets", sets);
        }
    }
}
