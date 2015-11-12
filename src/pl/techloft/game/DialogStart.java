package pl.techloft.game;

import pl.techloft.GameActivity;
import pl.techloft.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogStart extends Dialog implements OnTouchListener{


	  public GameActivity c;

	  ImageView boat;
      TextView ok;
      Boat boatclass;

	  public DialogStart(Activity a) {
	    super(a);

	    this.c = (GameActivity) a;
	  }

  	@Override
  	protected void onCreate(Bundle savedInstanceState) {
  		super.onCreate(savedInstanceState);
  		requestWindowFeature(Window.FEATURE_NO_TITLE);
  		setContentView(R.layout.dialogstart);

         boat = (ImageView) findViewById(R.id.boat2);
         boat.setOnTouchListener(this);

         ok = (TextView) findViewById(R.id.go);
         ok.setOnTouchListener(this);
         boatclass = new Boat(boat);
  	}



  @Override
  public boolean onTouch(View v, MotionEvent event) {

     if(v.getId() == boat.getId()){
    	 boatclass.animate();
     }
     if(v.getId() == ok.getId()){
    	 dismiss();
         c.getGame().startGame();;
     }


	  return false;
  }






}
