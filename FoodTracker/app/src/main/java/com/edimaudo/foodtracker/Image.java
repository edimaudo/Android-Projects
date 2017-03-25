package com.edimaudo.foodtracker;

/**
 * Created by edima on 2017-03-18.
 */

public class Image {
  String foodName, imagePath;
  String foodRating;

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public String getImagePath() {
    return imagePath;
  }

  public Image(){

  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public String getFoodRating() {
    return foodRating;
  }

  public void setFoodRating(String foodRating) {
    this.foodRating = foodRating;
  }

  public Image(String foodName, String imagePath, String foodRating) {
    this.foodName = foodName;
    this.imagePath = imagePath;
    this.foodRating = foodRating;
  }

}
