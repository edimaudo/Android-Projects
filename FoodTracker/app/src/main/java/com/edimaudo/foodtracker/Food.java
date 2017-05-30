package com.edimaudo.foodtracker;

import java.io.Serializable;

/**
 * Created by edima on 2017-05-22.
 */

public class Food implements Serializable{

  private int id;
  private String foodName;
  private int foodRating;
  private String foodImageName;

  public Food() {
  }

  public Food(int id, String foodName, int foodRating, String foodImageName) {
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
