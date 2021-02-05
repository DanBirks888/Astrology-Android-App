package com.danbirks.astrologyandroidapp.restparser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.danbirks.astrologyandroidapp.R;
import com.jacksonandroidnetworking.JacksonParserFactory;

public class SignElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_planet);
        String element = getIntent().getExtras().getString("element");
        String url = getIntent().getExtras().getString("url");
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.setParserFactory(new JacksonParserFactory());
//        jsonParse(
//                url,
//                element,
//                findViewById(R.id.title),
//                findViewById(R.id.icon),
//                findViewById(R.id.singleLineMeaning),
//                findViewById(R.id.data));
    }

//    private void jsonParse(String url, String element, TextView title, ImageView icon, TextView slm, TextView data) {
//        AndroidNetworking.get(url + element)
//                .setTag(this)
//                .setPriority(Priority.LOW)
//                .build()
//                .getAsObject(Sign.class, new ParsedRequestListener<Sign>() {
//                    @Override
//                    public void onResponse(Sign sign) {
////                        icon.setImageResource(getResources().getIdentifier(StringUtils.lowerCase(element), "drawable", getPackageName()));
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        System.out.println("Error" + anError.getMessage());
//                    }
//                });
//    }


}