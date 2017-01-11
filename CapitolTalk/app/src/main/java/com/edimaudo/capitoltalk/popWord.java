package com.edimaudo.capitoltalk;

import android.app.SearchManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class popWord extends AppCompatActivity {

  static final String API_KEY = "USE_YOUR_OWN_API_KEY";
  static final String API_URL = "https://api.fullcontact.com/v2/person.json?";
  ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pop_word);

    SearchView searchView = (SearchView) findViewById(R.id.search);
    SearchManager searchManager =
            (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

    searchView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

      }
    });

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        //searchFor(query);
        //Intent intent = getIntent();
        //if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
        //  String query = intent.getStringExtra(SearchManager.QUERY);
        //  doMySearch(query);
        //}
        new RetrieveFeedTask().execute();
        return true;
      }

      @Override
      public boolean onQueryTextChange(String query) {
        //filterSearchFor(query);
        return true;
      }
    });
  }

  class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

    private Exception exception;

    protected void onPreExecute() {
      progressBar.setVisibility(View.VISIBLE);
      //responseView.setText("");
    }

    protected String doInBackground(Void... urls) {
      //String email = emailText.getText().toString();
      // Do some validation here

      try {
        URL url = new URL(API_URL  + "&apiKey=" + API_KEY);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
          StringBuilder stringBuilder = new StringBuilder();
          String line;
          while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
          }
          bufferedReader.close();
          return stringBuilder.toString();
        }
        finally{
          urlConnection.disconnect();
        }
      }
      catch(Exception e) {
        Log.e("ERROR", e.getMessage(), e);
        return null;
      }
    }

    protected void onPostExecute(String response) {
      if(response == null) {
        response = "THERE WAS AN ERROR";
      }
      progressBar.setVisibility(View.GONE);
      Log.i("INFO", response);
      //responseView.setText(response);
      // TODO: check this.exception
      // TODO: do something with the feed

//            try {
//                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
//                String requestID = object.getString("requestId");
//                int likelihood = object.getInt("likelihood");
//                JSONArray photos = object.getJSONArray("photos");
//                .
//                .
//                .
//                .
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
    }
  }
}
