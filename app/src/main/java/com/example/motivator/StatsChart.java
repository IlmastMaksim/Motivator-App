package com.example.motivator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import java.util.HashSet;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.List;

public class StatsChart extends AppCompatActivity {
    List<CustomDataEntry> outdoorRuns;
    List<CustomDataEntry> indoorRuns;
    java.util.Set<String> _setFromPrefs;
    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_chart);
        outdoorRuns= new ArrayList<>();
        indoorRuns= new ArrayList<>();
        sharedPreferences = getSharedPreferences("RUNNING_DATA", Activity.MODE_PRIVATE);
        java.util.Set<String> someSets = this.sharedPreferences.getStringSet("RUNNING_DATA", new HashSet<String>() );
        _setFromPrefs = new HashSet<>(someSets);
        for (String temp : _setFromPrefs) { // 28.02.2002 outdoor 200 232 /
            Log.d("STRING", temp);
            String[] splitArray = temp.split("\\s+");
            if (splitArray[2].equals("indoor")) {
                indoorRuns.add(new CustomDataEntry(splitArray[0] + " " + splitArray[1], Integer.parseInt(splitArray[3]), Integer.parseInt(splitArray[4]) ));
            } else {
                outdoorRuns.add(new CustomDataEntry(splitArray[0] + " " + splitArray[1], Integer.parseInt(splitArray[3]), Integer.parseInt(splitArray[4]) ));
            }
        }
        this.drawChart();
    }
    private void drawChart() {

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));
        Cartesian cartesian = AnyChart.line();
        cartesian.animation(true);
        cartesian.padding(10d, 20d, 5d, 20d);
        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                .yStroke((Stroke) null, null, null, (String) null, (String) null);
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.title("Outdoor Run");
        cartesian.yAxis(0).title("Distance (meters)");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);
        List<DataEntry> dataSet = this.getDataSet();
        Set set = Set.instantiate();
        set.data(dataSet);
        Mapping dataSetMapping = set.mapAs("{ x: 'x', value: 'value' }");
        Line series1 = cartesian.line(dataSetMapping);
        series1.name("Username");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);
        anyChartView.setChart(cartesian);
    }

    private List<DataEntry> getDataSet() {
        List<DataEntry> dataSet =  new ArrayList<>();
        Intent prevActivity = getIntent();
        String message = prevActivity.getStringExtra(StatsActivity.EXTRA_MESSAGE);
        if (message.equals("0")) {
            dataSet.addAll(indoorRuns);
        } else {
            dataSet.addAll(outdoorRuns);
        }
        return dataSet;
    }


    public class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String date, Number distance, Number time) {
            super(date, distance);
            setValue("time", time);
        }
    }
}
