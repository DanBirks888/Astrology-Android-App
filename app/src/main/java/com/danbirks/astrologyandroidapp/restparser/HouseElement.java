package com.danbirks.astrologyandroidapp.restparser;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.danbirks.astrologyandroidapp.R;
import com.danbirks.astrologyandroidapp.model.House;
import com.jacksonandroidnetworking.JacksonParserFactory;

import java.util.List;

public class HouseElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_element);
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        jsonParse(
                getIntent().getExtras().getString("url"),
                findViewById(R.id.allhouses)
        );
    }

    private void jsonParse(String url, TextView allhouses) {
        AndroidNetworking.get(url)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(House.class, new ParsedRequestListener<List<House>>() {
                    @Override
                    public void onResponse(List<House> house) {
                        System.out.println(house);
                        StringBuilder sb = new StringBuilder();
                        for (House h : house) sb.append(h.toString());
                        allhouses.setText(sb.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("Error" + anError.getMessage());
                    }
                });
    }
}