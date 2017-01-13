package com.edimaudo.movietime;

/**
 * Created by edima on 2017-01-12.
 */

public class Movie {
  private String title, year, genre;
  private static final int NO_IMAGE_PROVIDED = -1;
  private int mImageResourceID = NO_IMAGE_PROVIDED;

  public Movie(String title, String year, String genre, int mImageResourceID) {
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.mImageResourceID = mImageResourceID;
  }

  public boolean hasImage(){
    return mImageResourceID != NO_IMAGE_PROVIDED;
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

  public int getmImageResourceID() {
    return mImageResourceID;
  }

  public void setmImageResourceID(int mImageResourceID) {
    this.mImageResourceID = mImageResourceID;
  }
}
