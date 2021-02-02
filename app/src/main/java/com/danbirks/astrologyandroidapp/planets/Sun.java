package com.danbirks.astrologyandroidapp.planets;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.danbirks.astrologyandroidapp.R;
import com.danbirks.astrologyandroidapp.model.AstralBody;

import java.util.List;

public class Sun extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun);

        mTextViewResult = findViewById(R.id.sun_data);
        ImageButton buttonParse = findViewById(R.id.sun);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {

        AndroidNetworking.get("http://localhost:8080/astrals/planet/Sun")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(AstralBody.class, new ParsedRequestListener<List<AstralBody>>() {
                    @Override
                    public void onResponse(List<AstralBody> astralBodies) {
                        // do anything with response
                        System.out.println("your big!");

                    }

                    @Override
                    public void onError(ANError anError) {
                        // handle error
                    }
                });
    }


}