package com.edimaudo.simplespinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
  private Spinner spinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    spinner = (Spinner) findViewById(R.id.spinner);
    spinner.setOnItemSelectedListener(this);

    ArrayList<String> category = new ArrayList<>();
    category.add("Auto");
    category.add("Business services");
    category.add("Computer repairs");
    category.add("Design");
    category.add("Education");
    category.add("Lifestyle");
    category.add("Leisure and travel");

    ArrayAdapter categoryAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,category);
    spinner.setAdapter(categoryAdapter);
  }

  @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    StringBuilder stringInfo = new StringBuilder();
    stringInfo.append(adapterView.getItemAtPosition(i).toString());
    Toast.makeText(MainActivity.this, "Selected: " + stringInfo.toString(), Toast.LENGTH_SHORT).show();

  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {

  }
}
