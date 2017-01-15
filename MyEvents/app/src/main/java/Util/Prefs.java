package Util;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by edima on 2016-07-04.
 */

//Gives users the ability to change their city
public class Prefs {

    SharedPreferences preferences;

    public Prefs (Activity activity){
        preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public void setCity(String city){
        preferences.edit().putString("city",city).commit();
    }

    //fi user has not chosen a city return default
    public String getCity(){
        return preferences.getString("city","Toronto");
    }
}
