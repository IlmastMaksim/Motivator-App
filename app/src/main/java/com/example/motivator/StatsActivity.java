package com.example.motivator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class StatsActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.motivator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        ListView lv = findViewById(R.id.chart_category);

        String[] chartCategories = {"Gym","Run"};

        ArrayAdapter categoryAdapter = new ArrayAdapter<String>(this,
                R.layout.stats_category_layout, chartCategories);

        lv.setAdapter(categoryAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("adapterView", "onItemClick(" + i + ")");
                Intent intent = new Intent(StatsActivity.this, StatsCategories.class);
                String msg = Integer.toString(i);
                intent.putExtra(EXTRA_MESSAGE, msg);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.stats);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.sport:
                        startActivity(new Intent(getApplicationContext()
                                , SportActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.stats:
                       return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }



}
