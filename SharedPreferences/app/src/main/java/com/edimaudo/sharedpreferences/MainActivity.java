package com.edimaudo.sharedpreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates shared preferences
        SharedPreferences preferences = this.getSharedPreferences("com.edimaudo.sharedpreferences", Context.MODE_PRIVATE);//mode private to keep your info proviate
        preferences.edit().putString("username","ed").apply();//create shared preference info
        String username = preferences.getString("username","");//get shared preference info

        //shows a dialog box
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Are you sure?")
                .setMessage("Do you definitely want to do this")
                .setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("No",null)
                .show();




    }
}
