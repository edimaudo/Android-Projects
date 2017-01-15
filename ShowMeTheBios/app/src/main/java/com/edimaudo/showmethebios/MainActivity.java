package com.edimaudo.showmethebios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bachImage;
    private ImageView mozartImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bachImage = (ImageView) findViewById(R.id.bachImage);
        mozartImage =  (ImageView) findViewById(R.id.mozartImage);
        bachImage.setOnClickListener(this);
        mozartImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bachImage:
                Intent bachIntent = new Intent(MainActivity.this,details_activity.class);
                bachIntent.putExtra("name","Bach");
                bachIntent.putExtra("bach","Hello I am bach");
                startActivity(bachIntent);
                break;
            case R.id.mozartImage:
                Intent mozartIntent = new Intent(MainActivity.this,details_activity.class);
                mozartIntent.putExtra("name","mozart");
                mozartIntent.putExtra("mozart","Hello I am mozart");
                startActivity(mozartIntent);
                break;
        }
    }
}
