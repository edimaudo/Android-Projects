package com.edimaudo.movietime;

/**
 * Created by edima on 2017-01-15.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
  private List<Movie> movieList;

  public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView title, year, genre;

    public MyViewHolder(View itemView) {
      super(itemView);
      title = (TextView) itemView.findViewById(R.id.title);
      genre = (TextView) itemView.findViewById(R.id.genre);
      year = (TextView) itemView.findViewById(R.id.year);
    }
  }

  public MovieAdapter(List<Movie> movieList){
    this.movieList = movieList;
  }

  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.movie_list_row, parent, false);

    return new MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    Movie movie = movieList.get(position);
    holder.title.setText(movie.getTitle());
    holder.genre.setText(movie.getGenre());
    holder.year.setText(movie.getYear());
  }

  public int getItemCount() {
    return movieList.size();
  }

}

