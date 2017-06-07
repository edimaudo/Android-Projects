package com.edimaudo.artistwork;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private CoordinatorLayout coordinatorLayout;
  private TextInputLayout usernameLayout, passwordLayout;
  private EditText editUsername, editPassword;
  private Button signupButton;
  private TextView alreadySignUp;
  private FirebaseAuth firebaseAuth;
  private ProgressDialog progressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    editUsername = (EditText) findViewById(R.id.editUsername);
    editPassword = (EditText) findViewById(R.id.editPassword);
    usernameLayout = (TextInputLayout) findViewById(R.id.usernameLayout);
    passwordLayout = (TextInputLayout) findViewById(R.id.passwordLayout);
    signupButton = (Button) findViewById(R.id.signupButton);
    alreadySignUp = (TextView) findViewById(R.id.alreadySignUp);
    firebaseAuth = FirebaseAuth.getInstance();
    progressDialog = new ProgressDialog(this);
    signupButton.setOnClickListener(this);
    alreadySignUp.setOnClickListener(this);
  }

  private void registerUser(){

    String email = editUsername.getText().toString().trim();
    String password = editPassword.getText().toString().trim();
    if (!isNetworkAvailable()){
      Snackbar
              .make(coordinatorLayout,getResources().getString(R.string.no_network),Snackbar.LENGTH_SHORT)
              .show();
    } else if (password.isEmpty() && email.isEmpty()){
      usernameLayout.setError(getResources().getString(R.string.email_error));
      passwordLayout.setError(getResources().getString(R.string.password_error));
    } else if(password.isEmpty()) {
      passwordLayout.setError(getResources().getString(R.string.password_error));
    } else if ( email.isEmpty()) {
      usernameLayout.setError(getResources().getString(R.string.email_error));
    } else {
      usernameLayout.setError(null);
      passwordLayout.setError(null);
      progressDialog.setMessage(getResources().getString(R.string.registration_message));
      progressDialog.show();

      firebaseAuth.createUserWithEmailAndPassword(email, password)
              .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {
                  //checking if success
                  if(task.isSuccessful()){
                    //display some message here
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.registration_success),Toast.LENGTH_LONG).show();
                  }else{
                    //display some message here
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.registration_failure),Toast.LENGTH_LONG).show();
                  }
                  progressDialog.dismiss();
                }
              });
    }
  }

  @Override
  public void onClick(View view) {
    int choice = view.getId();
    switch (choice){
      case R.id.signupButton:
        registerUser();
        break;
      case R.id.alreadySignUp:
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        break;

    }


  }

  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }
}
