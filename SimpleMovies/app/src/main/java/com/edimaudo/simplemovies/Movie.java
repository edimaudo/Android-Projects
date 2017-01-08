package com.edimaudo.simplemovies;



public class Movie {
  private String title, genre, year;

  public Movie(){}

  public Movie(String title, String genre, String year){
    this.title = title;
    this.genre = genre;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
