package com.example.motivator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class GymActivity extends AppCompatActivity {
    private TextView sets, reps, weight;
    //SharedPreferences pref;
    //SharedPreferences.Editor editor;
    //private ArrayList<String> squatList, benchList, deadliftList;
    //Gson gson;
    ListHolder listHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        /*
        squatList = new ArrayList<>();
        pref = getSharedPreferences("SquatList", Context.MODE_PRIVATE);

         */

        //editor = pref.edit();

        sets = findViewById(R.id.sets);
        reps = findViewById(R.id.reps);
        weight = findViewById(R.id.weight);


        listHolder = new ListHolder();

    }

    public void applyButton(View v){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int numOfSets = Integer.parseInt(sets.getText().toString());
        int numOfReps = Integer.parseInt(reps.getText().toString());
        int weightKg = Integer.parseInt(weight.getText().toString());



        if(radioGroup.getCheckedRadioButtonId() == R.id.squat){
            listHolder.putData("squat", numOfSets, numOfReps, weightKg);

            /*
            //squatList.add(numOfSets + "x" + numOfReps + " " + weightKg + "kg");

            SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();

            String json = gson.toJson(squatList);
            editor.putString("task list", json);
            Log.d("Editor", "putString");

            editor.apply();
            Log.d("Editor", "commit");

             */



        } else if(radioGroup.getCheckedRadioButtonId() == R.id.bench){
            //listHolder.addToList("bench", numOfSets, numOfReps, weightKg);
        } else if(radioGroup.getCheckedRadioButtonId() == R.id.deadlift){
            //listHolder.addToList("deadlift", numOfSets, numOfReps, weightKg);
        }


        Intent applyIntent = new Intent(this, Sport.class);
        startActivity(applyIntent);
    }
}