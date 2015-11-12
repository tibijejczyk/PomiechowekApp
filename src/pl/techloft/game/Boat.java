package pl.techloft.game;

import pl.techloft.R;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import android.widget.ImageView;

public class Boat {

	ImageView boat;
	public int motion = 3;
    Game game;

	public Boat(ImageView w, Game g) {

		boat = w;
        game = g;
	}

	public Boat(ImageView w) {

		boat = w;

	}

	// 0 = left   1  = right
	public void animateBoat(int motion){
		this.motion = motion;
		if(motion == 0){
			boat.setImageBitmap(rotateImage(BitmapFactory.decodeResource(boat.getResources(), R.drawable.game_car),65));

		}else
			if(motion == 1){
				boat.setImageBitmap(rotateImage(BitmapFactory.decodeResource(boat.getResources(), R.drawable.game_car),295));

			}else
				if(motion == 3){
					boat.setImageBitmap(rotateImage(BitmapFactory.decodeResource(boat.getResources(), R.drawable.game_car),0));

				}

	}

	public Bitmap rotateImage(Bitmap src, float degree) {
	     Matrix matrix = new Matrix();
	     matrix.postRotate(degree);
	     return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, false);
	 }


	@SuppressLint("NewApi")
	public void run(View w, float speed){
		if(motion == 1){
		if(game.runY){
		w.setY(w.getY()-0.1f);
		game.getY+=0.1f+game.gameSpeed;
		}
		w.setX(w.getX()-0.15f+game.gameSpeed);
		}else if(motion == 0){
			if(game.runY){
				w.setY(w.getY()-0.1f+game.gameSpeed);
				game.getY+=0.1f;
				}
			w.setX(w.getX()+0.15f+game.gameSpeed);
		}else{
			if(game.runY){
			w.setY(w.getY()-0.1f+game.gameSpeed);
			game.getY+=0.1f;
			}
		}
	}

	public void animate(){
		animateBoat(motion == 0 ? 1 : 0);
	}

	public void animateStart(){
		animateBoat(3);
	}



}




