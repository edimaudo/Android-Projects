package com.edimaudo.movienight.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.edimaudo.movienight.R;
import com.edimaudo.movienight.adapter.MovieAdapter;
import com.edimaudo.movienight.model.Movie;
import com.edimaudo.movienight.model.MovieResponse;
import com.edimaudo.movienight.rest.ApiClient;
import com.edimaudo.movienight.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

  private static final String TAG = MovieActivity.class.getSimpleName();
  private static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie);
    
    API_KEY = getResources().getString(R.string.api_key);
    
    if (API_KEY.isEmpty()){
      Toast.makeText(this, getResources().getString(R.string.check_api_key),
              Toast.LENGTH_SHORT).show();
    }

    final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);

    Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
    call.enqueue(new Callback<MovieResponse>() {
      @Override
      public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
        int statusCode = response.code();
        List<Movie> movies = response.body().getResults();
        recyclerView.setAdapter(new MovieAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
      }

      @Override
      public void onFailure(Call<MovieResponse> call, Throwable t) {
        // Log error here since request failed
        Log.e(TAG, t.toString());
      }
    });
  }
}

