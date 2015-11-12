package pl.techloft.game;

import java.util.Timer;
import java.util.TimerTask;

import pl.techloft.GameActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Game {

	GameActivity game;


	private int seconds = 0;
	Timer timer;
    RelativeLayout.LayoutParams margins;
    DisplayMetrics displaymetrics = new DisplayMetrics();
    float gameSpeed = 1f;

	  Bitmap bitmap;

	  boolean isRunn;

	public Game(GameActivity a){
		game = a;


		showStartEcran();


		margins = new RelativeLayout.LayoutParams(game.getBackground().getLayoutParams());
		game.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		boat = new Boat(game.getBoat(), this);




	}




	Boat boat;

	int update=0;

	@SuppressLint("NewApi")
	public void startGame(){

    	bitmap = getResizedBitmap(((BitmapDrawable)game.getBackground().getDrawable()).getBitmap(),  game.getBackground().getWidth(),   game.getBackground().getHeight());
        game.getBoat().setX(game.getBackground().getWidth()/2-convertDpToPixel(55, game));
        game.getBoat().setY(displaymetrics.heightPixels-game.getBoat().getHeight()-convertDpToPixel(20, game));
        game.getBackground().setY(-3500f + displaymetrics.heightPixels-convertDpToPixel(10, game));


        boat.motion = 3;
        boat.animateStart();
		isRunn = true;
		getY=0.1f;
		runY = false;
		score = 0;
		seconds = 0;
        update++;
        counterDown = 5000;
        game.getCounter().setVisibility(View.VISIBLE);
	    timer = new Timer("GameTimer"+update);
        timer.scheduleAtFixedRate(new ThreadTimer(), 100, 1);
	}



	@SuppressLint("NewApi")


	public void stopGame(){
		timer.cancel();
		isRunn = false;
	}

	public void winGame(){

	}

	public void loseGame(){
		timer.cancel();
		showAgainEcran();
		isRunn = false;
	}



	private void showStartEcran(){

		DialogStart dialog = new DialogStart(game);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		  dialog.setCancelable(false);
        dialog.show();


	}


	private void showAgainEcran(){

		game.runOnUiThread(new Runnable() {
			@Override
			public void run() {
			DialogAgain dialog = new DialogAgain(game);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(false);
			dialog.show();
			}
	});

	}

	int counterDown = 5000;




	public boolean runY = false;
	public float getY = 0.1f;

	@SuppressLint("NewApi")
	private void checkColission(){

		int pixel = bitmap.getPixel((int)game.getBoat().getX()+game.getBoat().getWidth()/2,(int)(bitmap.getHeight()-getY-game.getBoat().getHeight()));
		int pixel1 = bitmap.getPixel((int)game.getBoat().getX(),(int)(bitmap.getHeight()-getY-game.getBoat().getHeight()));


		final int blueValue = Color.blue(pixel);

		final int blueValue1 = Color.blue(pixel1);





	  if(blueValue != 255){
						loseGame();
			}

	  if(blueValue1 != 255){
			loseGame();
			}
	  //Log.e("color " + getY, ":"+blueValue + "  |   " + blueValue1);

       }








public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
    int width = bm.getWidth();
    int height = bm.getHeight();
    float scaleWidth = ((float) newWidth) / width;
    float scaleHeight = ((float) newHeight) / height;
    Matrix matrix = new Matrix();
   matrix.postScale(scaleWidth, scaleHeight);
    Bitmap resizedBitmap = Bitmap.createBitmap(
        bm, 0, 0, width, height, matrix, false);
    return resizedBitmap;
}





	@SuppressLint("NewApi")
	public void onTouch(View w, MotionEvent m){

		  if(w == game.background){
			  if(isRunn){
           boat.animate();
			  }
		  }

	}


	 class ThreadTimer extends TimerTask{

		    @Override
		    public void run() {
		    seconds++;
		    tasker();

		   }

		}



	 public static float convertPixelsToDp(float px, Context context){
		    Resources resources = context.getResources();
		    DisplayMetrics metrics = resources.getDisplayMetrics();
		    float dp = px / (metrics.densityDpi / 160f);
		    return dp;
		}


	 public static float convertDpToPixel(float dp, Context context){
		    Resources resources = context.getResources();
		    DisplayMetrics metrics = resources.getDisplayMetrics();
		    float px = dp * (metrics.densityDpi / 160f);
		    return px;
		}


	 int stackCounter;
     int score;

	 @SuppressLint("NewApi")
	private void runBacground() {
		 if(   game.getBackground().getY() < 0){
         game.getBackground().setY((float) (game.getBackground().getY()+0.1+gameSpeed));
     	 getY+=0.1;
		 }else{
			 runY  = true;
		 }
	 }

	 private void runBoat(){

		 boat.run(game.getBoat(), gameSpeed);


	 }

	 @SuppressLint("NewApi")
	public void tasker() {

		score = seconds/ 100;
        gameSpeed = (float) (0.1 * seconds/1000/1000);
        // game.getBackground().setY(game.getBackground().getY()+0.1f);


			if(counterDown <= 5000 && counterDown >= 1000){

				game.runOnUiThread(new Runnable() {
			        @Override
			        public void run() {

			        	game.getCounter().setText(counterDown/1000+"");
			        }
			});
				counterDown--;
			}else{
				game.runOnUiThread(new Runnable() {
			        @Override
			        public void run() {
			       	 runBacground();
					 runBoat();

				    	game.getCounter().setVisibility(View.GONE);
				    	//if(seconds % 1000 == 0){
                           game.score.setText("Punkty: " + score);
				    //	}
			        }
			});
			}

			 checkColission();

		}


	 public int getScore(){
		return score;
	 }
}
