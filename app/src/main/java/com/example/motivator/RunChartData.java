package com.example.motivator;

import com.anychart.chart.common.dataentry.ValueDataEntry;

import java.util.ArrayList;
import java.util.List;

public class RunChartData {
    private List<CustomDataEntry> runs;
    private static final RunChartData ourInstance = new RunChartData();

    public static RunChartData getInstance() {
        return ourInstance;
    }

    private RunChartData() {
        // test data
        runs = new ArrayList<>();
        runs.add(new CustomDataEntry("25.02.2020", 2030, 9));
        runs.add(new CustomDataEntry("26.02.2020", 2080, 11));
        runs.add(new CustomDataEntry("28.02.2020", 2050, 8));
    }

    public List<CustomDataEntry> getRuns() {
        return runs;
    }

    public CustomDataEntry getRun(int index) {
        return runs.get(index);
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String date, Number distance, Number time) {
            super(date, distance);
            setValue("time", time);
        }
    }
}
