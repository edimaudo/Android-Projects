package com.example.lunchtray;

import android.content.ClipData;

import com.example.lunchtray.ItemType;
import com.example.lunchtray.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class DataSource {
  ItemType itemType = new ItemType();

  int entree = itemType.getENTREE();
  int sidedish = itemType.getSIDE_DISH();
  int accompaniment = itemType.getACCOMPANIMENT();

  public Map<String, MenuItem> getMenuItems() {
    return menuItems;
  }

  public void setMenuItems(Map<String, MenuItem> menuItems) {
    this.menuItems = menuItems;
  }


  Map<String, MenuItem> menuItems = Map.of(
          "cauliflower", new MenuItem("Cauliflower",
                  "Whole cauliflower, brined, roasted, and deep fried", 7.00, entree),
          "chili", new MenuItem("Three Bean Chili",
                  "Black beans, red beans, kidney beans, slow cooked, topped with onion",
                  4.00, entree),
          "pasta", new MenuItem("Mushroom Pasta",
                  "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and " +
                          "olive oil", 5.50, entree),
          "salad", new MenuItem(
                  "Summer Salad",
                  "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
                  2.50,
                  sidedish),
          "soup", new MenuItem(
                  "Butternut Squash Soup",
                  "Roasted butternut squash, roasted peppers, chili oil",
                  3.00,sidedish),
          "potatoes", new MenuItem(
                  "Spicy Potatoes",
                  "Marble potatoes, roasted, and fried in house spice blend",
                  2.00,
                  sidedish
          ),
          "rice", new MenuItem(
                  "Coconut Rice",
                  "Rice, coconut milk, lime, and sugar",
                  1.50,
                  sidedish
          ),
          "bread", new MenuItem(
                  "Lunch Roll",
                  "Fresh baked roll made in house",
                  0.50,
                  accompaniment
          ),
          "berries", new MenuItem(
                  "Mixed Berries",
                  "Strawberries, blueberries, raspberries, and huckleberries",
                  1.00,
                  accompaniment
          ),
          "pickles", new MenuItem(
                  "Pickled Veggies",
                  "Pickled cucumbers and carrots, made in house",
                  0.50,
                  accompaniment)

  );
}
