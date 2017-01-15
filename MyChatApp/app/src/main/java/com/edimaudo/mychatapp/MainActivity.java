package com.edimaudo.mychatapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.parse.ParseObject;
import com.parse.Parse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("sdO6YryXzG9qYd6RawqaEVW3J5X5KZfNfDBhHGmu")
                .server("http://YOUR_PARSE_SERVER:1337/parse")
                .build());

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
