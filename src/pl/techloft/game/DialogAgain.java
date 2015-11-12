package pl.techloft.game;

import pl.techloft.GameActivity;
import pl.techloft.MenuActivity;
import pl.techloft.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DialogAgain extends Dialog implements OnClickListener{


	  public GameActivity c;

	  Button exit, again;
      TextView score;


	  public DialogAgain(Activity a) {
	    super(a);
	    this.c = (GameActivity) a;
	  }

  	@Override
  	protected void onCreate(Bundle savedInstanceState) {
  		super.onCreate(savedInstanceState);
  		requestWindowFeature(Window.FEATURE_NO_TITLE);
  		setContentView(R.layout.dialogagain);


         score = (TextView) findViewById(R.id.score);

         exit = (Button) findViewById(R.id.exit);
         again = (Button) findViewById(R.id.again);

         exit.setOnClickListener(this);
         again.setOnClickListener(this);


         score.setText("Punkty: " + c.getGame().getScore());

  	}

	@Override
	public void onClick(View arg0) {

		if(arg0.getId() == exit.getId()){
            Intent i = new Intent(c, MenuActivity.class);
            i.putExtra("lang", c.lang);
            c.getGame().stopGame();
            c.startActivity(i);
            c.finish();

		}
		if(arg0.getId() == again.getId()){
			dismiss();
           c.getGame().startGame();
		}


	}









}
