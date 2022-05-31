package com.example.lunchtray;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.lunchtray.DataSource;

public class EntreeMenu extends AppCompatActivity {

  public List<MenuItem> entreeList = new ArrayList<>();
  private RecyclerView recyclerView;
  private MenuAdapter mAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_entree_menu);
    //DataSource dataSource = new DataSource();
    //menuList = dataSource.entreeData();

    recyclerView = (RecyclerView) findViewById(R.id.entreemenu_recycler_view);
    mAdapter = new MenuAdapter(entreeList);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setAdapter(mAdapter);
    entreeData();
    mAdapter.notifyDataSetChanged();


  }

  public void entreeData() {
    ItemType itemType = new ItemType();
    int entree = itemType.getENTREE();
    MenuItem menuItem= new MenuItem("Cauliflower",
            "Whole cauliflower, brined, roasted, and deep fried", 7.00, entree);
    entreeList.add(menuItem);
    menuItem = new MenuItem("Three Bean Chili",
            "Black beans, red beans, kidney beans, slow cooked, topped with onion",
            4.00, entree);
    entreeList.add(menuItem);
    menuItem = new MenuItem("Mushroom Pasta",
            "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and olive oil", 5.50, entree);
    entreeList.add(menuItem);
    menuItem = new MenuItem("Spicy Black Bean Skillet",
            "Seasonal Vegetables, black beans, house spice blend, served with avocados and pickled onions",
            0.50, entree);
    entreeList.add(menuItem);


  }

}