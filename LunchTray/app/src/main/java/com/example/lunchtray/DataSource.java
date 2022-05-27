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


  Map<String, List<Object>> menuItems = Map.of(
          "cauliflower",List.of("Cauliflower",
                  "Whole cauliflower, brined, roasted, and deep fried", 7.00, entree),
          "chili",List.of("Three Bean Chili",
                  "Black beans, red beans, kidney beans, slow cooked, topped with onion",
                  4.00,entree),
          "pasta",List.of("Mushroom Pasta",
                  "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and " +
                          "olive oil",
                  5.50, entree),
          "salad",List.of(
                  "Summer Salad",
                  "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
                  2.50,
                  sidedish),
          "soup", List.of(
                  "Butternut Squash Soup",
                  "Roasted butternut squash, roasted peppers, chili oil",
                  3.00,
                  sidedish
          ),
          "potatoes", List.of(
                  "Spicy Potatoes",
                  "Marble potatoes, roasted, and fried in house spice blend",
                  2.00,
                  sidedish
          ),
          "rice", List.of(
                  "Coconut Rice",
                  "Rice, coconut milk, lime, and sugar",
                  1.50,
                  sidedish
          ),
          "bread", List.of(
                  "Lunch Roll",
                  "Fresh baked roll made in house",
                  0.50,
                  accompaniment
          ),
          "berries", List.of(
                  "Mixed Berries",
                  "Strawberries, blueberries, raspberries, and huckleberries",
                  1.00,
                  accompaniment
          ),
          "pickles", List.of(
                  "Pickled Veggies",
                  "Pickled cucumbers and carrots, made in house",
                  0.50,
                  accompaniment)
          );
}
