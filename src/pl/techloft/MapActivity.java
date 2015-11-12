package pl.techloft;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MapActivity extends Activity implements OnTouchListener{



	ImageView map;
	PhotoViewAttacher mAttacher;

    ScrollView scroll1;
    HorizontalScrollView scroll2;



    ImageView exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		setContentView(R.layout.activity_map);



        map = (ImageView) findViewById(R.id.imageMap);

        scroll1 = (ScrollView) findViewById(R.id.scroll);
        scroll2 = (HorizontalScrollView) findViewById(R.id.scrollView2);

		mAttacher = new PhotoViewAttacher(map);
		mAttacher.update();



		exit = (ImageView) findViewById(R.id.exit);
		exit.setOnTouchListener(this);
//	      scroll1.post(new Runnable() {
//	       	  @Override
//	        	  public void run() {
//	        		  scroll1.scrollTo(0, 500);
//	        		  scroll2.scrollTo(1000, 0);
//	      	  }
//	        	});


		lang = getIntent().getExtras().getString("lang");

	}

	String lang;

	   @Override
			public void onBackPressed(){
		   Intent i = new Intent(this, MenuActivity.class);
			i.putExtra("lang", lang);
			startActivity(i);
				this.finish();
			}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {

		 if(arg0.getId() == exit.getId()){
				Intent i = new Intent(this, MenuActivity.class);
				i.putExtra("lang", lang);
				startActivity(i);
				this.finish();
		 }
		return false;
	}


}
