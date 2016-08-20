package com.edimaudo.shakerefresh;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ShakeEventManager.ShakeListener {
  private ListView listView;
  private ArrayAdapter listAdapter;
  private ArrayList<String> listItems = new ArrayList<>();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listView = (ListView) findViewById(R.id.listView);
    listItems.add("Apples");
    listItems.add("Bananas");
    listItems.add("Celery");
    listItems.add("Durian");
    listItems.add("Egg plant");

    listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listItems);
    listView.setAdapter(listAdapter);


  }

  public static interface ShakeListener {
    public void onShake();
  }

  public class ShakeEventManager implements SensorEventListener {
    public void init(Context ctx) {
      sManager = (SensorManager)  ctx.getSystemService(Context.SENSOR_SERVICE);
      s = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
      register();
    }
    public void register() {
      sManager.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    sd.register();
  }

  @Override
  protected void onPause() {
    super.onPause();
    sd.deregister();
  }
}
