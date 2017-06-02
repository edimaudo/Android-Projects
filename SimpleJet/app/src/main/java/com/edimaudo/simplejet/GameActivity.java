package com.edimaudo.simplejet;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.support.v7.app.AlertDialog;

public class GameActivity extends AppCompatActivity {

  private GameView gameView;

  @Override
  protected void onPause() {
    super.onPause();
    gameView.pause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    gameView.resume();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);

    //Initializing game view object
    //gameView = new GameView(this);

    //Getting display object
    Display display = getWindowManager().getDefaultDisplay();

    //Getting the screen resolution into point object
    Point size = new Point();
    display.getSize(size);

    //Initializing game view object
    //this time we are also passing the screen size to the GameView constructor
    gameView = new GameView(this, size.x, size.y);

    //adding it to contentview
    setContentView(gameView);


  }

  @Override
  public void onBackPressed() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {

                GameView.stopMusic();
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                finish();
              }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
              }
            });
    AlertDialog alert = builder.create();
    alert.show();

  }
}
