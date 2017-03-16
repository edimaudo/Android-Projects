package com.edimaudo.currencyconverter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.edimaudo.currencyconverter.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

  private EditText userInput;
  private Spinner spinner, spinner2;
  private TextView textView3;
  private Button convert;
  private CoordinatorLayout coordinatorLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(activity_main);

    userInput = (EditText) findViewById(R.id.userInput);
    spinner = (Spinner) findViewById(R.id.spinner);
    spinner2 = (Spinner) findViewById(R.id.spinner2);
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

    String fromSpinner = getCurrencyKey(spinner.getSelectedItem().toString());
    String toSpinner = getCurrencyKey(spinner2.getSelectedItem().toString());

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
      textView3.setText(s);
      
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

        //http://apilayer.net/api/convert? access_key = YOUR_ACCESS_KEY& from = USD& to = GBP& amount = 10

        //String urlString = getResources().getString(R.string.API_STRING) + userInput +
        //        "/" + fromSpinner + "/" + toSpinner  + "/?app+id=" + getString(R.string.API_KEY);

        //String urlString = getResources().getString(R.string.API_STRING) + getString(R.string.API_KEY)
        //        + "&from=" + fromSpinner + "&to=" + toSpinner + "&amount=" + userInput;

        //https://www.google.com/finance/converter?a=1&from=AED&to=ALL
        String urlString = "https://www.google.com/finance/converter?a=" + userInput + "&from="
                + toSpinner + "&to=" + fromSpinner;
        Log.e("output",urlString);
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer buffer = new StringBuffer();
        if (inputStream == null){
          return null;
        }

        reader = new BufferedReader((new InputStreamReader(inputStream)));
        String line;
        while((line = reader.readLine()) != null){
          buffer.append(line);
        }

        if (buffer.length() == 0){
          return null;
        }

        currencyJSONStr = buffer.toString();
        return currencyJSONStr;

      } catch (IOException e){
        return null;

      } finally {
        urlConnection.disconnect();
        if (reader != null) {
          try {
            reader.close();
          } catch (final IOException e) {
            Log.e("Error check", "Error closing stream", e);
          }
        }
      }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
      super.onProgressUpdate(values);
    }
  }

  public  String getCurrencyKey(String currencyName){
    Map<String, String> currencyKey = new HashMap<String, String>();

    currencyKey.put("United Arab Emirates Dirham","AED");
    currencyKey.put("Afghan Afghani (AFN)","AFN");
    currencyKey.put("Albanian Lek (ALL)","ALL");
    currencyKey.put("Armenian Dram (AMD)","AMD");
    currencyKey.put("Netherlands Antillean Guilder (ANG)","ANG");
    currencyKey.put("Angolan Kwanza (AOA)","AOA");
    currencyKey.put("Argentine Peso (ARS)","ARS");
    currencyKey.put("Australian Dollar (A$)","AUD");
    currencyKey.put("Aruban Florin (AWG)","AWG");
    currencyKey.put("Azerbaijani Manat (AZN)","AZN");
    currencyKey.put("Bosnia-Herzegovina Convertible Mark (BAM)","BAM");
    currencyKey.put("Barbadian Dollar (BBD)","BBD");
    currencyKey.put("Bangladeshi Taka (BDT)","BDT");
    currencyKey.put("Bulgarian Lev (BGN)","BGN");
    currencyKey.put("Bahraini Dinar (BHD)","BHD");
    currencyKey.put("Burundian Franc (BIF)","BIF");
    currencyKey.put("Bermudan Dollar (BMD)","BMD");
    currencyKey.put("Brunei Dollar (BND)","BND");
    currencyKey.put("Bolivian Boliviano (BOB)","BOB");
    currencyKey.put("Brazilian Real (R$)","BRL");
    currencyKey.put("Bahamian Dollar (BSD)","BSD");
    currencyKey.put("Bitcoin (฿)","BTC");
    currencyKey.put("Bhutanese Ngultrum (BTN)","BTN");
    currencyKey.put("Botswanan Pula (BWP)","BWP");
    currencyKey.put("Belarusian Ruble (BYN)","BYN");
    currencyKey.put("Belarusian Ruble (2000-2016) (BYR)","BYR");
    currencyKey.put("Belize Dollar (BZD)","BZD");
    currencyKey.put("Canadian Dollar (CA$)","CAD");
    currencyKey.put("Congolese Franc (CDF)","CDF");
    currencyKey.put("Swiss Franc (CHF)","CHF");
    currencyKey.put("Chilean Unit of Account (UF) (CLF)","CLF");
    currencyKey.put("Chilean Peso (CLP)","CLP");
    currencyKey.put("CNH (CNH)","CNH");
    currencyKey.put("Chinese Yuan (CN¥)","CNY");
    currencyKey.put("Colombian Peso (COP)","COP");
    currencyKey.put("Costa Rican Colón (CRC)","CRC");
    currencyKey.put("Cuban Peso (CUP)","CUP");
    currencyKey.put("Cape Verdean Escudo (CVE)","CVE");
    currencyKey.put("Czech Republic Koruna (CZK)","CZK");
    currencyKey.put("German Mark (DEM)","DEM");
    currencyKey.put("Djiboutian Franc (DJF)","DJF");
    currencyKey.put("Danish Krone (DKK)","DKK");
    currencyKey.put("Dominican Peso (DOP)","DOP");
    currencyKey.put("Algerian Dinar (DZD)","DZD");
    currencyKey.put("Egyptian Pound (EGP)","EGP");
    currencyKey.put("Eritrean Nakfa (ERN)","ERN");
    currencyKey.put("Ethiopian Birr (ETB)","ETB");
    currencyKey.put("Euro (€)","EUR");
    currencyKey.put("Finnish Markka (FIM)","FIM");
    currencyKey.put("Fijian Dollar (FJD)","FJD");
    currencyKey.put("Falkland Islands Pound (FKP)","FKP");
    currencyKey.put("French Franc (FRF)","FRF");
    currencyKey.put("British Pound (£)","GBP");
    currencyKey.put("Georgian Lari (GEL)","GEL");
    currencyKey.put("Ghanaian Cedi (GHS)","GHS");
    currencyKey.put("Gibraltar Pound (GIP)","GIP");
    currencyKey.put("Gambian Dalasi (GMD)","GMD");
    currencyKey.put("Guinean Franc (GNF)","GNF");
    currencyKey.put("Guatemalan Quetzal (GTQ)","GTQ");
    currencyKey.put("Guyanaese Dollar (GYD)","GYD");
    currencyKey.put("Hong Kong Dollar (HK$)","HKD");
    currencyKey.put("Honduran Lempira (HNL)","HNL");
    currencyKey.put("Croatian Kuna (HRK)","HRK");
    currencyKey.put("Haitian Gourde (HTG)","HTG");
    currencyKey.put("Hungarian Forint (HUF)","HUF");
    currencyKey.put("Indonesian Rupiah (IDR)","IDR");
    currencyKey.put("Irish Pound (IEP)","IEP");
    currencyKey.put("Israeli New Sheqel (₪)","ILS");
    currencyKey.put("Indian Rupee (₹)","INR");
    currencyKey.put("Iraqi Dinar (IQD)","IQD");
    currencyKey.put("Iranian Rial (IRR)","IRR");
    currencyKey.put("Icelandic Króna (ISK)","ISK");
    currencyKey.put("Italian Lira (ITL)","ITL");
    currencyKey.put("Jamaican Dollar (JMD)","JMD");
    currencyKey.put("Jordanian Dinar (JOD)","JOD");
    currencyKey.put("Japanese Yen (¥)","JPY");
    currencyKey.put("Kenyan Shilling (KES)","KES");
    currencyKey.put("Kyrgystani Som (KGS)","KGS");
    currencyKey.put("Cambodian Riel (KHR)","KHR");
    currencyKey.put("Comorian Franc (KMF)","KMF");
    currencyKey.put("North Korean Won (KPW)","KPW");
    currencyKey.put("South Korean Won (₩)","KRW");
    currencyKey.put("Kuwaiti Dinar (KWD)","KWD");
    currencyKey.put("Cayman Islands Dollar (KYD)","KYD");
    currencyKey.put("Kazakhstani Tenge (KZT)","KZT");
    currencyKey.put("Laotian Kip (LAK)","LAK");
    currencyKey.put("Lebanese Pound (LBP)","LBP");
    currencyKey.put("Sri Lankan Rupee (LKR)","LKR");
    currencyKey.put("Liberian Dollar (LRD)","LRD");
    currencyKey.put("Lesotho Loti (LSL)","LSL");
    currencyKey.put("Lithuanian Litas (LTL)","LTL");
    currencyKey.put("Latvian Lats (LVL)","LVL");
    currencyKey.put("Libyan Dinar (LYD)","LYD");
    currencyKey.put("Moroccan Dirham (MAD)","MAD");
    currencyKey.put("Moldovan Leu (MDL)","MDL");
    currencyKey.put("Malagasy Ariary (MGA)","MGA");
    currencyKey.put("Macedonian Denar (MKD)","MKD");
    currencyKey.put("Myanmar Kyat (MMK)","MMK");
    currencyKey.put("Mongolian Tugrik (MNT)","MNT");
    currencyKey.put("Macanese Pataca (MOP)","MOP");
    currencyKey.put("Mauritanian Ouguiya (MRO)","MRO");
    currencyKey.put("Mauritian Rupee (MUR)","MUR");
    currencyKey.put("Maldivian Rufiyaa (MVR)","MVR");
    currencyKey.put("Malawian Kwacha (MWK)","MWK");
    currencyKey.put("Mexican Peso (MX$)","MXN");
    currencyKey.put("Malaysian Ringgit (MYR)","MYR");
    currencyKey.put("Mozambican Metical (MZN)","MZN");
    currencyKey.put("Namibian Dollar (NAD)","NAD");
    currencyKey.put("Nigerian Naira (NGN)","NGN");
    currencyKey.put("Nicaraguan Córdoba (NIO)","NIO");
    currencyKey.put("Norwegian Krone (NOK)","NOK");
    currencyKey.put("Nepalese Rupee (NPR)","NPR");
    currencyKey.put("New Zealand Dollar (NZ$)","NZD");
    currencyKey.put("Omani Rial (OMR)","OMR");
    currencyKey.put("Panamanian Balboa (PAB)","PAB");
    currencyKey.put("Peruvian Nuevo Sol (PEN)","PEN");
    currencyKey.put("Papua New Guinean Kina (PGK)","PGK");
    currencyKey.put("Philippine Peso (PHP)","PHP");
    currencyKey.put("PKG (PKG)","PKG");
    currencyKey.put("Pakistani Rupee (PKR)","PKR");
    currencyKey.put("Polish Zloty (PLN)","PLN");
    currencyKey.put("Paraguayan Guarani (PYG)","PYG");
    currencyKey.put("Qatari Rial (QAR)","QAR");
    currencyKey.put("Romanian Leu (RON)","RON");
    currencyKey.put("Serbian Dinar (RSD)","RSD");
    currencyKey.put("Russian Ruble (RUB)","RUB");
    currencyKey.put("Rwandan Franc (RWF)","RWF");
    currencyKey.put("Saudi Riyal (SAR)","SAR");
    currencyKey.put("Solomon Islands Dollar (SBD)","SBD");
    currencyKey.put("Seychellois Rupee (SCR)","SCR");
    currencyKey.put("Sudanese Pound (SDG)","SDG");
    currencyKey.put("Swedish Krona (SEK)","SEK");
    currencyKey.put("Singapore Dollar (SGD)","SGD");
    currencyKey.put("St. Helena Pound (SHP)","SHP");
    currencyKey.put("Slovak Koruna (SKK)","SKK");
    currencyKey.put("Sierra Leonean Leone (SLL)","SLL");
    currencyKey.put("Somali Shilling (SOS)","SOS");
    currencyKey.put("Surinamese Dollar (SRD)","SRD");
    currencyKey.put("São Tomé &amp; Príncipe Dobra (STD)","STD");
    currencyKey.put("Salvadoran Colón (SVC)","SVC");
    currencyKey.put("Syrian Pound (SYP)","SYP");
    currencyKey.put("Swazi Lilangeni (SZL)","SZL");
    currencyKey.put("Thai Baht (THB)","THB");
    currencyKey.put("Tajikistani Somoni (TJS)","TJS");
    currencyKey.put("Turkmenistani Manat (TMT)","TMT");
    currencyKey.put("Tunisian Dinar (TND)","TND");
    currencyKey.put("Tongan Paʻanga (TOP)","TOP");
    currencyKey.put("Turkish Lira (TRY)","TRY");
    currencyKey.put("Trinidad &amp; Tobago Dollar (TTD)","TTD");
    currencyKey.put("New Taiwan Dollar (NT$)","TWD");
    currencyKey.put("Tanzanian Shilling (TZS)","TZS");
    currencyKey.put("Ukrainian Hryvnia (UAH)","UAH");
    currencyKey.put("Ugandan Shilling (UGX)","UGX");
    currencyKey.put("US Dollar ($)","USD");
    currencyKey.put("Uruguayan Peso (UYU)","UYU");
    currencyKey.put("Uzbekistani Som (UZS)","UZS");
    currencyKey.put("Venezuelan Bolívar (VEF)","VEF");
    currencyKey.put("Vietnamese Dong (₫)","VND");
    currencyKey.put("Vanuatu Vatu (VUV)","VUV");
    currencyKey.put("Samoan Tala (WST)","WST");
    currencyKey.put("Central African CFA Franc (FCFA)","XAF");
    currencyKey.put("East Caribbean Dollar (EC$)","XCD");
    currencyKey.put("Special Drawing Rights (XDR)","XDR");
    currencyKey.put("West African CFA Franc (CFA)","XOF");
    currencyKey.put("CFP Franc (CFPF)","XPF");
    currencyKey.put("Yemeni Rial (YER)","YER");
    currencyKey.put("South African Rand (ZAR)","ZAR");
    currencyKey.put("Zambian Kwacha (1968–2012) (ZMK)","ZMK");
    currencyKey.put("Zambian Kwacha (ZMW)","ZMW");
    currencyKey.put("Zimbabwean Dollar (2009) (ZWL)","ZWL");

    return currencyKey.get(currencyName);
  }


}
