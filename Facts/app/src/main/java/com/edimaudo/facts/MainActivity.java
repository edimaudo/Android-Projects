package com.edimaudo.facts;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;
    private Button nextButton;
    private TextView factText;
    private TextView didYouKnowText;
    private RelativeLayout relativeLayout;

    final String[] data = {"Nigeria, with 521 languages has the fourth most in the world. This includes 510 living languages, two second languages without native speakers and 9 extinct languages.",
    "The Portuguese reached Nigeria in 1472. In 1880 the British began conquering Nigeria’s south. The north was conquered by 1903.",
    "Wole Soyinka is a Nigerian Nobel laureate. He wrote ‘Telephone Conversation!’",
    "With a net worth of $16.1bn, Nigeria’s Aliko Dangote is the richest Black person in the world.",
    "Yoruba and their bloodlines worldwide have the highest rate of twinning (having twins) in the world.",
    "The 2006 Census found Nigerians to be the highest educated ethnic or racial group in America."};

    public void getFact(){
        Random rand = new Random();
        int num = rand.nextInt(data.length);
        factText.setText(data[num]);
    }

    public void getColor(){
        Random rand = new Random();
        int rand1 = rand.nextInt(256);
        int rand2 = rand.nextInt(256);
        int rand3 = rand.nextInt(256);
        relativeLayout.setBackgroundColor(Color.rgb(rand1,rand2,rand3));
        nextButton.setTextColor(Color.rgb(rand1,rand2,rand3));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        startButton = (Button) findViewById(R.id.startButton);
        nextButton = (Button) findViewById(R.id.newFactButton);
        factText = (TextView) findViewById(R.id.factText);
        didYouKnowText = (TextView) findViewById(R.id.didYouKnowTextView);
        relativeLayout = (RelativeLayout) findViewById(R.id.body);

        nextButton.setVisibility(View.INVISIBLE);
        didYouKnowText.setVisibility(View.INVISIBLE);
        factText.setVisibility(View.INVISIBLE);

        startButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startButton:
                startButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                didYouKnowText.setVisibility(View.VISIBLE);
                factText.setVisibility(View.VISIBLE);
                getColor();
                getFact();
                break;
            case R.id.newFactButton:
                getColor();
                getFact();
                break;
        }
    }
}
