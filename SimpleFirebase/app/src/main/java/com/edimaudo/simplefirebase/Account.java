package com.edimaudo.simplefirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Account extends AppCompatActivity {
  private Button logOut;
  private FirebaseAuth mAuth;
  private FirebaseAuth.AuthStateListener mAuthStateListener;


  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_account);
    mAuth = FirebaseAuth.getInstance();
    mAuthStateListener = new FirebaseAuth.AuthStateListener() {
      @Override
      public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if(firebaseAuth.getCurrentUser() == null){
          startActivity(new Intent(Account.this,MainActivity.class));
        }
      }
    };

    logOut = (Button) findViewById(R.id.logOut);
    logOut.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mAuth.signOut();
      }
    });
  }
}
