package com.example.doggler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.doggler.DogAdapter;
import com.example.doggler.Layout;
import com.example.doggler.Dog;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;


public class GridListActivity extends AppCompatActivity {

  public List<Dog> dogList = new ArrayList<>();
  private RecyclerView recyclerView;
  private DogAdapter dAdapter;
  private int layoutGRID;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Layout layout = new Layout();
    layoutGRID = layout.getGRID();

    setContentView(R.layout.activity_grid_list);
    prepareData();
    recyclerView = (RecyclerView) findViewById(R.id.grid_recycler_view);
    dAdapter = new DogAdapter(dogList);
    GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),layoutGRID);
    //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),layoutGRID,true);
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setAdapter(dAdapter);
    recyclerView.setHasFixedSize(true);


  }

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

