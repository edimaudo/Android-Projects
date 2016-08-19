package com.edimaudo.addnewlistitem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NewItem extends AppCompatActivity {
  private EditText new_item;
  public final static String EXTRA_MESSAGE = "com.edimaudo.addnewlistitem.MESSAGE";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_item);

    new_item = (EditText) findViewById(R.id.new_item);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.new_item_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_add_item:
        addNewItem();
        break;
      default:
        break;
    }

    return true;
  }

  public void addNewItem(){
    if(new_item.getText().toString().isEmpty()){
      Toast.makeText(NewItem.this, "Please enter an item", Toast.LENGTH_LONG).show();
    } else {
      Intent in = new Intent(this,MainActivity.class);
      in.putExtra(EXTRA_MESSAGE,new_item.getText().toString());
      startActivity(in);
    }
  }
}
