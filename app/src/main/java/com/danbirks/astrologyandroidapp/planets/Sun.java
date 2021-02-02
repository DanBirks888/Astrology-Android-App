package com.danbirks.astrologyandroidapp.planets;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.danbirks.astrologyandroidapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.IntStream;

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
        String url = "localhost:8080/astrals/planet/Sun";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject sun = jsonArray.getJSONObject(i);

                                String astralBody = sun.getString("astralBody");
                                JSONArray slm = sun.getJSONArray("singleLineMeaning");

                                List<String> asdf = IntStream.range(0, slm.length())
                                        .mapToObj()

                                String attributes = sun.getString("attributes");

                                mTextViewResult.append(astralBody + "\n " + attributes + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, Throwable::printStackTrace);
        mQueue.add(request);
    }


}