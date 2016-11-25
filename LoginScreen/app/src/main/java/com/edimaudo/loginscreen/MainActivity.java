package com.edimaudo.loginscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

  private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
  private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
  private Matcher matcher;
  private TextInputLayout usernameWrapper,passwordWrapper;
  private Button btn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
    passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
    btn = (Button) findViewById(R.id.btn);

    usernameWrapper.setHint("Username");
    passwordWrapper.setHint("Password");

    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // STUB
      }
    });
  }

  public boolean validateEmail(String email) {
    matcher = pattern.matcher(email);
    return matcher.matches();
  }

  public boolean validatePassword(String password) {
    return password.length() > 5;
  }

  public void onClick(View v) {
    hideKeyboard();

    String username = usernameWrapper.getEditText().getText().toString();
    String password = passwordWrapper.getEditText().getText().toString();
    if (!validateEmail(username)) {
      usernameWrapper.setError("Not a valid email address!");
    } else if (!validatePassword(password)) {
      passwordWrapper.setError("Not a valid password!");
    } else {
      usernameWrapper.setErrorEnabled(false);
      passwordWrapper.setErrorEnabled(false);
      doLogin();
    }
  }

  public void doLogin() {
    Toast.makeText(getApplicationContext(), "OK! I'm performing login.", Toast.LENGTH_SHORT).show();

  }

  private void hideKeyboard() {
    View view = getCurrentFocus();
    if (view != null) {
      ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
              hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
  }
}
