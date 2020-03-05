package com.example.motivator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MeasurementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);
    }

    public void submitButton(View v) {
        int typeHeight = Integer.parseInt(height.getText().toString());
        int typeWeight = Integer.parseInt(weight.getText().toString());
        int typeWaist = Integer.parseInt(waist.getText().toString());
    }
}
