package com.edimaudo.downtheweight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class goal extends AppCompatActivity {

  private ListView activity_goal;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_goal);

    activity_goal = (ListView) findViewById(R.id.activity_goal);

    Bundle extras = getIntent().getExtras();
    String currentWeight = extras.getString("CURRENT_WEIGHT");
    String targetWeight = extras.getString("GOAL_WEIGHT");
    String dayInfo = extras.getString("DIET_TIME");

    generateOuptut(currentWeight,targetWeight,dayInfo);
  }

  public void generateOuptut(String weightData, String targetData, String timeLine){



  }
}
