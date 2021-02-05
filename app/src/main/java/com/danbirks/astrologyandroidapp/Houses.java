package com.danbirks.astrologyandroidapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.danbirks.astrologyandroidapp.restparser.HouseElement;

public class Houses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses);
        Intent intent = new Intent(this, HouseElement.class);
        intent.putExtra("url", "http://10.0.2.2:8080/houses/all");
        startActivity(intent);
    }

//    public void house(View view) {
//
//    }
}