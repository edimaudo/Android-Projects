package com.edimaudo.foodtracker;

/**
 * Created by edima on 2017-03-18.
 */

public class Image {
  String foodName, imagePath;
  int foodRating;

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public int getFoodRating() {
    return foodRating;
  }

  public void setFoodRating(int foodRating) {
    this.foodRating = foodRating;
  }

  public Image(String foodName, String imagePath, int foodRating) {
    this.foodName = foodName;
    this.imagePath = imagePath;
    this.foodRating = foodRating;
  }

}
