package com.danbirks.astrologyandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Planets extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
    }

    public void planet(View view) {
        String planet = view.getTag().toString();
        Intent intent = new Intent(this, OneElement.class);
        intent.putExtra("planet", planet);
        startActivity(intent);
    }


}