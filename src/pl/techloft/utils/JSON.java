package pl.techloft.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSON {

    static InputStream is = null;
    static JSONArray jObj = null;
    static String json = "";

    public JSON() {}

    public JSONObject[] getJSONFromUrl(String url) {
        try {

        	URL url1 = new URL(url);
        	HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();

            is = urlConnection.getInputStream();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();

        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        JSONObject data[] = null;

        try {

        	if(!json.contains("no data")){
        	    jObj = new JSONArray(json);

        	}else{
        		return null;
        	}

            data = new JSONObject[jObj.length()];

            for(int i=0; i < jObj.length(); i++) {
                data[i] = jObj.getJSONObject(i);
                }

        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return data;

    }


    public String sendData(String url){

    	  try {

    		Log.e("Link", url);

          	URL url1 = new URL(url);
          	HttpURLConnection urlConnection = (HttpURLConnection) url1.openConnection();

              is = urlConnection.getInputStream();

          } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }

          try {
              BufferedReader reader = new BufferedReader(new InputStreamReader(
                      is, "iso-8859-1"), 8);
              StringBuilder sb = new StringBuilder();
              String line = null;
              while ((line = reader.readLine()) != null) {
                  sb.append(line + "\n");
              }
              is.close();
              json = sb.toString();

          } catch (Exception e) {
              Log.e("Buffer Error", "Error converting result " + e.toString());
          }

          // try parse the string to a JSON object

    	return json;
    }


}