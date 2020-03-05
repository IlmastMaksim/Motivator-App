package com.example.motivator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestListView extends AppCompatActivity {
    private TextView tv;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Gson gson;
    private ArrayList<String> dataHolder;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlistview);



        dataHolder = loadData();
        lv = findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dataHolder));
    }

    private ArrayList<String> loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        dataHolder = gson.fromJson(json, type);
        if (dataHolder == null) {
            dataHolder = new ArrayList<>();
        }
        return dataHolder;
    }
}