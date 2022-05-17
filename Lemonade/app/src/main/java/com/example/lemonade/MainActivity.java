package com.example.lemonade;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import java.util.Random;
import android.content.pm.ActivityInfo;

public class MainActivity extends AppCompatActivity {

  private final String LEMONADE_STATE = "LEMONADE_STATE";
  private final String LEMON_SIZE = "LEMON_SIZE";
  private final String SQUEEZE_COUNT = "SQUEEZE_COUNT";
  // SELECT represents the "pick lemon" state
  private String SELECT = "select";
  // SQUEEZE represents the "squeeze lemon" state
  private String SQUEEZE = "squeeze";
  // DRINK represents the "drink lemonade" state
  private String DRINK = "drink";
  // RESTART represents the state where the lemonade has been drunk and the glass is empty
  private String RESTART = "restart";
  // Default the state to select
  private String lemonadeState = "select";
  // Default lemonSize to -1
  private int lemonSize = -1;
  // Default the squeezeCount to -1
  private int squeezeCount = -1;

  private ImageView lemonImage;
  private TextView lemonText;

  private int randomLemonPick;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    if (savedInstanceState != null) {
      lemonadeState = savedInstanceState.getString(LEMONADE_STATE, "select");
      lemonSize = savedInstanceState.getInt(LEMON_SIZE, -1);
      squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, -1);
    }

    lemonImage = (ImageView) findViewById(R.id.image_lemon_state);
    lemonText = (TextView) findViewById(R.id.text_action);

    randomLemonPick = pickLemonTree();

    lemonImage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        clickLemonImage();
        setViewElements();

      }
    });

    lemonImage.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View view) {
        return showSnackbar();
      }
    });
  }

  protected void onSaveInstanceState(Bundle outState) {
    outState.putString(LEMONADE_STATE, lemonadeState);
    outState.putInt(LEMON_SIZE, lemonSize);
    outState.putInt(SQUEEZE_COUNT, squeezeCount);
    super.onSaveInstanceState(outState);
  }

  private boolean showSnackbar() {
    if (lemonadeState != SQUEEZE) {
      return false;
    }
    String squeezeText = getString(R.string.squeeze_count, squeezeCount);
    Snackbar.make(
            findViewById(R.id.constraint_Layout),
            squeezeText,
            Snackbar.LENGTH_SHORT
    ).show();
    return true;
  }

  public int pickLemonTree() {
    int output = 1;
    Random rand = new Random();
    boolean complete = false;
    output = rand.nextInt(4);
    while (!complete) {
      if (output == 0) {
        output = rand.nextInt(4);
      } else {
        complete = true;
      }
    }
    return output;
  }

  private void clickLemonImage() {
    lemonSize++;
   if(lemonSize == -1){
    lemonImage.setImageResource(R.drawable.lemon_tree);
   } else if (lemonSize == randomLemonPick){
     lemonImage.setImageResource(R.drawable.lemon_drink);
   } else if (lemonSize > randomLemonPick){
     lemonImage.setImageResource(R.drawable.lemon_restart);
   } else {
     lemonImage.setImageResource(R.drawable.lemon_squeeze);
   }
  }

  private void setViewElements() {

    if(lemonSize == -1){
      lemonText.setText(getResources().getString(R.string.lemon_select));
    } else if (lemonSize == randomLemonPick){
      lemonText.setText(getResources().getString(R.string.lemon_drink));
    } else if (lemonSize > randomLemonPick){
      lemonText.setText(getResources().getString(R.string.lemon_empty_glass));
      lemonSize = -2;
      squeezeCount = -1;
    } else {
      lemonText.setText(getResources().getString(R.string.lemon_squeeze));
      squeezeCount++;
    }
  }

}