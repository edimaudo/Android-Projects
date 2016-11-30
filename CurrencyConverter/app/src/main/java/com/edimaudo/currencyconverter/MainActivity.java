package com.edimaudo.currencyconverter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.edimaudo.currencyconverter.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

  private EditText userInput;
  private Spinner spinner, spinner2;
  private TextView textView, textView2,textView3;
  private Button convert;
  private CoordinatorLayout coordinatorLayout;




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(activity_main);

    userInput = (EditText) findViewById(R.id.userInput);
    spinner = (Spinner) findViewById(R.id.spinner);
    spinner2 = (Spinner) findViewById(R.id.spinner2);
    textView = (TextView) findViewById(R.id.textView);
    textView2 = (TextView) findViewById(R.id.textView2);
    textView3 = (TextView) findViewById(R.id.textView3);
    convert = (Button) findViewById(R.id.convert);
    coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

    convert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //check if the user enter an amount
        if (userInput.getText().toString().isEmpty()){
          Snackbar
                  .make(coordinatorLayout, "Please enter an amount",Snackbar.LENGTH_LONG)
                  .show();
        }
        else if(!isNetworkAvailable()){
          Snackbar
                  .make(coordinatorLayout, "No network connection!",Snackbar.LENGTH_LONG)
                  .show();
        }
        else {
          new currencyParse().execute();
        }
      }
    });

  }



  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }


  public class currencyParse extends AsyncTask<Void, Void, String>{
    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
    }

    @Override
    protected void onCancelled() {
      super.onCancelled();
    }

    @Override
    protected void onCancelled(String s) {
      super.onCancelled(s);
    }

    @Override
    protected String doInBackground(Void... params) {
      HttpURLConnection urlConnection = null;
      BufferedReader reader = null;
      String currencyJSONStr = null;
      try {
        String fromSpinner = spinner.getSelectedItem().toString();
        //https://openexchangerates.org/api/convert/19999.95/GBP/EUR?app_id=YOUR_APP_APP_ID
        String urlString = getResources().getString(R.string.API_STRING) + userInput + "/" + getCurrencyKey() + "/" + getCurrencyKey()  + "/?app+id=" + getString(R.string.API_KEY);
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

      } catch (IOException e){

      }
      return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
      super.onProgressUpdate(values);
    }
  }

  public  String getCurrencyKey(String currencyName){
    Map<String, String> currencyKey = new HashMap<String, String>();
    currencyKey.put("United Arab Emirates Dirham","AED");
    currencyKey.put("Afghan Afghani","AFN");
    currencyKey.put("Albanian Lek","ALL");
    currencyKey.put("Armenian Dram","AMD");
    currencyKey.put("Netherlands Antillean Guilder","ANG");
    currencyKey.put("Angolan Kwanza","AOA");
    currencyKey.put("Argentine Peso","ARS");
    currencyKey.put("Australian Dollar","AUD");
    currencyKey.put("Aruban Florin","AWG");
    currencyKey.put("Azerbaijani Manat","AZN");
    currencyKey.put("Bosnia-Herzegovina Convertible Mark","BAM");
    currencyKey.put("Barbadian Dollar","BBD");
    currencyKey.put("Bangladeshi Taka","BDT");
    currencyKey.put("Bulgarian Lev","BGN");
    currencyKey.put("Bahraini Dinar","BHD");
    currencyKey.put("Burundian Franc","BIF");
    currencyKey.put("Bermudan Dollar","BMD");
    currencyKey.put("Brunei Dollar","BND");
    currencyKey.put("Bolivian Boliviano","BOB");
    currencyKey.put("Brazilian Real","BRL");
    currencyKey.put("Bahamian Dollar","BSD");
    currencyKey.put("Bitcoin","BTC");
    currencyKey.put("Bhutanese Ngultrum","BTN");
    currencyKey.put("Botswanan Pula","BWP");
    currencyKey.put("Belarusian Ruble","BYN");
    currencyKey.put("Belarusian Ruble (pre-2016)","BYR");
    currencyKey.put("Belize Dollar","BZD");
    currencyKey.put("Canadian Dollar","CAD");
    currencyKey.put("Congolese Franc","CDF");
    currencyKey.put("Swiss Franc","CHF");
    currencyKey.put("Chilean Unit of Account (UF)","CLF");
    currencyKey.put("Chilean Peso","CLP");
    currencyKey.put("Chinese Yuan","CNY");
    currencyKey.put("Colombian Peso","COP");
    currencyKey.put("Costa Rican Colón","CRC");
    currencyKey.put("Cuban Convertible Peso","CUC");
    currencyKey.put("Cuban Peso","CUP");
    currencyKey.put("Cape Verdean Escudo","CVE");
    currencyKey.put("Czech Republic Koruna","CZK");
    currencyKey.put("Djiboutian Franc","DJF");
    currencyKey.put("Danish Krone","DKK");
    currencyKey.put("Dominican Peso","DOP");
    currencyKey.put("Algerian Dinar","DZD");
    currencyKey.put("Estonian Kroon","EEK");
    currencyKey.put("Egyptian Pound","EGP");
    currencyKey.put("Eritrean Nakfa","ERN");
    currencyKey.put("Ethiopian Birr","ETB");
    currencyKey.put("Euro","EUR");
    currencyKey.put("Fijian Dollar","FJD");
    currencyKey.put("Falkland Islands Pound","FKP");
    currencyKey.put("British Pound Sterling","GBP");
    currencyKey.put("Georgian Lari","GEL");
    currencyKey.put("Guernsey Pound","GGP");
    currencyKey.put("Ghanaian Cedi","GHS");
    currencyKey.put("Gibraltar Pound","GIP");
    currencyKey.put("Gambian Dalasi","GMD");
    currencyKey.put("Guinean Franc","GNF");
    currencyKey.put("Guatemalan Quetzal","GTQ");
    currencyKey.put("Guyanaese Dollar","GYD");
    currencyKey.put("Hong Kong Dollar","HKD");
    currencyKey.put("Honduran Lempira","HNL");
    currencyKey.put("Croatian Kuna","HRK");
    currencyKey.put("Haitian Gourde","HTG");
    currencyKey.put("Hungarian Forint","HUF");
    currencyKey.put("Indonesian Rupiah","IDR");
    currencyKey.put("Israeli New Sheqel","ILS");
    currencyKey.put("Manx pound","IMP");
    currencyKey.put("Indian Rupee","INR");
    currencyKey.put("Iraqi Dinar","IQD");
    currencyKey.put("Iranian Rial","IRR");
    currencyKey.put("Icelandic Króna","ISK");
    currencyKey.put("Jersey Pound","JEP");
    currencyKey.put("Jamaican Dollar","JMD");
    currencyKey.put("Jordanian Dinar","JOD");
    currencyKey.put("Japanese Yen","JPY");
    currencyKey.put("Kenyan Shilling","KES");
    currencyKey.put("Kyrgystani Som","KGS");
    currencyKey.put("Cambodian Riel","KHR");
    currencyKey.put("Comorian Franc","KMF");
    currencyKey.put("North Korean Won","KPW");
    currencyKey.put("South Korean Won","KRW");
    currencyKey.put("Kuwaiti Dinar","KWD");
    currencyKey.put("Cayman Islands Dollar","KYD");
    currencyKey.put("Kazakhstani Tenge","KZT");
    currencyKey.put("Laotian Kip","LAK");
    currencyKey.put("Lebanese Pound","LBP");
    currencyKey.put("Sri Lankan Rupee","LKR");
    currencyKey.put("Liberian Dollar","LRD");
    currencyKey.put("Lesotho Loti","LSL");
    currencyKey.put("Lithuanian Litas","LTL");
    currencyKey.put("Latvian Lats","LVL");
    currencyKey.put("Libyan Dinar","LYD");
    currencyKey.put("Moroccan Dirham","MAD");
    currencyKey.put("Moldovan Leu","MDL");
    currencyKey.put("Malagasy Ariary","MGA");
    currencyKey.put("Macedonian Denar","MKD");
    currencyKey.put("Myanma Kyat","MMK");
    currencyKey.put("Mongolian Tugrik","MNT");
    currencyKey.put("Macanese Pataca","MOP");
    currencyKey.put("Mauritanian Ouguiya","MRO");
    currencyKey.put("Maltese Lira","MTL");
    currencyKey.put("Mauritian Rupee","MUR");
    currencyKey.put("Maldivian Rufiyaa","MVR");
    currencyKey.put("Malawian Kwacha","MWK");
    currencyKey.put("Mexican Peso","MXN");
    currencyKey.put("Malaysian Ringgit","MYR");
    currencyKey.put("Mozambican Metical","MZN");
    currencyKey.put("Namibian Dollar","NAD");
    currencyKey.put("Nigerian Naira","NGN");
    currencyKey.put("Nicaraguan Córdoba","NIO");
    currencyKey.put("Norwegian Krone","NOK");
    currencyKey.put("Nepalese Rupee","NPR");
    currencyKey.put("New Zealand Dollar","NZD");
    currencyKey.put("Omani Rial","OMR");
    currencyKey.put("Panamanian Balboa","PAB");
    currencyKey.put("Peruvian Nuevo Sol","PEN");
    currencyKey.put("Papua New Guinean Kina","PGK");
    currencyKey.put("Philippine Peso","PHP");
    currencyKey.put("Pakistani Rupee","PKR");
    currencyKey.put("Polish Zloty","PLN");
    currencyKey.put("Paraguayan Guarani","PYG");
    currencyKey.put("Qatari Rial","QAR");
    currencyKey.put("Romanian Leu","RON");
    currencyKey.put("Serbian Dinar","RSD");
    currencyKey.put("Russian Ruble","RUB");
    currencyKey.put("Rwandan Franc","RWF");
    currencyKey.put("Saudi Riyal","SAR");
    currencyKey.put("Solomon Islands Dollar","SBD");
    currencyKey.put("Seychellois Rupee","SCR");
    currencyKey.put("Sudanese Pound","SDG");
    currencyKey.put("Swedish Krona","SEK");
    currencyKey.put("Singapore Dollar","SGD");
    currencyKey.put("Saint Helena Pound","SHP");
    currencyKey.put("Sierra Leonean Leone","SLL");
    currencyKey.put("Somali Shilling","SOS");
    currencyKey.put("Surinamese Dollar","SRD");
    currencyKey.put("São Tomé and Príncipe Dobra","STD");
    currencyKey.put("Salvadoran Colón","SVC");
    currencyKey.put("Syrian Pound","SYP");
    currencyKey.put("Swazi Lilangeni","SZL");
    currencyKey.put("Thai Baht","THB");
    currencyKey.put("Tajikistani Somoni","TJS");
    currencyKey.put("Turkmenistani Manat","TMT");
    currencyKey.put("Tunisian Dinar","TND");
    currencyKey.put("Tongan Pa?anga","TOP");
    currencyKey.put("Turkish Lira","TRY");
    currencyKey.put("Trinidad and Tobago Dollar","TTD");
    currencyKey.put("New Taiwan Dollar","TWD");
    currencyKey.put("Tanzanian Shilling","TZS");
    currencyKey.put("Ukrainian Hryvnia","UAH");
    currencyKey.put("Ugandan Shilling","UGX");
    currencyKey.put("United States Dollar","USD");
    currencyKey.put("Uruguayan Peso","UYU");
    currencyKey.put("Uzbekistan Som","UZS");
    currencyKey.put("Venezuelan Bolívar Fuerte","VEF");
    currencyKey.put("Vietnamese Dong","VND");
    currencyKey.put("Vanuatu Vatu","VUV");
    currencyKey.put("Samoan Tala","WST");
    currencyKey.put("CFA Franc BEAC","XAF");
    currencyKey.put("Silver Ounce","XAG");
    currencyKey.put("Gold Ounce","XAU");
    currencyKey.put("East Caribbean Dollar","XCD");
    currencyKey.put("Special Drawing Rights","XDR");
    currencyKey.put("CFA Franc BCEAO","XOF");
    currencyKey.put("Palladium Ounce","XPD");
    currencyKey.put("CFP Franc","XPF");
    currencyKey.put("Platinum Ounce","XPT");
    currencyKey.put("Yemeni Rial","YER");
    currencyKey.put("South African Rand","ZAR");
    currencyKey.put("Zambian Kwacha (pre-2013)","ZMK");
    currencyKey.put("Zambian Kwacha","ZMW");
    currencyKey.put("Zimbabwean Dollar","ZWL");

    return currencyKey.get(currencyName);
  }
}
