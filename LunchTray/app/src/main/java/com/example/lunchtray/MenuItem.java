package com.example.lunchtray;

import java.text.NumberFormat;

class MenuItem {
  private String name;
  private String description;
  private Double price;
  private int type;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getFormattedPrice(Double price){
    return NumberFormat.getCurrencyInstance().format(price);
  }


  
}
