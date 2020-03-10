package com.example.motivator;

import java.util.ArrayList;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class RunActivity extends AppCompatActivity {

    private Set<String> _setFromPrefs;

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


        String finalResult = formattedDate + " " + runCategory + " " + distance + " " + time;

        this.saveToPrefs(finalResult);
        this.clearText();
    }

    private void clearText() {
        EditText distanceET = (EditText)findViewById(R.id.distance);
        EditText timeET = (EditText)findViewById(R.id.time);

        distanceET.setText("");
        timeET.setText("");
    }

    private void saveToPrefs(String res) {
        this.getSetFromPrefs();
        SharedPreferences sharedPreferences = getSharedPreferences("RUNNING_DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = sharedPreferences.edit();
        _setFromPrefs.add(res);
        editor.putStringSet("RUNNING_DATA", _setFromPrefs);
        editor.apply();
    }

    public void getSetFromPrefs()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("RUNNING_DATA", MODE_PRIVATE);
        Set<String> someSets = sharedPreferences.getStringSet("RUNNING_DATA", new HashSet<String>() );
        _setFromPrefs = new HashSet<>(someSets);
    }

    private String getDate() {
        Date myDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        return dateFormat.format(myDate);
    }

}