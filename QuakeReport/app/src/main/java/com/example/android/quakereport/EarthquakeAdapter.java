package com.example.android.quakereport;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


  public EarthquakeAdapter(Context context, ArrayList<Earthquake> words) {
    super(context, 0, words);

  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View listItemView = convertView;
    if(listItemView == null) {
      listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }

    Earthquake currentEarthquake = getItem(position);

    TextView magnitudeText = (TextView) listItemView.findViewById(R.id.magnitudeText);
    // Format the magnitude to show 1 decimal place
    String formattedMagnitude = formatMagnitude(currentEarthquake.getmMagnitude());
    // Display the magnitude of the current earthquake in that TextView
    magnitudeText.setText(formattedMagnitude);

    // Fetch the background from the TextView, which is a GradientDrawable.
    GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();

    // Get the appropriate background color based on the current earthquake magnitude
    int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

    // Set the color on the magnitude circle
    magnitudeCircle.setColor(magnitudeColor);



    String locationInfo = currentEarthquake.getMlocation();
    int locationPosition = locationInfo.indexOf("of");

    String locationDataText = "";
    String locationText = "";
    if(locationPosition == -1){
      locationDataText = "Near the";
      locationText = locationInfo;
    } else {
      locationDataText = locationInfo.substring(0,locationPosition);
      locationText = locationInfo.substring(locationPosition+2);
    }

    TextView locationDataView = (TextView) listItemView.findViewById(R.id.locationDataText);
    locationDataView.setText(locationDataText);

    TextView locationView = (TextView) listItemView.findViewById(R.id.locationText);
    locationView.setText(locationText);

    Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

    // Find the TextView with view ID date
    TextView dateView = (TextView) listItemView.findViewById(R.id.dateText);
    // Format the date string (i.e. "Mar 3, 1984")
    String formattedDate = formatDate(dateObject);
    // Display the date of the current earthquake in that TextView
    dateView.setText(formattedDate);

    // Find the TextView with view ID time
    TextView timeView = (TextView) listItemView.findViewById(R.id.time);
    // Format the time string (i.e. "4:30PM")
    String formattedTime = formatTime(dateObject);
    // Display the time of the current earthquake in that TextView
    timeView.setText(formattedTime);

    return listItemView;
    //return super.getView(position, convertView, parent);
  }

  /**
   * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
   */
  private String formatDate(Date dateObject) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
    return dateFormat.format(dateObject);
  }

  /**
   * Return the formatted date string (i.e. "4:30 PM") from a Date object.
   */
  private String formatTime(Date dateObject) {
    SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
    return timeFormat.format(dateObject);
  }

  private String formatMagnitude(double magnitude) {
    DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
    return magnitudeFormat.format(magnitude);
  }

  private int getMagnitudeColor(Double magnitude){
    int magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
    if (magnitude >=0  && magnitude <2 ){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
    } else if (magnitude >=2 && magnitude < 3){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
    } else if (magnitude >=3 && magnitude < 4){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
    } else if (magnitude >=4 && magnitude < 5){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
    } else if (magnitude >=5 && magnitude < 6){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
    } else if (magnitude >=6 && magnitude < 7){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
    } else if (magnitude >=7 && magnitude < 8){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
    } else if (magnitude >=8 && magnitude < 9){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
    } else if (magnitude >=9 && magnitude <= 10){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
    } else if (magnitude > 10){
      magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
    }


    return magnitudeColor;
  }
}
