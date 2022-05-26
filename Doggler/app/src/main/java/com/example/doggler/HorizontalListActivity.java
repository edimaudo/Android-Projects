package com.example.doggler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HorizontalListActivity extends AppCompatActivity {
  public List<Dog> dogList = new ArrayList<>();
  private RecyclerView recyclerView;
  private DogAdapter dAdapter;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_horizontal_list);
    prepareData();
    recyclerView = (RecyclerView) findViewById(R.id.horizontal_recycler_view);
    dAdapter = new DogAdapter(dogList);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),
            LinearLayoutManager.HORIZONTAL,false);
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setAdapter(dAdapter);

  }

  // Load information
  private void prepareData(){
    Dog dog= new Dog(R.drawable.tzeitel, "Tzeitel","7", "sunbathing");
    dogList.add(dog);
    dog= new Dog(R.drawable.leroy, "Leroy","4", "sleeping in dangerous places");
    dogList.add(dog);
    dog= new Dog(R.drawable.frankie, "Frankie","2", "stealing socks");
    dogList.add(dog);
    dog= new Dog(R.drawable.nox, "Nox","8", "meeting new animals");
    dogList.add(dog);
    dog= new Dog(R.drawable.faye, "Faye","8", "Digging in the garden");
    dogList.add(dog);
    dog= new Dog(R.drawable.bella, "Bella","14", "Chasing sea foam");
    dogList.add(dog);
  }
}