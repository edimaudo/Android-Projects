package data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import util.Utils;

/**
 * Created by paulodichone on 3/11/15.
 */
public class WeatherHttpClient {


    private Bitmap bitmap;

    public String getWeatherData(String place) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;


        try {
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true); //Sets the flag indicating whether this {@code URLConnection} allows input
            connection.setDoOutput(true);
            connection.connect();

            //Read the response
            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null)
                stringBuffer.append(line + "\r\n");

            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {

            }

            connection.disconnect();
        }

        return null;
    }

    public static Bitmap getImage(String code) {

        HttpParams httpParams = new BasicHttpParams();

        HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
        HttpGet get = new HttpGet(Utils.ICON_URL + code + ".png");
        DefaultHttpClient client;

        client = new DefaultHttpClient(httpParams);
        HttpResponse response = null;
        try {
            response = client.execute(get);
            String network_response = response.getStatusLine().toString();
            HttpEntity responseEntity = response.getEntity();
            BufferedHttpEntity httpEntity = new BufferedHttpEntity(responseEntity);
            InputStream imageStream = httpEntity.getContent();

            return BitmapFactory.decodeStream(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
            Log.v("getBmpFromUrl error: ", e.getMessage().toString());
            return null;
        }

//        try {
////            URL url = new URL(Utils.ICON_URL + code +".png");
//            URL url = new URL("http://openweathermap.org/img/w/10n.png");
//            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//           connection.setDoInput(true);
//            connection.connect();
//            InputStream inputStream = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
//
//            Log.v("URL: ", String.valueOf(url));
//
//            return myBitmap;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e("getBmpFromUrl error: ", e.getMessage().toString());
//            return null;
//        }

    }
    //Get image/icon method
//    public byte[] getImage(String code) {
//
//        HttpURLConnection connection = null;
//        InputStream inputStream = null;
//
//        try {
//            connection = (HttpURLConnection) (new URL(Utils.ICON_URL + code )).openConnection();
//            connection.setRequestMethod("GET");
//            connection.setDoInput(true);
//            connection.setDoOutput(true);
//            connection.connect();
//
//            Log.v("INSIDER::", Utils.ICON_URL + code);
//
//
//            //Read the response
//            inputStream = connection.getInputStream();
//            byte[] buffer = new byte[1024]; //set the buffer size to 1024 ~ 1mb
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//           // byteArrayOutputStream.reset();
//
//            while (inputStream.read(buffer) != -1)
//                byteArrayOutputStream.write(buffer);
//
//            return byteArrayOutputStream.toByteArray();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//
//            }
//
//            connection.disconnect();
//        }
//        return  null;
//
//    }

//       // String urlString = code;
//        Bitmap img = null;
//
//        HttpClient client = new DefaultHttpClient();
//        HttpGet request = new HttpGet(Utils.ICON_URL + code);
//        HttpResponse response;
//
//        try {
//            response = (HttpResponse)client.execute(request);
//            HttpEntity entity = response.getEntity();
//            BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(entity);
//            InputStream inputStream = bufferedHttpEntity.getContent();
//            img = BitmapFactory.decodeStream(inputStream);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return img;


//        HttpURLConnection connection = null;
//        InputStream inputStream = null;
//
//        try {
//            connection = (HttpURLConnection) (new URL(Utils.ICON_URL + code)).openConnection();
//            connection.setRequestMethod("GET");
//            connection.setDoInput(true);
//            connection.setDoOutput(true);
//            connection.connect();
//
//
//            //Read the response
//            inputStream = connection.getInputStream();
//            byte[] buffer = new byte[1024]; //set the buffer size to 1024 ~ 1mb
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//            while (inputStream.read(buffer) != -1)
//                byteArrayOutputStream.write(buffer);
//
//            return byteArrayOutputStream.toByteArray();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//
//            }
//
//            connection.disconnect();
//        }
//        return  null;
//
//    }

}
