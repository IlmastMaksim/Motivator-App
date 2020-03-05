package com.example.motivator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Sport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set home selected
        bottomNavigationView.setSelectedItemId(R.id.stats);

        // Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.sport:
                        startActivity(new Intent(getApplicationContext()
                                , Sport.class));
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

    public void gymButton(View view) {
        Intent gymIntent = new Intent(this, GymActivity.class);
        startActivity(gymIntent);
    }

    public void runButton(View view) {
        Intent runIntent = new Intent(this, Run.class);
        startActivity(runIntent);
    }

    public void arrayButton(View view) {
        Intent runIntent = new Intent(this, TestListView.class);
        startActivity(runIntent);
    }
}