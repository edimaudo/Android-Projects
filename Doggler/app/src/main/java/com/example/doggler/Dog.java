package com.example.doggler;

import androidx.annotation.DrawableRes;

public class Dog {

  private int imageResourceId;
  private String name, age, hobbies;

  public Dog(){

  }

  public Dog(int imageResourceId, String name,
             String age, String hobbies){
    this.imageResourceId = imageResourceId;
    this.name = name;
    this.age = age;
    this.hobbies = hobbies;

  }

  public int getImageResourceId() {
    return imageResourceId;
  }

  public void setImageResourceId(int imageResourceId) {
    this.imageResourceId = imageResourceId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getHobbies() {
    return hobbies;
  }

  public void setHobbies(String hobbies) {
    this.hobbies = hobbies;
  }


}
