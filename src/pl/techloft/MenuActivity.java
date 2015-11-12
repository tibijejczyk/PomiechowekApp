package pl.techloft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MenuActivity extends Activity implements OnTouchListener{


	private ImageView mapButton, gameButton;

	private ImageView infoButton, aboutButton, plenerButton, riverButton, golfButton, notingButton, forestButton, lineButton, roadButton, winterButton, monumentsButton;

	String lang;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		setContentView(R.layout.activity_menu);


		lang  = getIntent().getStringExtra("lang");



		// ³adowanie przycisków
		mapButton =  (ImageView) findViewById(R.id.mapbutton);
		gameButton =  (ImageView) findViewById(R.id.map);


		plenerButton = (ImageView) findViewById(R.id.button_menu_plener);
		riverButton = (ImageView) findViewById(R.id.button_menu_river);
		golfButton = (ImageView) findViewById(R.id.button_menu_golf);
		notingButton = (ImageView) findViewById(R.id.button_menu_nothing);
		forestButton = (ImageView) findViewById(R.id.button_menu_forest);
		lineButton = (ImageView) findViewById(R.id.button_menu_line);
		roadButton = (ImageView) findViewById(R.id.button_menu_road);
		winterButton = (ImageView) findViewById(R.id.button_menu_winter);
		monumentsButton = (ImageView) findViewById(R.id.button_menu_monuments);
		aboutButton  = (ImageView) findViewById(R.id.button_menu_about);
		infoButton = (ImageView) findViewById(R.id.button_menu_info);

		plenerButton.setOnTouchListener(this);
		riverButton.setOnTouchListener(this);
		golfButton.setOnTouchListener(this);
		notingButton.setOnTouchListener(this);
		forestButton.setOnTouchListener(this);
		lineButton.setOnTouchListener(this);
		roadButton.setOnTouchListener(this);
		winterButton.setOnTouchListener(this);
		monumentsButton.setOnTouchListener(this);
		aboutButton.setOnTouchListener(this);
		infoButton.setOnTouchListener(this);

		mapButton.setOnTouchListener(this);
		gameButton.setOnTouchListener(this);



	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {


		if(mapButton.getId() == arg0.getId()){
			Intent i = new Intent(this, MapActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}

		if(riverButton.getId() == arg0.getId()){
			Intent i = new Intent(this, RiverActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(forestButton.getId() == arg0.getId()){
			Intent i = new Intent(this, ForestActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(golfButton.getId() == arg0.getId()){
			Intent i = new Intent(this, GolfActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(plenerButton.getId() == arg0.getId()){
			Intent i = new Intent(this, PlenerActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(lineButton.getId() == arg0.getId()){
			Intent i = new Intent(this, LineActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(notingButton.getId() == arg0.getId()){
			Intent i = new Intent(this, NothingActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(monumentsButton.getId() == arg0.getId()){
			Intent i = new Intent(this, ZabytkiActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(winterButton.getId() == arg0.getId()){
			Intent i = new Intent(this, WinterActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(roadButton.getId() == arg0.getId()){
			Intent i = new Intent(this, RoadActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}

		if(gameButton.getId() == arg0.getId()){
			Intent i = new Intent(this, GameActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(aboutButton.getId() == arg0.getId()){
			Intent i = new Intent(this, AboutActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}
		if(infoButton.getId() == arg0.getId()){
			Intent i = new Intent(this, InfoActivity.class);
			i.putExtra("lang", lang);
			 startActivity(i);
			 finish();
			return true;
		}










		return false;
	}


	   @Override
		public void onBackPressed(){

		}

}
