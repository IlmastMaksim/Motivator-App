package com.example.motivator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MeasurementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);
    }

    public void submitButton(View v) {
        TextView typeHeight = findViewById(R.id.heightText);
        TextView typeWeight = findViewById(R.id.weightText);
        TextView typeWaist = findViewById(R.id.waistText);
    }
}
