package com.danbirks.astrologyandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.danbirks.astrologyandroidapp.planets.Sun;

public class Planets extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
    }

    public void sun(View view) {
        Intent intent = new Intent(this, Sun.class);
        startActivity(intent);
    }

}