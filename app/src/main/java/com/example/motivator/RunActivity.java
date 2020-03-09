package com.example.motivator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import android.content.SharedPreferences;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);
    }

    public void submitRunForm(View view) {
        String formattedDate = this.getDate();

        EditText distanceET = (EditText)findViewById(R.id.distance);
        EditText timeET = (EditText)findViewById(R.id.time);
        RadioGroup runCategoryRG = (RadioGroup) findViewById(R.id.radio);

        RadioButton runCategoryIndoorBtn = (RadioButton) findViewById(R.id.indoor);

        String runCategory = "outdoor";

        if (runCategoryIndoorBtn.isChecked()) {
            runCategory = "indoor";
        }

        String distance =  distanceET.getText().toString();
        String time =  timeET.getText().toString();


        ArrayList<String> finalResult = new ArrayList<>();

        finalResult.add(runCategory);
        finalResult.add(distance);
        finalResult.add(time);

        this.saveToSP(finalResult, formattedDate);
        this.clearText();
    }

    private void clearText() {
        EditText distanceET = (EditText)findViewById(R.id.distance);
        EditText timeET = (EditText)findViewById(R.id.time);

        distanceET.setText("");
        timeET.setText("");
    }

    private void saveToSP(ArrayList res, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("RUNNING_DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor;
        Gson gson = new Gson();
        String json = gson.toJson(res);
        editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }

    private String getDate() {
        Date myDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(myDate);
    }

}