package com.example.doggler;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
//import com.example.doggler.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

  private Intent listIntent;
  private Button gridBtn, verticalBtn, horizontalBtn;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gridBtn = (Button) findViewById(R.id.grid_btn);
    verticalBtn = (Button) findViewById(R.id.vertical_btn);
    horizontalBtn = (Button) findViewById(R.id.horizontal_btn);

    gridBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        launchGrid();
      }
    });

    verticalBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        launchVertical();
      }
    });

    horizontalBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        launchHorizontal();
      }
    });

  }

  private void launchVertical(){
    listIntent = new Intent(this, VerticalListActivity.class);
    startActivity(listIntent);
  }

  private void launchGrid(){
    listIntent = new Intent(this, GridListActivity.class);
    startActivity(listIntent);
  }

  private void launchHorizontal(){
    listIntent = new Intent(this, HorizontalListActivity.class);
    startActivity(listIntent);
  }
}