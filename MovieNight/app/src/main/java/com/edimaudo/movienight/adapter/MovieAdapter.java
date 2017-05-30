package com.edimaudo.movienight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edimaudo.movienight.R;
import com.edimaudo.movienight.model.Movie;

import java.util.List;

/**
 * Created by edima on 2017-05-30.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

  private List<Movie> movies;
  private int rowLayout;
  private Context context;

  public static class MovieViewHolder extends RecyclerView.ViewHolder {

    LinearLayout moviesLayout;
    TextView movieTitle;
    TextView data;
    TextView movieDescription;
    TextView rating;

    public MovieViewHolder(View v) {
      super(v);
      moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
      movieTitle = (TextView) v.findViewById(R.id.title);
      data = (TextView) v.findViewById(R.id.subtitle);
      movieDescription = (TextView) v.findViewById(R.id.description);
      rating = (TextView) v.findViewById(R.id.rating);
    }
  }

  public MovieAdapter(List<Movie> movies, int rowLayout, Context context) {
    this.movies = movies;
    this.rowLayout = rowLayout;
    this.context = context;
  }

  @Override
  public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
    return new MovieViewHolder(view);
  }

  @Override
  public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
    holder.movieTitle.setText(movies.get(position).getTitle());
    holder.data.setText(movies.get(position).getReleaseDate());
    holder.movieDescription.setText(movies.get(position).getOverview());
    holder.rating.setText(movies.get(position).getVoteAverage().toString());
  }

  @Override
  public int getItemCount() {
    return movies.size();
  }
}
