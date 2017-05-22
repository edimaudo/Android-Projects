package com.edimaudo.foodtracker;

/**
 * Created by edima on 2017-05-22.
 */

public class Food {

  private int id;
  private String foodImageName;
  private int foodRating;
  private String foodName;

  public Food() {
  }

  public Food(int id, String foodImageName, int foodRating, String foodName) {
    this.id = id;
    this.foodImageName = foodImageName;
    this.foodRating = foodRating;
    this.foodName = foodName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFoodImageName() {
    return foodImageName;
  }

  public void setFoodImageName(String foodImageName) {
    this.foodImageName = foodImageName;
  }

  public int getFoodRating() {
    return foodRating;
  }

  public void setFoodRating(int foodRating) {
    this.foodRating = foodRating;
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }
}
