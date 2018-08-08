package com.edimaudo.checkboxes_and_etc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private ArrayList<String> items = new ArrayList<String>();;
  String word = "";
  int pos = 0;
  StringBuffer stringBuffer;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onCheckboxClicked(View view) {
    // Is the view now checked?
    boolean checked = ((CheckBox) view).isChecked();

    // Check which checkbox was clicked
    switch(view.getId()) {
      case R.id.checkbox_cheese:
        word = String.valueOf(R.string.cheese);
        if (checked){
          items.add(word);
        } else {
          pos = items.indexOf(word);
          items.remove(pos);
        }
        break;
      case R.id.checkbox_cherries:
        word = String.valueOf(R.string.cherries);
        if (checked){
          items.add(word);
        } else {
          pos = items.indexOf(word);
          items.remove(pos);
        }
        break;
      case R.id.checkbox_chocolate:
        word = String.valueOf(R.string.chocolate_syrup);
        if (checked){
          items.add(word);
        } else {
          pos = items.indexOf(word);
          items.remove(pos);
        }
        break;

      case R.id.checkbox_crushednut:
        word = String.valueOf(R.string.crushed_nuts);
        if (checked){
          items.add(word);
        } else {
          pos = items.indexOf(word);
          items.remove(pos);
        }
        break;

      case R.id.checkbox_oreo:
        word = String.valueOf(R.string.oreo_cookie_crumble);
        if (checked){
          items.add(word);
        } else {
          pos = items.indexOf(word);
          items.remove(pos);
        }
        break;

      case R.id.checkbox_sprinkle:
        word = String.valueOf(R.string.sprinkles);
        if (checked){
          items.add(word);
        } else {
          pos = items.indexOf(word);
          items.remove(pos);
        }
        break;
    }
  }

  public void buttonClick(View view) {
    for (int i = 0; i < items.size(); i++) {
      stringBuffer.append(items.get(i));
    }
    Toast.makeText(this, stringBuffer.toString(), Toast.LENGTH_LONG).show();
  }
}
