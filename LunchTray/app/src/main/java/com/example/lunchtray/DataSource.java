package com.example.lunchtray;

import java.util.ArrayList;
import java.util.List;

class DataSource {
  ItemType itemType = new ItemType();
  int entree = itemType.getENTREE();
  int sidedish = itemType.getSIDE_DISH();
  int accompaniment = itemType.getACCOMPANIMENT();


  public List<MenuItem> entreeData() {
    List<MenuItem> entreeItemList = new ArrayList<>();
    MenuItem menuItem= new MenuItem("Cauliflower",
            "Whole cauliflower, brined, roasted, and deep fried", 7.00, entree);
    entreeItemList.add(menuItem);
    menuItem = new MenuItem("Three Bean Chili",
            "Black beans, red beans, kidney beans, slow cooked, topped with onion",
            4.00, entree);
    entreeItemList.add(menuItem);
    menuItem = new MenuItem("Mushroom Pasta",
            "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and olive oil", 5.50, entree);
    entreeItemList.add(menuItem);
    menuItem = new MenuItem("Spicy Black Bean Skillet",
            "Seasonal Vegetables, black beans, house spice blend, served with avocados and pickled onions",
            0.50, accompaniment);
    entreeItemList.add(menuItem);
    return entreeItemList;

  }

  public List<MenuItem>  sideDishData(){
    List<MenuItem> sideItemList = new ArrayList<>();
    MenuItem menuItem= new MenuItem("Summer Salad",
            "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
            2.50, sidedish);
    sideItemList .add(menuItem);
    menuItem = new MenuItem("Butternut Squash Soup",
            "Roasted butternut squash, roasted peppers, chili oil",
            3.00,sidedish);
    sideItemList .add(menuItem);
    menuItem = new MenuItem("Spicy Potatoes",
            "Marble potatoes, roasted, and fried in house spice blend",
            2.00, sidedish);
    sideItemList .add(menuItem);
    menuItem = new MenuItem("Coconut Rice",
            "Rice, coconut milk, lime, and sugar",
            1.50, sidedish);
    sideItemList .add(menuItem);
    return sideItemList;
  }

  public List<MenuItem>  accompainmentData(){
    List<MenuItem> itemList = new ArrayList<>();
    MenuItem menuItem= new MenuItem("Lunch Roll",
            "Fresh baked roll made in house",
            0.50,
            accompaniment);
    itemList.add(menuItem);
    menuItem= new MenuItem("Mixed Berries",
            "Strawberries, blueberries, raspberries, and huckleberries",
            1.00,
            accompaniment);
    itemList.add(menuItem);
    menuItem= new MenuItem("Pickled Veggies",
            "Pickled cucumbers and carrots, made in house",
            0.50,
            accompaniment);
    itemList.add(menuItem);
    return itemList;

  }
}





