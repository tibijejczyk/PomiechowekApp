package pl.techloft;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends Activity implements OnTouchListener{


	TextView header, text, text1, text2;

    String headerpl = "";
    String headeren = "";
	String textpl = "";
	String texten = "";


	String finalText, finalHeader;



	ImageView  exit;

	String lang;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		setContentView(R.layout.activity_about);


		 exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("abouttextpl", "Aplikacja zrealizowana zosta�a przez Czosnek Studio na zlecenie Urz�du gminy Pomiech�wek <br> Teksty: Szymon �ydek / AB Praca i Tw�rczo�� <br> Grafiki: Rafa� Dominik / www.rafaldominik.pl <br> Development: Techloft.pl");
	 	  texten =  preferences.getString("abouttexten", "The application was realized by Czosnek Studio for the Municipality of Pomiech�wek <br> Texts: Szymon �ydek / AB Praca i Tw�rczo�� <br> Graphic Design: Rafa� Dominik / www. rafaldominik.pl <br> Development: Techloft.pl");
	 	  headerpl = preferences.getString("aboutheaderpl", "About");
	 	  headeren = preferences.getString("aboutheaderen", "About");


	 	 FrameLayout frame = (FrameLayout) findViewById(R.id.frame1);


	 	 Animation animRightIn = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_bottom);
	 	 Animation animRightIn1 = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_top);
	 	 animRightIn.setDuration(2000);
	 	 animRightIn1.setDuration(3000);


	 	 frame.startAnimation(animRightIn);
         exit.startAnimation(animRightIn1);


		header  = (TextView) findViewById(R.id.header);
		text  = (TextView) findViewById(R.id.text1);




	    exit.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.compo_return, 100, 100));


        exit.setOnTouchListener(this);

        lang = getIntent().getExtras().getString("lang");

        if(lang.equals("pl")){
        	finalText = textpl;
        	finalHeader = headerpl;
        }else{
        	finalText = texten;
         	finalHeader = headeren;
        }

        StringBuffer res = new StringBuffer();
        String[] strArr = finalHeader.split(" ");
        for (String str : strArr) {
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            str = new String(stringArray);

            res.append(str).append(" ");
            finalHeader = res.toString();
        }



		text.setText(Html.fromHtml(finalText));
        header.setText(res);



		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-95Black.ttf");
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-55Roman.ttf");

		header.setTypeface(tf);
		text.setTypeface(tf1);



		//SpannableStringBuilder str = new SpannableStringBuilder("Pomiech�wek usytuowany jest w bezpo�rednim s�siedztwie malowniczego zbiegu dw�ch wielkich rzek � Wis�y i Narwi. Jednak jego g��wn� atrakcj� pozostaje spokojna i czysta Wkra, prawy dop�yw Narwi. Tereny te stanowi� niesko�czony rezerwuar pomys��w na sp�dzanie wolnego czasu � pocz�wszy od le�nych spacer�w, poprzez letnie k�piele i wylegiwanie si� na pomiechowskiej pla�y, a sko�czywszy na w�dkowaniu.Wkra to idealny wr�cz szlak kajakowy. W Pomiech�wku znajduje si� kilka wypo�yczalni sprz�tu kajakowego zajmuj�cych si� r�wnie� instrukta�em oraz organizacj� sp�yw�w. �agodny nurt rzeki pozwoli Ci rozkoszowa� si� widokami na lasy i ��ki oraz korzysta� z przyjemno�ci obcowania z bogactwem dzikiej natury. Szczeg�lnie warte polecenia s� dwa szlaki � trudniejszy, 30-kilometrowy sp�yw z Jo�ca do Pomiech�wka oraz kr�tsza, 10-kilometrowa trasa sp�ywu z B��dowa do Pomiech�wka.Poruszaj�c si� po rzece, miej oczy szeroko otwarte � spotkasz tutaj rzadkie gatunki ro�lin, ryb i zwierz�t rzecznych takich jak na przyk�ad bobry. Rejon uj�cia Wkry do Narwi to r�wnie� idealne miejsce dla wszystkich amator�w obserwacji ptak�w. A wczasowicze, kt�rym dopisze szcz�cie, b�d� mieli okazj� dostrzec br�zowe popiersie cara Aleksandra II, kt�re w 1912 roku mieszka�cy Pomiech�wka na znak protestu utopili w rzece.");
	    //str.setSpan(new StyleSpan(tf.getStyle()), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

       // text.setText(str);




	}


	 @Override
	 public void onWindowFocusChanged(boolean focus) {
	    super.onWindowFocusChanged(focus);



	 }
	   @Override
		public void onBackPressed(){
			Intent i = new Intent(this, MenuActivity.class);
			i.putExtra("lang", lang);
			startActivity(i);
			this.finish();
		}

	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}

	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}




	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		if(arg0.getId() == exit.getId()){

			Intent i = new Intent(this, MenuActivity.class);
			i.putExtra("lang", lang);
			startActivity(i);
			finish();

		}


		return false;
	}
}
