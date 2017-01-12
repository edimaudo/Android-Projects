package com.edimaudo.movietime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button userRecommend, recommend;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    userRecommend = (Button) findViewById(R.id.userRecommend);
    recommend = (Button) findViewById(R.id.recommend);

    recommend.setOnClickListener(this);
    userRecommend.setOnClickListener(this);

  }

  @Override
  public void onClick(View view) {
    int choice = view.getId();
    switch (choice){
      case R.id.recommend:
        // do something
        Intent rec_intent = new Intent(MainActivity.this, recommend.class);
        startActivity(rec_intent);
        break;
      case R.id.userRecommend:
        //do something
        Intent urec_intent = new Intent(MainActivity.this, user_recommend.class);
        startActivity(urec_intent);
        break;
    }
  }


}
