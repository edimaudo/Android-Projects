package com.edimaudo.simplemovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private List<Movie> movieList = new ArrayList<>();
  private RecyclerView recyclerView;
  private MovieAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_main);

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    mAdapter = new MovieAdapter(movieList);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    recyclerView.setAdapter(mAdapter);
    recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
      @Override
      public void onClick(View view, int position) {
        Movie movie = movieList.get(position);
        Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onLongClick(View view, int position) {

      }
    }));


    prepareMovieData();
  }

  private void prepareMovieData() {
    Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
    movieList.add(movie);

    movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
    movieList.add(movie);

    movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
    movieList.add(movie);

    movie = new Movie("Shaun the Sheep", "Animation", "2015");
    movieList.add(movie);

    movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
    movieList.add(movie);

    movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
    movieList.add(movie);

    movie = new Movie("Up", "Animation", "2009");
    movieList.add(movie);

    movie = new Movie("Star Trek", "Science Fiction", "2009");
    movieList.add(movie);

    movie = new Movie("The LEGO Movie", "Animation", "2014");
    movieList.add(movie);

    movie = new Movie("Iron Man", "Action & Adventure", "2008");
    movieList.add(movie);

    movie = new Movie("Aliens", "Science Fiction", "1986");
    movieList.add(movie);

    movie = new Movie("Chicken Run", "Animation", "2000");
    movieList.add(movie);

    movie = new Movie("Back to the Future", "Science Fiction", "1985");
    movieList.add(movie);

    movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
    movieList.add(movie);

    movie = new Movie("Goldfinger", "Action & Adventure", "1965");
    movieList.add(movie);

    movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
    movieList.add(movie);

    mAdapter.notifyDataSetChanged();
  }
}
