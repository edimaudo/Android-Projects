package com.edimaudo.whatsmyipaddress;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
  private Button ipButton;
  private TextView ipInfo;
  String IPaddress;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ipButton = (Button) findViewById(R.id.ipButton);
    ipInfo = (TextView) findViewById(R.id.ipInfo);

    ipButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getIpInfo();
      }
    });
  }

  public void getIpInfo(){

    boolean WIFI = false;
    boolean MOBILE = false;

    ConnectivityManager CM = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo[] networkInfo = CM.getAllNetworkInfo();

    for (NetworkInfo netInfo : networkInfo) {
      if (netInfo.getTypeName().equalsIgnoreCase("WIFI"))
        if (netInfo.isConnected())
          WIFI = true;
      if (netInfo.getTypeName().equalsIgnoreCase("MOBILE"))
        if (netInfo.isConnected())
          MOBILE = true;
    }

    if(WIFI == true) {
      IPaddress = GetDeviceipWiFiData();
      ipInfo.setText(IPaddress);

    }

    if(MOBILE == true) {
      IPaddress = GetDeviceipMobileData();
      ipInfo.setText(IPaddress);
    }


  }

  public String GetDeviceipMobileData(){
    try {
      for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
           en.hasMoreElements();) {
        NetworkInterface networkinterface = en.nextElement();
        for (Enumeration<InetAddress> enumIpAddr = networkinterface.getInetAddresses(); enumIpAddr.hasMoreElements();) {
          InetAddress inetAddress = enumIpAddr.nextElement();
          if (!inetAddress.isLoopbackAddress()) {
            return inetAddress.getHostAddress().toString();
          }
        }
      }
    } catch (Exception ex) {
      Log.e("Current IP", ex.toString());
    }
    return null;
  }

  public String GetDeviceipWiFiData() {
    WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
    @SuppressWarnings("deprecation")
    String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    return ip;

  }
}

