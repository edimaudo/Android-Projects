package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Place;
import model.Weather;
import util.Utils;

/**
 * Created by paulodichone on 3/11/15.
 */
public class JSONWeatherParser {

    public static Weather getWeather(String data) throws JSONException {
        Weather weather = new Weather();


        //create jsonObject from data
        JSONObject jsonObject = new JSONObject(data);


        //extract the info
        Place place = new Place();

        JSONObject coordObj = Utils.getObject("coord", jsonObject);
        place.setLat(Utils.getFloat("lat", coordObj));
        place.setLon(Utils.getFloat("lon", coordObj));


        //Get the sys obj
        JSONObject sysObj = Utils.getObject("sys", jsonObject);
        place.setCountry(Utils.getString("country", sysObj));
        place.setLastupdate(Utils.getInt("dt", jsonObject));
        place.setSunrise(Utils.getInt("sunrise", sysObj));
        place.setSunset(Utils.getInt("sunset", sysObj));
        place.setCity(Utils.getString("name", jsonObject));
        weather.place = place;

        //This is an array for weather info
        JSONArray jsonArray = jsonObject.getJSONArray("weather");

        //we could loop through the array, but we are just interested in getting the first index (0)
        JSONObject jsonWeather = jsonArray.getJSONObject(0);
        weather.currentCondition.setWeatherId(Utils.getInt("id", jsonWeather));
        weather.currentCondition.setDescription(Utils.getString("description", jsonWeather));
        weather.currentCondition.setCondition(Utils.getString("main", jsonWeather));
        weather.currentCondition.setIcon(Utils.getString("icon", jsonWeather));

        //Let's get the main object
        JSONObject mainObj = Utils.getObject("main", jsonObject);
        weather.currentCondition.setHumidity(Utils.getInt("humidity", mainObj));
        weather.currentCondition.setPressure(Utils.getInt("pressure", mainObj));
        weather.currentCondition.setMinTemperature(Utils.getFloat("temp_min", mainObj));
        weather.currentCondition.setMinTemperature(Utils.getFloat("temp_max", mainObj));
        weather.currentCondition.setTemperature(Utils.getDouble("temp", mainObj));


        //Let's setup wind
        JSONObject windObj = Utils.getObject("wind", jsonObject);
        weather.wind.setSpeed(Utils.getFloat("speed", windObj));
        weather.wind.setDeg(Utils.getFloat("deg", windObj));


        //Setup clouds
        JSONObject cloudObj = Utils.getObject("clouds", jsonObject);
        weather.clouds.setPercipitation(Utils.getInt("all", cloudObj));


        return weather;


    }
}
