package com.example.motivator;

import java.util.ArrayList;
import java.util.List;

public class RunData {
    private List<Run> runs;
    private static final RunData ourInstance = new RunData();

    public static RunData getInstance() {
        return ourInstance;
    }

    private RunData() {
        runs = new ArrayList<Run>();
        runs.add(new Run(26, 2, 2020, 2050, 10));
        runs.add(new Run(27, 2, 2020, 2080, 11));
        runs.add(new Run(28, 2, 2020, 2030, 9));
    }

    public List<Run> getRuns() {
        return runs;
    }

    public Run getRun(int index) {
        return runs.get(index);
    }
}
