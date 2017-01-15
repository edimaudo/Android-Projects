package com.edimaudo.movietime;

/**
 * Created by edima on 2017-01-12.
 */

public class Movie {
  private String title, year, genre;

  public Movie(String title, String year, String genre) {
    this.title = title;
    this.year = year;
    this.genre = genre;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

}
