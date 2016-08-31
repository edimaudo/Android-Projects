package com.edimaudo.buildingblocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,View.OnDragListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.shape1).setOnTouchListener(this);
    findViewById(R.id.shape2).setOnTouchListener(this);
    findViewById(R.id.shape3).setOnTouchListener(this);
    findViewById(R.id.shape4).setOnTouchListener(this);
    findViewById(R.id.shape5).setOnTouchListener(this);
    findViewById(R.id.shape6).setOnTouchListener(this);

    findViewById(R.id.left_view).setOnDragListener(this);
    findViewById(R.id.right_view).setOnDragListener(this);


  }

  public boolean onTouch(View view, MotionEvent motionEvent) {
    // TODO Auto-generated method stub
    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
      View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
      view.startDrag(null, shadowBuilder, view, 0);
      view.setVisibility(View.INVISIBLE);
      return true;
    }
    return false;
  }

  @Override
  public boolean onDrag(View view, DragEvent dragEvent) {
    // TODO Auto-generated method stub
    if(dragEvent.getAction()==DragEvent.ACTION_DROP){
      View v = (View)dragEvent.getLocalState();
      if(view.getId() == R.id.left_view || view.getId() == R.id.right_view){
        ViewGroup source = (ViewGroup) v.getParent();
        source.removeView(v);
        LinearLayout target = (LinearLayout) view;
        target.addView(v);
      }
      v.setVisibility(View.VISIBLE);
    }
    return true;
  }

}
