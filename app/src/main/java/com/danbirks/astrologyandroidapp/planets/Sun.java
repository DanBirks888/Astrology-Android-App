package com.danbirks.astrologyandroidapp.planets;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.danbirks.astrologyandroidapp.R;
import com.danbirks.astrologyandroidapp.model.AstralBody;
import com.jacksonandroidnetworking.JacksonParserFactory;

public class Sun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun);
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        jsonParse(findViewById(R.id.sun_data));
    }

    private void jsonParse(TextView tv) {
        AndroidNetworking.get("http://10.0.2.2:8080/astrals/planet/Sun")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(AstralBody.class, new ParsedRequestListener<AstralBody>() {
                    @Override
                    public void onResponse(AstralBody astralBody) {
                        System.out.println("Working!");
                        tv.setText(astralBody.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("Error" + anError.getMessage());
                    }
                });
    }


}