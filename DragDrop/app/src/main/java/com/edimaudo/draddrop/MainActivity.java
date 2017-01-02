package com.edimaudo.draddrop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.View.*;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,View.OnDragListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //set ontouch listener for box views
    findViewById(R.id.box_view1).setOnTouchListener(this);
    findViewById(R.id.box_view2).setOnTouchListener(this);
    findViewById(R.id.box_view3).setOnTouchListener(this);
    findViewById(R.id.box_view4).setOnTouchListener(this);

    //set ondrag listener for right and left parent views
    findViewById(R.id.left_view).setOnDragListener(this);
    findViewById(R.id.right_view).setOnDragListener(this);
  }

  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {
    // TODO Auto-generated method stub
    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
      DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
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
      //we want to make sure it is dropped only to left and right parent view
      View v = (View)dragEvent.getLocalState();

      if(view.getId() == R.id.left_view || view.getId() == R.id.right_view){

        ViewGroup source = (ViewGroup) v.getParent();
        source.removeView(v);

        LinearLayout target = (LinearLayout) view;
        target.addView(v);
      }
      //make view visible as we set visibility to invisible while starting drag
      v.setVisibility(View.VISIBLE);
    }
    return true;
  }





}
