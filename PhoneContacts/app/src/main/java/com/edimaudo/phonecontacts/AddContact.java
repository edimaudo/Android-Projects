package com.edimaudo.phonecontacts;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.ContactDB;
import entities.Contact;

public class AddContact extends AppCompatActivity {

  private Button backButton, saveButton;
  private EditText phone, name;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_contact);

    phone = (EditText) findViewById(R.id.phone);
    name = (EditText) findViewById(R.id.name);

    saveButton = (Button) findViewById(R.id.saveButton);
    backButton = (Button) findViewById(R.id.backButton);

    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ContactDB contactDB = new ContactDB(getBaseContext());
        Contact contact = new Contact();
        contact.setName(name.getText().toString());
        contact.setPhone(phone.getText().toString());

        if (contactDB.create(contact)){
          Intent backIntent = new Intent(AddContact.this, MainActivity.class);
          startActivity(backIntent);
        } else {
          AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
          builder.setMessage("Fail");
          builder.setCancelable(false);
          builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              dialogInterface.cancel();
            }
          });
          builder.create().show();
        }
      }
    });

    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent backIntent = new Intent(AddContact.this, MainActivity.class);
        startActivity(backIntent);
      }
    });
  }
}
