package com.danbirks.astrologyandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.danbirks.astrologyandroidapp.restparser.SignElement;

import org.apache.commons.lang3.StringUtils;

public class Signs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signs);
    }

    public void sign(View view) {
        Bundle b = new Bundle();
        b.putString("element", StringUtils.capitalize(view.getTag().toString()));
        b.putString("url", "http://10.0.2.2:8080/signs/zodiac/");
        Intent intent = new Intent(this, SignElement.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}