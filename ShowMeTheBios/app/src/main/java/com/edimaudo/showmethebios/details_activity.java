package com.edimaudo.showmethebios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class details_activity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView bioText;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        profileImage = (ImageView) findViewById(R.id.detailsImage);
        bioText = (TextView) findViewById(R.id.detailsTextview);

        extras = getIntent().getExtras();
        if (extras != null){
            String name = extras.getString("name");
            String bio = extras.getString("bach");
            showDetails(name);
            //Toast.makeText(details_activity.this, bio, Toast.LENGTH_SHORT).show();
        }

    }

    public void showDetails(String mName){
        if (mName.equals("bach")){
            profileImage.setImageDrawable(getResources().getDrawable(R.drawable.Bach));
            bioText.setText(extras.getString(mName));
        } else {
            profileImage.setImageDrawable((getResources().getDrawable(R.drawable.Mozart)));
        }
    }

}
