package uiviewsxml.magadistudio.com.dogorcatperson;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;


public class MainActivity extends ActionBarActivity {

    private RadioGroup canineRadioGroup;
    private RadioButton canineRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot;
    private RadioGroup droolRadioGroup;
    private RadioButton droolRadioButton;
    private Button showResultButton;
    private int dogCounter;
    private int catCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call setup()
        setUp();

        //seekbar
        seekBar = (SeekBar) findViewById(R.id.seekBarFeline);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                seekBarTextView.setText("Comfortableness: " + progress + "/" +seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }

    public void setUp(){

         dogCounter = 0;
         catCounter = 0;

        canineRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCanine);
        droolRadioGroup  = (RadioGroup) findViewById(R.id.radioGroupDrool);
        seekBarTextView  = (TextView) findViewById(R.id.seekBarProgressTextView);

        //check boxes
        cutestCheckBoxDog = (CheckBox) findViewById(R.id.checkboxCutestDog);
        cutestCheckBoxCat = (CheckBox) findViewById(R.id.checkboxCutestCat);
        cutestCheckBoxParrot = (CheckBox) findViewById(R.id.checkboxCutestParrot);

        //call methods
        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);
        processDrool(droolRadioGroup);
        processCanines(canineRadioGroup);

        showResultButton = (Button) findViewById(R.id.showResults);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(getApplicationContext(), catCounter + " " +dogCounter, Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("catCounter", catCounter);
                i.putExtra("dogCounter", dogCounter);
                startActivity(i);




            }
        });



    }

    public void processCutest(CheckBox dog, CheckBox cat, CheckBox parrot){

            if (dog.isChecked() && !cat.isChecked() && !parrot.isChecked()){

                 //do stuff here
               // dogCounter = dogCounter + 5;
                dogCounter += 5;
            } else if (cat.isChecked() && !dog.isChecked() && !parrot.isChecked()){

                catCounter +=5;

            }else {

                 //nobody gets points
            }

    }

    public void processDrool( final RadioGroup radioGroup){

          radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(RadioGroup group, int checkedId) {

                  int radioId = radioGroup.getCheckedRadioButtonId();

                  droolRadioButton = (RadioButton) findViewById(radioId);

                  if (droolRadioButton.getText().equals("Yes")) {

                       dogCounter = dogCounter + 5;
                  }

              }
          });
    }

    public void processCanines(final RadioGroup radioGroup) {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                canineRadioButton = (RadioButton) findViewById(radioId);

                if (canineRadioButton.getText().equals("Yes")) {

                    dogCounter = dogCounter + 5;
                }

            }
        });
    }

}















