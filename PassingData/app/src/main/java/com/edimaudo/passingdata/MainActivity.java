package com.edimaudo.passingdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private EditText userInput;
  public final static String EXTRA_MESSAGE = "com.edimaudo.passingdata.MESSAGE";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    userInput = (EditText) findViewById(R.id.userInput);
    userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
          // do your stuff here
        }
        return false;
      }
    });


  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return super.onCreateOptionsMenu(menu);

  }

  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_favorite:
        showActivity();
        break;
      default:
        break;
    }

    return true;
  }

  public void showActivity(){
    String userInputData = userInput.getText().toString();
    if (userInputData.equals("")){
      Toast.makeText(getApplicationContext(), "Please enter some text", Toast.LENGTH_SHORT).show();
    } else {
      Intent in = new Intent(this, secondActivity.class);
      in.putExtra(EXTRA_MESSAGE,userInputData);
      startActivity(in);
    }
  }


}
