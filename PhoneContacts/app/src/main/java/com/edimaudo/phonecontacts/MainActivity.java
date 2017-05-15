package com.edimaudo.phonecontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import adapters.ContactListAdapter;
import database.ContactDB;
import entities.Contact;

public class MainActivity extends AppCompatActivity {

  private Button buttonAdd;
  private ListView listViewContacts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonAdd = (Button) findViewById(R.id.buttonAdd);
    listViewContacts = (ListView) findViewById(R.id.listViewContacts);


    buttonAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent addIntent = new Intent(MainActivity.this, AddContact.class);
        startActivity(addIntent);
      }
    });

    final ContactDB contactDB = new ContactDB(this);
    listViewContacts.setAdapter(new ContactListAdapter(this, contactDB.findAll()));

    listViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Contact contact = contactDB.findAll().get(i);
        Intent detailIntent = new Intent(MainActivity.this, ContactDetails.class);
        detailIntent.putExtra("contact",contact);
        startActivity(detailIntent);
      }
    });

  }
}
