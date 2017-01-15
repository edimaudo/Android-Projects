package com.edimaudo.myevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String URL = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=Cher&api_key=" +
            "fe4cf14a13c9e721553215e1d9b0678c&format=json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //JsonObjectRequest// after adding volley libaray do sanity check
        JsonObjectRequest

    }
}
