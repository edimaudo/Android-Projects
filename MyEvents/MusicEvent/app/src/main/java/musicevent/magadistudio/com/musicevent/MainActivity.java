package musicevent.magadistudio.com.musicevent;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Util.Prefs;
import data.CustomListviewAdapter;
import model.Event;


public class MainActivity extends ActionBarActivity {

    private CustomListviewAdapter adapter;
    private ArrayList<Event> events = new ArrayList<>();
    private String urlLeft = "http://ws.audioscrobbler.com/2.0/?method=geo.getevents&location=";
    private String urlRight = "&api_key=78769e93e4d6f4576ee0a1cc572f84dc&format=json";
    private ListView listView;
    private TextView selectedCity;
    private ProgressDialog pDialog;


    private String url ="http://ws.audioscrobbler.com/2.0/?method=geo.getevents&location=spokane&api_key=78769e93e4d6f4576ee0a1cc572f84dc&format=json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListviewAdapter(MainActivity.this, R.layout.list_row, events);
        listView.setAdapter(adapter);


        Prefs prefs = new Prefs(MainActivity.this);
        String city = prefs.getCity();


        selectedCity = (TextView) findViewById(R.id.selectedLocationText);

        selectedCity.setText("Selected city: " + city);


        showEvents(city);



        
    }

    private void getEvents(String city) {

        //clear data first
        events.clear();

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        String finalUrl = urlLeft+city+urlRight;

        JsonObjectRequest eventsRequest = new JsonObjectRequest(Request.Method.GET,
                finalUrl, (JSONObject)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                hidePDialog();

                try {
                    JSONObject eventsObject = response.getJSONObject("events");

                    JSONArray eventsArray = eventsObject.getJSONArray("event");

                    for (int i = 0; i < eventsArray.length(); i++) {
                        JSONObject jsonObject = eventsArray.getJSONObject(i);

                        //Get artist object
                        JSONObject artistObject = jsonObject.getJSONObject("artists");
                        String headlinterText = artistObject.getString("headliner");

                        //Venue Object
                        JSONObject venueObject = jsonObject.getJSONObject("venue");
                        String venueName = venueObject.getString("name");


                        //Location object
                        JSONObject locationObject = venueObject.getJSONObject("location");
                        String city = locationObject.getString("city");
                        String country = locationObject.getString("country");
                        String street = locationObject.getString("street");
                        String postalCode = locationObject.getString("postalcode");


                        //Get url image
                        JSONArray imageArray = jsonObject.getJSONArray("image");


                        //Get image
                        JSONObject largeImage = imageArray.getJSONObject(3);

                        //Get actual image url
                        String image = largeImage.getString("#text");


                        //Get started date
                        String startDate = jsonObject.getString("startDate");


                        //Get website url
                        String website = jsonObject.getString("website");


                        Event event = new Event();

                        event.setHeadLiner(headlinterText);
                        event.setVenueName(venueName);
                        event.setCity(city);
                        event.setCountry(country);
                        event.setStreet(street);
                        event.setUrl(image);
                        event.setStartDate(startDate);
                        event.setWebsite(website);


                        events.add(event);




                        Log.v("Headliner: " , headlinterText);

                    }

                    adapter.notifyDataSetChanged();








                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                hidePDialog();

            }
        });

        AppController.getInstance().addToRequestQueue(eventsRequest);


    }























    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.change_locationId) {

            showInputDialog();

        }

        return super.onOptionsItemSelected(item);
    }


    private void showInputDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Change City");

        final EditText cityInput = new EditText(MainActivity.this);
        cityInput.setInputType(InputType.TYPE_CLASS_TEXT);
        cityInput.setHint("Portland");
        builder.setView(cityInput);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Prefs cityPreference = new Prefs(MainActivity.this);
                cityPreference.setCity(cityInput.getText().toString());

                String newCity = cityPreference.getCity();


                selectedCity.setText("Selected city: " + newCity);


                //re-render everything again
                showEvents(newCity);

            }
        });
        builder.show();




    }

    private void showEvents(String newCity) {
        getEvents(newCity);
    }


    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
