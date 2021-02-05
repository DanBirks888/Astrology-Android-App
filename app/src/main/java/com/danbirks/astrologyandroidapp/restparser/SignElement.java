package com.danbirks.astrologyandroidapp.restparser;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.danbirks.astrologyandroidapp.R;
import com.danbirks.astrologyandroidapp.model.Sign;
import com.jacksonandroidnetworking.JacksonParserFactory;

import org.apache.commons.lang3.StringUtils;

public class SignElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_sign);
        String zodiac = getIntent().getExtras().getString("element");
        String url = getIntent().getExtras().getString("url");
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        jsonParse(
                url,
                zodiac,
                findViewById(R.id.signtitle),
                findViewById(R.id.signicon),
                findViewById(R.id.signelement),
                findViewById(R.id.signmode),
                findViewById(R.id.signhouse),
                findViewById(R.id.signdata));
    }

    private void jsonParse(String url, String zodiac, TextView title, ImageView icon, TextView element, TextView mode, TextView house, TextView data) {
        AndroidNetworking.get(url + zodiac)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(Sign.class, new ParsedRequestListener<Sign>() {
                    @Override
                    public void onResponse(Sign sign) {
                        title.setText(sign.getZodiac());
                        icon.setImageResource(getResources().getIdentifier(StringUtils.lowerCase(zodiac), "drawable", getPackageName()));
                        element.setText(sign.getElement());
                        mode.setText(sign.getMode());
                        house.setText(String.valueOf(sign.getHouse()));
                        data.setText(sign.getAttributes());
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("Error" + anError.getMessage());
                    }
                });
    }


}