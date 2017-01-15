package com.edimaudo.languagepreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) (findViewById(R.id.textData));

        final SharedPreferences sharedPreferences = this.getSharedPreferences("com.edimaudo.languagepreferences", Context.MODE_PRIVATE);
        String chosenLangauge = sharedPreferences.getString("language","");

        if (chosenLangauge == ""){
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Which language do you want?")
                    .setMessage("Do you want English or Spanish")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sharedPreferences.edit().putString("language","english").apply();
                        }
                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sharedPreferences.edit().putString("language", "spanish").apply();
                        }
                    })
                    .show();

        } else {
            textView.setText(chosenLangauge);
        }

    }
}
