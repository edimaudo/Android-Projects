package com.edimaudo.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    if (id == R.id.action_logout) {
      return true;
    }
    //return super.onOptionsItemSelected(item);
  }
}
