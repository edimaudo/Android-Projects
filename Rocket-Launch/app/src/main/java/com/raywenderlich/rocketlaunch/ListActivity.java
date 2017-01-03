package com.raywenderlich.rocketlaunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.raywenderlich.rocketlaunch.animationactivities.AccelerateRocketAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.ColorAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.FlyThereAndBackAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.FlyWithDogeAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.LaunchRocketValueAnimatorAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.LaunchAndSpinAnimatorSetAnimatorActivity;
import com.raywenderlich.rocketlaunch.animationactivities.LaunchAndSpinViewPropertyAnimatorAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.LaunchRocketObjectAnimatorAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.RotateRocketAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.NoAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.WithListenerAnimationActivity;
import com.raywenderlich.rocketlaunch.animationactivities.XmlAnimationActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
    recyclerView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));

    List<RocketAnimationItem> items = new ArrayList<>();

    items.add(new RocketAnimationItem(getString(R.string.title_no_animation),
        new Intent(this, NoAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_launch_rocket),
        new Intent(this, LaunchRocketValueAnimatorAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_spin_rocket),
        new Intent(this, RotateRocketAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_accelerate_rocket),
        new Intent(this, AccelerateRocketAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_launch_rocket_objectanimator),
        new Intent(this, LaunchRocketObjectAnimatorAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_color_animation),
        new Intent(this, ColorAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.launch_spin),
        new Intent(this, LaunchAndSpinAnimatorSetAnimatorActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.launch_spin_viewpropertyanimator),
        new Intent(this, LaunchAndSpinViewPropertyAnimatorAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_with_doge),
        new Intent(this, FlyWithDogeAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_animation_events),
        new Intent(this, WithListenerAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_there_and_back),
        new Intent(this, FlyThereAndBackAnimationActivity.class)));

    items.add(new RocketAnimationItem(getString(R.string.title_jump_and_blink),
        new Intent(this, XmlAnimationActivity.class)));

    recyclerView.setAdapter(new RocketAdapter(this, items));

  }

}
