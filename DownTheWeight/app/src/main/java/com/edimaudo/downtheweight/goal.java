package com.edimaudo.downtheweight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class goal extends AppCompatActivity {

  private ListView listView;
  public ArrayList<String> info = new ArrayList<String>();
  public ArrayAdapter arrayAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_goal);

    listView = (ListView) findViewById(R.id.listView);

    Bundle extras = getIntent().getExtras();
    String currentWeight = extras.getString("CURRENT_WEIGHT");
    String targetWeight = extras.getString("GOAL_WEIGHT");
    String dayInfo = extras.getString("DIET_TIME");

    generateOuptut(currentWeight,targetWeight,dayInfo);
  }

  public void generateOuptut(String weightData, String targetData, String timeLine){
    int timeData = Integer.parseInt(timeLine);
    int weightInfo = Integer.parseInt(weightData);
    int targetWeightInfo = Integer.parseInt(targetData);
    int TotalAmount = weightInfo - targetWeightInfo;
    int weightLost = 0;
    int dailyAmount = TotalAmount/timeData;

    SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
    Calendar cal = Calendar.getInstance();
    String output = "";

    for (int i = 0; i < timeData; i++){
      output = ft.format(cal.getTime());
      info.add(output + "                      " + weightInfo + "                  " + weightLost);
      cal.add(Calendar.DAY_OF_MONTH, 1);
      weightInfo-=dailyAmount;
      weightLost+=dailyAmount;


    }

    arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,info);
    listView.setAdapter(arrayAdapter);

  }


}
