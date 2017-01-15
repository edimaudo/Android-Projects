package com.edimaudo.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button dialogButton;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogButton = (Button) findViewById(R.id.button);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle(getResources().getString(R.string.dialog_title));//title
                dialog.setMessage(getResources().getString(R.string.dialog_message));//message
                //dialog.setIcon(R.drawable.btn_star)//add an icon
                dialog.setCancelable(false);//prevent people from cancelling the dailog with the buttom
                dialog.setPositiveButton(getResources().getString(R.string.positive_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //exit activity
                                MainActivity.this.finish();
                            }
                        });//set positive button

                dialog.setNegativeButton(getResources().getString(R.string.negative_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });//negative button


                AlertDialog alertD = dialog.create(); //create dialog
                alertD.show();//show dialog

            }
        });
    }
}
