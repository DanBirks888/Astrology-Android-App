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
import com.danbirks.astrologyandroidapp.model.AstralBody;
import com.jacksonandroidnetworking.JacksonParserFactory;

import org.apache.commons.lang3.StringUtils;

public class PlanetElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_planet);
        String element = getIntent().getExtras().getString("element");
        String url = getIntent().getExtras().getString("url");
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        jsonParse(
                url,
                element,
                findViewById(R.id.title),
                findViewById(R.id.icon),
                findViewById(R.id.singleLineMeaning),
                findViewById(R.id.data));
    }

    private void jsonParse(String url, String element, TextView title, ImageView icon, TextView slm, TextView data) {
        AndroidNetworking.get(url + element)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(AstralBody.class, new ParsedRequestListener<AstralBody>() {
                    @Override
                    public void onResponse(AstralBody astralBody) {
                        title.setText(astralBody.getAstralBody());
                        icon.setImageResource(getResources().getIdentifier(StringUtils.lowerCase(element), "drawable", getPackageName()));
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