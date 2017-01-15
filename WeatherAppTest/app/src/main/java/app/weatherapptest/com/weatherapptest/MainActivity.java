package app.weatherapptest.com.weatherapptest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

import data.CityPreference;
import data.JSONWeatherParser;
import data.WeatherHttpClient;
import model.Weather;
import util.Utils;


public class MainActivity extends ActionBarActivity {
    private TextView cityName;
    private ImageView iconView;
    private TextView temp;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView sunrise;
    private TextView sunset;
    private TextView updated;
    private String city;


    Weather weather = new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = "San Francisco,US"; //default

       // progressDialog = new ProgressDialog(MainActivity.this);



        cityName = (TextView) findViewById(R.id.cityText);
        iconView = (ImageView) findViewById(R.id.thumbnailIcon);
        temp = (TextView) findViewById(R.id.tempText);
        description = (TextView) findViewById(R.id.cloudText);
        humidity = (TextView) findViewById(R.id.humidText);
        pressure = (TextView) findViewById(R.id.pressureText);
        wind = (TextView) findViewById(R.id.windText);
        sunrise = (TextView) findViewById(R.id.riseText);
        sunset = (TextView) findViewById(R.id.setText);
        updated = (TextView) findViewById(R.id.updateText);

       // showProgress();


        CityPreference cityPreference = new CityPreference(MainActivity.this);
        renderWeatherData(cityPreference.getCity());



    }

    public void renderWeatherData( String city) {

        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(new String[]{city + "&units=metric" });

        //hideProgress();

    }


private class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    /**
     * Got this better solution from: http://javatechig.com/android/download-image-using-asynctask-in-android
     *
     */
    @Override
    protected Bitmap doInBackground(String... params) {
        return downloadImage(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
       // super.onPostExecute(bitmap);
        iconView.setImageBitmap(bitmap);
        iconView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private Bitmap downloadImage(String code) {
        // initilize the default HTTP client object
        final DefaultHttpClient client = new DefaultHttpClient();


        //forming a HttoGet request
        final HttpGet getRequest = new HttpGet(Utils.ICON_URL + code + ".png");
        try {

            HttpResponse response = client.execute(getRequest);

            //check 200 OK for success
            final int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode +
                        " while retrieving bitmap from " + Utils.ICON_URL + code + ".png");
                return null;

            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    // getting contents from the stream
                    inputStream = entity.getContent();

                    // decoding stream data back into image Bitmap that android understands
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (Exception e) {
            // You Could provide a more explicit error message for IOException
            getRequest.abort();
            Log.e("ImageDownloader", "Something went wrong while" +
                    " retrieving bitmap from " + Utils.ICON_URL + e.toString());
        }

        return null;
    }
}

    private class WeatherTask extends AsyncTask<String, Void, Weather> {
        @Override
        protected Weather doInBackground(String... params) {


            String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);

                //Retrive the icon
                weather.iconData = weather.currentCondition.getIcon();//( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));
               // weather.iconData = ( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));
                Log.v("ICON DATA VALUE IS: ", String.valueOf(weather.currentCondition.getIcon()));

                //We call our ImageDownload task after the weather.iconData is set!
                new DownloadImageAsyncTask().execute(weather.iconData);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weather;
        }



        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            DateFormat df = DateFormat.getTimeInstance();

            String sunriseDate = df.format(new Date(weather.place.getSunrise()));
            String sunsetDate = df.format(new Date(weather.place.getSunset()));
            DecimalFormat decimalFormat = new DecimalFormat("#.#");

            String updateD = df.format(new Date(weather.place.getLastupdate()));

            String tempFormat = decimalFormat.format(weather.currentCondition.getTemperature());

            cityName.setText(weather.place.getCity() + "," + weather.place.getCountry());
            temp.setText("" + tempFormat + "°C");
            humidity.setText("Humidity: " + weather.currentCondition.getHumidity() + "%");
            pressure.setText("Pressure: " + weather.currentCondition.getPressure() + "hPa");
            wind.setText("Wind: " + weather.wind.getSpeed() + "mps");
            sunrise.setText("Sunrise : " + sunriseDate);
            sunset.setText("Sunset: " + sunsetDate  );
            updated.setText("Last Updated: " + updateD );
            description.setText("Condition: " + weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescription() + ")");


            Log.v("TEMPERATURE:", String.valueOf(weather.currentCondition.getTemperature()));
            Log.v("TEST: " , sunriseDate);
        }
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
        if (id == R.id.change_cityId) {

            showInputDialog();

        }

        return super.onOptionsItemSelected(item);
    }



    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Change City");

        final EditText cityInput = new EditText(MainActivity.this);
        cityInput.setInputType(InputType.TYPE_CLASS_TEXT);
        cityInput.setHint("Portland,US");
        builder.setView(cityInput);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CityPreference cityPreference = new CityPreference(MainActivity.this);
                cityPreference.setCity(cityInput.getText().toString());

                String newCity = cityPreference.getCity();





                //new CityPreference(MainActivity.this).setCity(cityInput.getText().toString());

                //re-render everything again
                renderWeatherData(newCity);
            }
        });
        builder.show();
    }


}
