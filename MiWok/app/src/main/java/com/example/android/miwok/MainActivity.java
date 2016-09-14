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
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView colors = (TextView) findViewById(R.id.colors);
        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView family = (TextView) findViewById(R.id.family);
        TextView phrases = (TextView) findViewById(R.id.phrases);

        colors.setOnClickListener(this);
        numbers.setOnClickListener(this);
        family.setOnClickListener(this);
        phrases.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        ArrayList<String> test = new ArrayList<>();

        switch (view.getId()){

            case R.id.colors:
                intent = new Intent(this,ColorsActivity.class);
                startActivity(intent);
                break;
            case R.id.family:
                intent = new Intent(this,FamilyActivity.class);
                startActivity(intent);
                break;
            case R.id.phrases:
                intent = new Intent(this,PhrasesActivity.class);
                startActivity(intent);
                break;
            case R.id.numbers:
                intent = new Intent(this,NumbersActivity.class);
                startActivity(intent);
                break;
        }
    }
}
