package pl.techloft.utils;


import org.json.JSONException;
import org.json.JSONObject;

import pl.techloft.IntroActivity;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class UpdateTask extends AsyncTask<String, String, String[][]> {

	private final String defURL = "http://projekt.techloft.pl/pomiechowek/api/";
    MySQL MySQL;

    JSON JSON;
   IntroActivity ac;

   public UpdateTask(IntroActivity i) {
	   ac  = i;
	   JSON = new JSON();
   }

    @Override
    protected void onPreExecute(){

	    if(isOnline()){
	    	ac.showProgress();
	    }

    }

    @Override
    protected void onPostExecute(String[][] data){

     if(data != null){
       ac.barProgressDialog.setMessage("Zapisuje dane");
       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ac);
 	   SharedPreferences.Editor editor = preferences.edit();
 	   editor.putString("mapheaderpl", data[0][0]);
 	   editor.putString("mapheaderen", data[0][1]);
 	   editor.putString("maptextpl", data[0][2]);
 	   editor.putString("maptexten", data[0][3]);
 	   editor.putString("gameheaderpl", data[1][0]);
 	   editor.putString("gameheaderen", data[1][1]);
 	   editor.putString("gametextpl", data[1][2]);
 	   editor.putString("gametexten", data[1][3]);
 	   editor.putString("riverheaderpl", data[2][0]);
 	   editor.putString("riverheaderen", data[2][1]);
 	   editor.putString("rivertextpl", data[2][2]);
 	   editor.putString("rivertexten", data[2][3]);
 	   editor.putString("forestheaderpl", data[3][0]);
 	   editor.putString("forestheaderen", data[3][1]);
 	   editor.putString("forsettextpl", data[3][2]);
 	   editor.putString("foresttexten", data[3][3]);
 	   editor.putString("golfheaderpl", data[4][0]);
 	   editor.putString("golfheaderen", data[4][1]);
 	   editor.putString("golftextpl", data[4][2]);
 	   editor.putString("golftexten", data[4][3]);
 	   editor.putString("plenerheaderpl", data[5][0]);
 	   editor.putString("plenerheaderen", data[5][1]);
 	   editor.putString("plenertextpl", data[5][2]);
 	   editor.putString("plenertexten", data[5][3]);
 	   editor.putString("lineheaderpl", data[6][0]);
 	   editor.putString("lineheaderen", data[6][1]);
 	   editor.putString("linetextpl", data[6][2]);
 	   editor.putString("linetexten", data[6][3]);
 	   editor.putString("nothingheaderpl", data[7][0]);
 	   editor.putString("nothingheaderen", data[7][1]);
 	   editor.putString("nothingtextpl", data[7][2]);
 	   editor.putString("nothingtexten", data[7][3]);
 	   editor.putString("roadheaderpl", data[9][0]);
 	   editor.putString("roadheaderen", data[9][1]);
 	   editor.putString("roadtextpl", data[9][2]);
 	   editor.putString("roadtexten", data[9][3]);
 	   editor.putString("winterheaderpl", data[10][0]);
 	   editor.putString("winterheaderen", data[10][1]);
 	   editor.putString("wintertextpl", data[10][2]);
 	   editor.putString("wintertexten", data[10][3]);
 	   editor.putString("monumentsheaderpl", data[8][0]);
 	   editor.putString("monumentsheaderen", data[8][1]);
 	   editor.putString("monumentstextpl", data[8][2]);
 	   editor.putString("monumentstexten", data[8][3]);
 	   editor.putString("infoheaderpl", data[11][0]);
 	   editor.putString("infoheaderen", data[11][1]);
 	   editor.putString("infotextpl", data[11][2]);
 	   editor.putString("infotexten", data[11][3]);
 	   editor.putString("version", data[14][0]);
 	   editor.commit();

 	   ac.barProgressDialog.setMessage("Zakoñczono pomyœlnie!");
 	   ac.barProgressDialog.dismiss();
     }

          if(isOnline()){
              ac.barProgressDialog.dismiss();
  	    }

      	   ac.showLang();




    }





	public boolean isOnline() {
	    ConnectivityManager cm = (ConnectivityManager) ac.getSystemService(Context.CONNECTIVITY_SERVICE);
	    return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
	}

	// id 3 - czeka rzeka,  "id":"1" - mapa



    @Override
	 protected void onProgressUpdate(final String ... progress) {

    	ac.barProgressDialog.setMessage(progress[0]);
	  //  ac.barProgressDialog.setProgress(10);
    }



	@Override
	protected String[][] doInBackground(String... params) {

	    if(!isOnline()){
	    	return null;
	    }

		JSONObject[] update = JSON.getJSONFromUrl(defURL + "/update/all/KjZkHweQdLvzNPweBZ7FnU4NoCiaYspIwsw");


			if(update == null){
				Log.e("Po³¹czenie", "1");

				return null;
			}
			if(update.length > 1){
				Log.e("Po³¹czenie", "2");

				return null;
			}

            String data[][] = null;
			try {
				if(!update[0].getString("update").equals(params[0])){

					String ver = update[0].getString("update");
					JSONObject[] object = JSON.getJSONFromUrl(defURL + "/texts/all/KjZkHweQdLvzNPweBZ7FnU4NoCiaYspIwsw");
					data = new String[15][15];


                int i = 0;

                for(JSONObject o : object){

                	data[i][0] = o.getString("name_pl");
                	data[i][1] = o.getString("name_eng");
                	data[i][2] = o.getString("text_pl");
                	data[i][3] = o.getString("text_eng");
                	i++;
                	publishProgress("Pobieram tekst " + i+"/"+"11");

                }

                data[14][0] = ver;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

		return data;
	}
}
