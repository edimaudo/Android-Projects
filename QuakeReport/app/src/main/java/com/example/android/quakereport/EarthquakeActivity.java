/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Word> earthquakes = new ArrayList<Word>();
        earthquakes.add(new Word("7.20","San Francisco","Jaunry 5 2016"));
        earthquakes.add(new Word("7.20","London","Jaunry 5, 2015"));
        earthquakes.add(new Word("7.20","Tokyo","Jaunry 5, 2016"));
        earthquakes.add(new Word("7.20","Mexico","Februay 25, 2016"));
        earthquakes.add(new Word("7.20","Moscow","Jaunry 5 2016"));
        earthquakes.add(new Word("7.20","Rio De Janeeiro","Jaunry 5 2016"));
        earthquakes.add(new Word("7.20","Paris","Jaunry 5 2016"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        WordAdapter adapter = new WordAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        /*
         WordAdapter itemAdapter = new WordAdapter(this,words, R.color.category_numbers);
    ListView list = (ListView) findViewById(R.id.listView);
    list.setAdapter(itemAdapter);
         */
    }
}
