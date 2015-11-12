package pl.techloft;

import pl.techloft.utils.UpdateTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class IntroActivity extends Activity implements AnimationListener{

	Animation introAnimStart;
	Animation introAnimStart1,introAnimEnd1;
	Animation introAnimEnd;

	ImageView intro, intro_text;

	IntroActivity thisclass;

	String lang;

	String version;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		setContentView(R.layout.activity_intro);


		// za³adowanie
		 intro = (ImageView) findViewById(R.id.scroll);
		 intro_text = (ImageView) findViewById(R.id.intro_text);





        // ustawienia animacji
		introAnimStart = AnimationUtils.loadAnimation(this, R.anim.inload);
		introAnimStart1 = AnimationUtils.loadAnimation(this, R.anim.inload);
		introAnimEnd = AnimationUtils.loadAnimation(this, R.anim.outload);
		introAnimEnd1 = AnimationUtils.loadAnimation(this, R.anim.outload);

		introAnimStart.setAnimationListener(this);
		introAnimEnd.setAnimationListener(this);
		introAnimStart1.setAnimationListener(this);


		introAnimStart.setDuration(2000);
		introAnimStart1.setDuration(2000);
		introAnimEnd.setDuration(2000);
		introAnimEnd1.setDuration(2000);

		intro.startAnimation(introAnimStart);
        intro_text.setVisibility(View.GONE);
		thisclass = this;



		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	 if(!preferences.contains("version")) {
	 		editor.putString("version", "0");
	 		version = "0";
	 	 }else{
	 		version =  preferences.getString("version", "0");
	 	 }







	}

	public ProgressDialog barProgressDialog;
	public void showProgress(){
			            	barProgressDialog = new ProgressDialog(thisclass);
					        barProgressDialog.setTitle("Pobieram aktualizacje");
					        barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					        barProgressDialog.setMessage("Pobieram dane.");
					        barProgressDialog.setProgress(0);
					        barProgressDialog.setMax(11);
					        barProgressDialog.show();
			}







	public void showLang(){
        	AlertDialog.Builder adb = new AlertDialog.Builder(thisclass);
    		adb.setTitle("Wybierz jêzyk");
           adb.setCancelable(false);
           adb.setInverseBackgroundForced(true);
           adb.setMessage("Wybierz jêzyk komponentów w aplikacji.");
    		adb.setPositiveButton("English", new DialogInterface.OnClickListener() {
    	    @Override
    		public void onClick(DialogInterface dialog, int which) {
    	    	intro_text.startAnimation(introAnimEnd1);
    			intro.startAnimation(introAnimEnd);

    			lang = "en";

    	    	} });


    	adb.setNegativeButton("Polski", new DialogInterface.OnClickListener() {
    	    @Override
    		public void onClick(DialogInterface dialog, int which) {
    	    	intro_text.startAnimation(introAnimEnd1);
    			intro.startAnimation(introAnimEnd);
    			lang = "pl";

    	  } });
    	adb.show();






	}




	@Override
	public void onAnimationEnd(Animation arg0) {


		if(arg0 == introAnimStart) {
	        intro_text.setVisibility(View.VISIBLE);
			intro_text.startAnimation(introAnimStart1);
		}


		if(arg0 == introAnimStart1){
			new UpdateTask(this).execute(version);
		}


		if(arg0 == introAnimEnd){
			 Intent i = new Intent(this, MenuActivity.class);
			 i.putExtra("lang", lang);
			 startActivity(i);
			 finish();

		}


	}

	@Override
	public void onAnimationRepeat(Animation arg0) {


	}

	@Override
	public void onAnimationStart(Animation arg0) {







	}
}
