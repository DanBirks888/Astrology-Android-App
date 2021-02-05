package com.danbirks.astrologyandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void planets(View view) {
        Intent intent = new Intent(this, Planets.class);
        startActivity(intent);
    }

    public void signs(View view) {
        Intent intent = new Intent(this, Signs.class);
        startActivity(intent);
    }

}