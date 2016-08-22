package com.edimaudo.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
  private BottomSheetBehavior mBottomSheetBehavior;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    View bottomSheet = findViewById( R.id.bottom_sheet );

    mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return super.onCreateOptionsMenu(menu);

  }

  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_show_bottom:
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        break;
      default:
        break;
    }

    return true;
  }
}
