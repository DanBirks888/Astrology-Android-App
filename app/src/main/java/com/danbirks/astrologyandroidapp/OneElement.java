package com.danbirks.astrologyandroidapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.danbirks.astrologyandroidapp.model.AstralBody;
import com.jacksonandroidnetworking.JacksonParserFactory;

public class OneElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);
        String planet = getIntent().getExtras().getString("planet");
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        jsonParse(
                planet,
                findViewById(R.id.title),
                (ImageView) (findViewById(R.id.icon)),
                findViewById(R.id.singleLineMeaning),
                findViewById(R.id.data));
    }

    private void jsonParse(String planet, TextView title, ImageView icon, TextView slm, TextView data) {
        System.out.println("???????????????????" + "INSIDE THE JSONPARSE");
        AndroidNetworking.get("http://10.0.2.2:8080/astrals/planet/" + planet)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(AstralBody.class, new ParsedRequestListener<AstralBody>() {
                    @Override
                    public void onResponse(AstralBody astralBody) {
                        title.setText(astralBody.getAstralBody());
                        icon.setImageResource(getResources().getIdentifier(planet, "planet", getPackageName()));
                        slm.setText(astralBody.getSingleLineMeaning().toString());
                        data.setText(astralBody.getAttributes());
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("Error" + anError.getMessage());
                    }
                });
    }


}