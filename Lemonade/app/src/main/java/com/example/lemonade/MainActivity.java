package com.example.lemonade;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

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


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


  }
}