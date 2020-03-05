package com.example.motivator;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import static android.content.Context.MODE_PRIVATE;

public class ListHolder extends AppCompatActivity {
    public ArrayList<String> moveList, reversedList;


    public ListHolder(){

    }


    public ArrayList<String> loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        moveList = gson.fromJson(json, type);
        if (moveList == null) {
            moveList = new ArrayList<>();
        }
        return moveList;
    }

    public void putData(String movement, int numOfSets, int numOfReps, int weightKg){
        moveList = loadData();
        moveList.add(movement + ": " + numOfSets + "x" + numOfReps + " " + weightKg + "kg");
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(moveList);
        editor.putString("task list", json);
        editor.apply();
    }

    public ArrayList<String> getReversedData(){
        reversedList = loadData();
        Collections.reverse(reversedList);
        return reversedList;
    }



    public void clearData(){
        //remove data
    }
}
