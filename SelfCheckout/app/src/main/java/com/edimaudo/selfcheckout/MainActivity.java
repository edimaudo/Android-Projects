package com.edimaudo.selfcheckout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private EditText quantityInfo, priceInfo;
  private TextView itemQuantityPrice, outputInfo;
  private Button saveButton;
  int count = 0;
  ArrayList<String> items = new ArrayList<String>();
  ArrayList<Double[]> priceQuantity = new ArrayList<Double[]>();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    quantityInfo = (EditText) findViewById(R.id.quantityInfo);
    priceInfo = (EditText) findViewById(R.id.priceInfo);
    itemQuantityPrice = (TextView) findViewById(R.id.itemQuantityPrice);
    outputInfo = (TextView) findViewById(R.id.outputInfo);
    saveButton = (Button) findViewById(R.id.saveButton);

    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getTotal();
      }
    });
  }

  private void getTotal(){

    Double subTotal = 0.00;
    Double tax = 0.00;
    final Double taxRate = 0.055;
    Double Total = 0.00;
    if (quantityInfo.getText().toString().equals("") || priceInfo.getText().toString().equals("")){
      Toast.makeText(getApplicationContext(), "Please enter a price and quantity", Toast.LENGTH_LONG).show();
    } else {
      count++;
      String quantity = quantityInfo.getText().toString();
      String price = priceInfo.getText().toString();
      String item = String.valueOf(count);
      StringBuilder stringInfo = new StringBuilder();
      items.add("Item " + item + "\n"+ "Price:" + price + "\n" + "Quantity: " + quantity + "\n");
      priceQuantity.add(new Double[] {Double.parseDouble(price),Double.parseDouble(quantity)});
      for (int i = 0; i < items.size();i++){
        stringInfo.append(items.get(i));
        subTotal+=priceQuantity.get(i)[0] * priceQuantity.get(i)[1];
      }
      itemQuantityPrice.setText(stringInfo.toString());
      tax = taxRate * subTotal;
      Total = tax + subTotal;
      outputInfo.setText("SubTotal: " + String.valueOf(subTotal) + "\n" + "Tax: "
              + String.valueOf(tax) + "\n"
              + "Total: " + String.valueOf(Total));
    }
  }




}
