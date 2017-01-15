package volleyappsetup.com.volleyapp;

import android.app.DownloadManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;


public class MainActivity extends ActionBarActivity {

    private TextView currency;
    private NetworkImageView networkImageView;
    private ImageView imageView;


    private String imageUrl = "http://i.imgur.com/7spzG.png";
    private String stringUrl = "http://magadistudio.com/complete-android-developer-course-source-files/string.html";
    private String url = "http://jsonplaceholder.typicode.com/posts";
    private String currencyUrl = "http://openexchangerates.org/api/latest.json?app_id=5ae9b6c1bb234f0aa42011b1b31d07fa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currency = (TextView) findViewById(R.id.currencyText);
        networkImageView = (NetworkImageView) findViewById(R.id.imageview);
        imageView = (ImageView) findViewById(R.id.myImageView);

        //getJsonArray(url);

       // getJsonObject(currencyUrl);
        //getStringObject(stringUrl);

        getImage(imageUrl);
        getImageOldWay(imageUrl);


    }


    private void getImageOldWay(String url) {

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

                imageView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void getImage(String url) {
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        networkImageView.setImageUrl(url, imageLoader);

    }

    private void getStringObject(String url) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.v("My response:", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest);

    }

    private void getJsonObject(String url) {

        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject ratesObject = response.getJSONObject("rates");
                    String currencyText = ratesObject.getString("RON");

                    currency.setText("RON: " + currencyText);


                    Log.v("CURRENCY", currencyText);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }
    private void getJsonArray(String url) {

        //url: http://jsonplaceholder.typicode.com/albums

        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String id = jsonObject.getString("id");
                        String body = jsonObject.getString("body");

                        Log.v("Title is: ", title +  "\n" +
                                "Id:" + id + "\n" + "body: " + body);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }



                //Log.v("Data from the web: " , response.toString());


            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

                VolleyLog.d("Mainactivity", error.getMessage());

            }
        });

        AppController.getInstance().addToRequestQueue(request);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
