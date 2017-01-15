package com.edimaudo.movietime;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class recommend extends AppCompatActivity {

  private List<Movie> movieList = new ArrayList<>();
  private RecyclerView recyclerView;
  private MovieAdapter mAdapter;
  static final String API_KEY = "7487a5425a90ce247f260f133f1e27ff";
  static final String API_URL = "https://api.themoviedb.org/3/movie/";
  //Example-//https://api.themoviedb.org/3/movie/550?api_key=7487a5425a90ce247f260f133f1e27ff

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recommend);

    new MovieParse().execute();

  }

  public class MovieParse extends AsyncTask<Void, Void, String> {
    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
      showInfo();
    }

    @Override
    protected void onCancelled() {
      super.onCancelled();
    }

    @Override
    protected void onCancelled(String s) {
      super.onCancelled(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
      super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(Void... params) {
      HttpURLConnection urlConnection = null;
      BufferedReader reader = null;
      String movieJSONStr = null;

      try {
        String urlString = API_URL + Integer.toString(550) + "?api_key=" + API_KEY;
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer buffer = new StringBuffer();
        if (inputStream == null){
          return null;
        }

        reader = new BufferedReader((new InputStreamReader(inputStream)));
        String line;
        while((line = reader.readLine()) != null){
          buffer.append(line);
        }

        if (buffer.length() == 0){
          return null;
        }

        movieJSONStr = buffer.toString();
        return  movieJSONStr;


      } catch (Exception e){
        return null;
      } finally {
        urlConnection.disconnect();
        if (reader != null) {
          try {
            reader.close();
          } catch (final IOException e) {
            Log.e("PlaceholderFragment", "Error closing stream", e);
          }
      }


    }
  }

  private void prepareMovieData() {
    Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
    movieList.add(movie);
    mAdapter.notifyDataSetChanged();
  }

  public void showInfo(){
    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mAdapter = new MovieAdapter(movieList);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    recyclerView.setAdapter(mAdapter);
    //prepareMovieData();
  }
}
