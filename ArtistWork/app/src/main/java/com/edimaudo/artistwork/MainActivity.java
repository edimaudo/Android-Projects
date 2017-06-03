package com.edimaudo.artistwork;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private TextInputLayout usernameLayout, passwordLayout;
  private EditText editUsername, editPassword;
  private Button signupButton;
  private FirebaseAuth firebaseAuth;
  private ProgressDialog progressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    editUsername = (EditText) findViewById(R.id.editUsername);
    editPassword = (EditText) findViewById(R.id.editPassword);
    usernameLayout = (TextInputLayout) findViewById(R.id.usernameLayout);
    passwordLayout = (TextInputLayout) findViewById(R.id.passwordLayout);
    signupButton = (Button) findViewById(R.id.signupButton);
    firebaseAuth = FirebaseAuth.getInstance();
    progressDialog = new ProgressDialog(this);
    signupButton.setOnClickListener(this);
  }

  private void registerUser(){

    //creating a new user
    firebaseAuth.createUserWithEmailAndPassword("user email here", "user password here")
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {

                //checking if success
                if(task.isSuccessful()){
                  //display some message here
                }else{
                  //display some message here
                }

              }
            });

  }

  @Override
  public void onClick(View view) {

  }
}



/*
Snackbar
    .make(view, "No network connection.",Snackbar.LENGTH_SHORT)
    .show();
 */

/*
TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.inputLayout);
inputLayout.setError("First name is required"); // show error
inputLayout.setError(null); // hide error
 */
/*
  //chose which of the two is better
  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

  private boolean haveNetworkConnection() {
    boolean haveConnectedWifi = false;
    boolean haveConnectedMobile = false;

    ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo[] netInfo = cm.getAllNetworkInfo();
    for (NetworkInfo ni : netInfo) {
      if (ni.getTypeName().equalsIgnoreCase("WIFI"))
        if (ni.isConnected())
          haveConnectedWifi = true;
      if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
        if (ni.isConnected())
          haveConnectedMobile = true;
    }
    return haveConnectedWifi || haveConnectedMobile;
  }
*/