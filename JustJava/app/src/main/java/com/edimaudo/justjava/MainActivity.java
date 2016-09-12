package com.edimaudo.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private TextInputLayout inputLayout;
  private TextView quantityText, priceText;
  private EditText userInput;
  private Button subtractButton, addButton, orderButton;
  private CheckBox toppingCheckBox1, toppingCheckBox2;
  private int quantity = 0;
  private int[] toppingQty = {0, 0};
  private int[] toppingPrice = {1, 2};
  private final int coffeePrice = 5;
  StringBuilder emailBody = new StringBuilder();
  private String subject = "Just Java for ";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    quantityText = (TextView) findViewById(R.id.quantityText);
    priceText = (TextView) findViewById(R.id.priceText);

    userInput = (EditText) findViewById(R.id.userInput);

    inputLayout = (TextInputLayout) findViewById(R.id.inputLayout);

    toppingCheckBox1 = (CheckBox) findViewById(R.id.toppingCheckBox1);
    toppingCheckBox2 = (CheckBox) findViewById(R.id.toppingCheckBox2);

    subtractButton = (Button) findViewById(R.id.subtractButton);
    addButton = (Button) findViewById(R.id.addButton);
    orderButton = (Button) findViewById(R.id.orderButton);

    orderButton.setOnClickListener(this);
    addButton.setOnClickListener(this);
    subtractButton.setOnClickListener(this);

    toppingCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
          toppingQty[0] = 1;
        } else {
          toppingQty[0] = 0;
        }
        updatePriceQty();
      }
    });

    toppingCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
          toppingQty[1] = 1;
        } else {
          toppingQty[1] = 0;
        }
        updatePriceQty();
      }
    });

    userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if(i == EditorInfo.IME_ACTION_DONE){
          if(userInput.getText().toString().equals("")){
            inputLayout.setError("Name is required");
          } else {
            inputLayout.setError(null); // hide error
          }
        }
        return false;
      }
    });


  }

  public void updatePriceQty() {
    quantityText.setText(String.valueOf(quantity));
    priceText.setText(calculatePrice());
  }


  public void updateEmailInfo() {
    subject += userInput.getText().toString();
    emailBody.append("Name: ");
    emailBody.append(userInput.getText().toString());
    emailBody.append("\n");
    emailBody.append("Add whipped cream? ");
    if (toppingQty[0] == 1) {
      emailBody.append("true");
    } else {
      emailBody.append("false");
    }
    emailBody.append("\n");
    emailBody.append("Add chocoate? ");
    if (toppingQty[1] == 1) {
      emailBody.append("true");
    } else {
      emailBody.append("false");
    }
    emailBody.append("\n");
    emailBody.append("Quantity: ");
    emailBody.append(quantity);
    emailBody.append("\n");
    emailBody.append("Total: ");
    emailBody.append(calculatePrice());
    emailBody.append("\n");
    emailBody.append("Thank you!");
  }


  public String calculatePrice() {
    String output = "";
    output = String.valueOf(quantity *  (coffeePrice + (toppingQty[0] * toppingPrice[0])
            + (toppingQty[1] * toppingPrice[1])));
    return "Price: $" + output;
  }


  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.addButton:
        if (quantity < 100) {
          quantity++;
        } else {
          quantity = 100;
        }
        updatePriceQty();
        break;
      case R.id.subtractButton:
        if (quantity > 0) {
          quantity--;
        } else {
          quantity = 0;
        }
        updatePriceQty();
        break;
      case R.id.orderButton:
        createOrder();
        break;
    }
  }

  public void createOrder() {
    if (userInput.getText().toString().equals("")) {
      inputLayout.setError("Name is required"); // show error
    } else if (quantity < 1){
        Toast.makeText(MainActivity.this, "Please buy at least 1 coffee", Toast.LENGTH_SHORT).show();
    } else {
      updateEmailInfo();
      Intent intent = new Intent(Intent.ACTION_SENDTO);
      intent.setType("text/plain");
      intent.setData(Uri.parse("mailto:"));
      intent.putExtra(Intent.EXTRA_SUBJECT, subject);
      intent.putExtra(Intent.EXTRA_TEXT, emailBody.toString());
      startActivity(Intent.createChooser(intent, "Send coffee order"));
      emailBody = new StringBuilder();
      subject = "Just Java for ";
    }
  }

}

