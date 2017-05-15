package com.edimaudo.phonecontacts;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import database.ContactDB;
import entities.Contact;

public class ContactDetails extends AppCompatActivity {

  private TextView detailPhone, detailName;
  private Button backButton, editButton, deleteButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_details);

    Intent contactIntent = getIntent();
    final Contact contact = (Contact) contactIntent.getSerializableExtra("contact");

    detailName = (TextView) findViewById(R.id.detailName);
    detailPhone = (TextView) findViewById(R.id.detailPhone);

    detailName.setText(contact.getName());
    detailPhone.setText(contact.getPhone());

    backButton = (Button) findViewById(R.id.backButton);
    editButton = (Button) findViewById(R.id.editButton);
    deleteButton = (Button) findViewById(R.id.deleteButton);

    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent backIntent = new Intent(ContactDetails.this, MainActivity.class);
        startActivity(backIntent);
      }
    });

    deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(view.getContext());
        builder.setCancelable(false);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            ContactDB contactDB = new ContactDB(getBaseContext());

            if (contactDB.delete(contact.getId())){
              Intent deleteIntent = new Intent(ContactDetails.this, MainActivity.class);
              startActivity(deleteIntent);
            } else {
              AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
              builder.setCancelable(false);
              builder.setMessage("Fail");
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

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

          }
        });
        builder.create().show();
      }
    });

    editButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent editIntent = new Intent(ContactDetails.this, EditContact.class);
        editIntent.putExtra("contact",contact);
        startActivity(editIntent);
      }
    });

  }
}
