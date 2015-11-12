package pl.techloft;


import pl.techloft.game.Game;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class GameActivity extends Activity implements OnTouchListener  {

	ScrollView scroll;

	ImageView boat;

	public ImageView background;

	RelativeLayout boatPlane, gamelayout;
	FrameLayout.LayoutParams mParams;

	TextView counter;

   public TextView score;

   public String lang;

	Game game;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_game);
            boat = (ImageView) findViewById(R.id.boat10);
	        //scroll  = (ScrollView) findViewById(R.id.scroll);
	      //  boatPlane = (RelativeLayout) findViewById(R.id.boatPlane);
	        counter = (TextView) findViewById(R.id.counter);
	        background= (ImageView) findViewById(R.id.boat2);
	        score = (TextView) findViewById(R.id.score1);
            findViewById(android.R.id.content).setOnTouchListener(this);

            counter.bringToFront();
            boat.bringToFront();
            gamelayout = (RelativeLayout) findViewById(R.id.game);
            gamelayout.setOnTouchListener(this);
	      //  scroll.setOnTouchListener(this);
	        background.setOnTouchListener(this);

	        // mParams = (android.widget.FrameLayout.LayoutParams) boatPlane.getLayoutParams();

	        game = new Game(this);


	        lang = getIntent().getExtras().getString("lang");




	    }
		public ScrollView getScroll() {
			return scroll;
		}
		public ImageView getBoat() {
			return boat;
		}
		public ImageView getBackground() {
			return background;
		}
		public RelativeLayout getBoatPlane() {
			return boatPlane;
		}
		public FrameLayout.LayoutParams getmParams() {
			return mParams;
		}

		public Game getGame(){
			return game;
		}

		public TextView getCounter() {
			return counter;
		}
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			game.onTouch(v, event);
			return false;
		}





		@Override
		public void onBackPressed(){
			Intent i = new Intent(this, MenuActivity.class);
			i.putExtra("lang", lang);
			startActivity(i);
			game.stopGame();
			this.finish();
		}

	}



