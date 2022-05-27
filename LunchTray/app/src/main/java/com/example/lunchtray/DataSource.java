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
          );



//



}
