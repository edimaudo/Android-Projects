package com.edimaudo.deals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private ImageView blueDoor, greenDoor, orangeDoor;
  private TextView dealInfo, gameInfo;
  public final static String EXTRA_MESSAGE = "com.edimaudo.deals.MESSAGE";
  int blueCount = 0;
  int orangeCount = 0;
  int greenCount = 0;
  StringBuilder outputString = new StringBuilder();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dealInfo = (TextView) findViewById(R.id.dealInfo);
    gameInfo = (TextView) findViewById(R.id.gameInfo);

    blueDoor = (ImageView) findViewById(R.id.blueDoor);
    greenDoor = (ImageView) findViewById(R.id.greenDoor);
    orangeDoor = (ImageView) findViewById(R.id.orangeDoor);

    blueDoor.setOnClickListener(this);
    greenDoor.setOnClickListener(this);
    orangeDoor.setOnClickListener(this);

    Intent resetIntent = new Intent();
    if (resetIntent.getStringExtra(outcome.RESTART_MESSAGE) != null){
      resetGame();
      Log.i("called","called");
    }
  }

public void checkOutcome(int blue, int orange, int green){
  if (blue + orange + green == 1){
    if(blue == 1){
      dealInfo.setText("You picked the blue door");
      outputString.append("I opened the Orange Door which held a BAD THING.  ");
      outputString.append("Now if you want to switch you can choose the Green Door ");
      outputString.append("or you can keep your first choice and open the Blue Door.");
    } else if (orange == 1){
      dealInfo.setText("You picked the orange door");
      outputString.append("I opened the Blue Door which held a BAD THING.  ");
      outputString.append("Now if you want to switch you can choose the Green Door ");
      outputString.append("or you can keep your first choice and open the Orange Door.");
    } else {
      dealInfo.setText("You picked the green door");
      outputString.append("I opened the Orange Door which held a BAD THING.  ");
      outputString.append("Now if you want to switch you can choose the Blue Door ");
      outputString.append("or you can keep your first choice and open the Green Door.");
    }
    gameInfo.setText(outputString.toString());
  } else if (blue + orange + green == 2){
    String outputMessage = "";
    if(blue == 2 || orange == 2 || green == 2){
      outputMessage = "lost";
    } else if (blue + orange == 2 || blue + green == 2 || green + orange == 2){
      outputMessage = "won";
    }
    Intent in = new Intent(this,outcome.class);
    in.putExtra(EXTRA_MESSAGE,outputMessage);
    startActivity(in);
  }
}

  @Override
  public void onClick(View view) {

    switch (view.getId()){
      case R.id.blueDoor:
        blueCount++;
        orangeDoor.setImageDrawable(getResources().getDrawable(R.drawable.orange_door_fire, getApplicationContext().getTheme()));
        break;
      case R.id.greenDoor:
        greenCount++;
        orangeDoor.setImageDrawable(getResources().getDrawable(R.drawable.orange_door_fire, getApplicationContext().getTheme()));
        break;
      case R.id.orangeDoor:
        blueDoor.setImageDrawable(getResources().getDrawable(R.drawable.blue_door_fire, getApplicationContext().getTheme()));
        orangeCount++;
        break;
    }
    checkOutcome(blueCount, orangeCount,greenCount);

  }

  public void resetGame(){
    blueCount = 0;
    orangeCount = 0;
    greenCount = 0;
    outputString = new StringBuilder();
  }
}

/*
I opened the Orange Door which held a BAD THING.
Now if you want to switch you can choose the Green Door
or you can keep your first choice and open the Blue Door.
 */
