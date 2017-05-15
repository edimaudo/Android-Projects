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

public class EditContact extends AppCompatActivity {

  private EditText editName, editPhone;
  private Button backButton, saveButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_contact);

    Intent contactIntent = getIntent();
    final Contact contact = (Contact) contactIntent.getSerializableExtra("contact");

    editName = (EditText) findViewById(R.id.editName);
    editPhone = (EditText) findViewById(R.id.editPhone);

    editName.setText(contact.getName());
    editPhone.setText(contact.getPhone());

    backButton = (Button) findViewById(R.id.backButton);
    saveButton = (Button) findViewById(R.id.saveButton);

    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent backIntent = new Intent(EditContact.this, MainActivity.class);
        startActivity(backIntent);
      }
    });


    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ContactDB contactDB = new ContactDB(getBaseContext());
        contact.setName((editName.getText().toString()));
        contact.setPhone(editPhone.getText().toString());

        if(contactDB.update(contact)){
          Intent editIntent = new Intent(EditContact.this, MainActivity.class);
          startActivity(editIntent);
        } else {
          AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
          builder.setMessage("Fail");
          builder.setCancelable(false);
          builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
          });
          builder.create().show();
        }
      }
    });
  }
}
