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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NothingActivity extends Activity implements OnTouchListener{


	TextView header, text, text1, text2;

    String headerpl = "";
    String headeren = "";
	String textpl = "";
	String texten = "";


	String finalText, finalHeader;

	ImageView picture1, picture2, picture3;

	ImageView  exit;

	String lang;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		setContentView(R.layout.activity_nothing);


		  exit = (ImageView)findViewById(R.id.exit);

	     	 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

	 	  textpl =  preferences.getString("nothingtextpl", "<akapit1><b>C</b>hocia¿  Pomiechówek  stwarza  idealne  warunki  do  aktywnego  wypoczynku,  nie  od  dziœ wiadomo,   ¿e   najbardziej   lubian¹   przez   wszystkich   form¹   spêdzania   czasu   wolnego   jest leniuchowanie!  Wylegiwanie  siê  nad  rzek¹,  rekreacyjne  spacery  po  lesie  czy  wielogodzinne obserwowanie  ptaków  nad  rozlewiskami  przy  ujœciu  Wkry  do  Narwi  –  ka¿dy  znajdzie  tutaj  dla siebie sposób na do³adowanie wewnêtrznych baterii.  S³odkiemu  lenistwu  z  pewnoœci¹  sprzyjaj¹  pomiechowskie  pla¿e.  Najwiêksza  z  nich zlokalizowana  jest  w  niewielkim  oddaleniu  od  stacji  kolejowej,  tu¿  obok  otwartej  niedawno promenady  spacerowej.  W  jej  bezpoœrednim  s¹siedztwie  znajduj¹  siê  dodatkowe  atrakcje  w postaci  si³owni  zewnêtrznej,  parku  linowego  oraz  leœnej  œcie¿ki  dydaktycznej.  Druga  pla¿a zlokalizowana  jest tu¿ obok  k³adki  w  Kosewku.  <akapit2><b>P</b>la¿e  maj¹ charakter otwarty  –  dostêp  do  nich maj¹  wszyscy  letnicy  przebywaj¹cy  w  Pomiechówku.  Wybieraj¹c  siê  na  pla¿ê,  pamiêtaj  o zachowaniu   porz¹dku  oraz   szacunku   dla   wspó³pla¿owiczów   –   pozwoli   to   wszystkim   na bezstresowe za¿ywanie k¹pieli s³onecznych. Woda we Wkrze jest czysta i o spokojnym nurcie – bez  przeszkód  mo¿na  w  niej  siê  k¹paæ  i  taplaæ.  Nie  nale¿y  jednak  zapominaæ,  ¿e  rzeka  nie  ma charakteru  zorganizowanego  k¹pieliska  i  ka¿dorazowe  wejœcie  do wody  wymaga  szczególnej czujnoœci, zw³aszcza w przypadku dzieci.");
	 	  texten =  preferences.getString("nothingtexten", "<akapit1><b>P</b>omiechówek may abound in outstanding active recreational opportunities, but everybody knows that idling has always been mankind's favourite way to spend free time! Lounging about by the river, wandering around the forest with no destination or long hours of bird watching in the marsh near the place where the Wkra flows into the Narew. Everyone is sure to find their own way to re-charge their batteries. There is no better place for idling than the beaches of Pomiechówek.  <akapit2><b>T</b>he biggest one is located not far from the railway station, near the recently opened promenade. The immediate vicinity features such attractions as an outdoor gym, the Ropes Course and a forest education trail (discussed in detail in other chapters of the guide). The second beach is located right near the footbridge in Kosewko. The beaches are open to the public – all holidaymakers in Pomiechówek are free to enjoy them. While at the beach, make sure you keep the place clean and respect the right of other people around you to relax undisturbed – if we all do so, we will all be able to lie flat on the back and soak up the sun with no stress. Water in the Wkra is clean and the river current is calm – it is perfect for swimming and paddling. Please remember that there are no lifeguard posts and special caution is required every time you enjoy the water; this applies especially to children.");
	 	  headerpl = preferences.getString("nothingheaderpl", "S³odkie lenistwo");
	 	  headeren = preferences.getString("nothingheaderen", "Dolce Far Niente");


	 	 LinearLayout frame = (LinearLayout) findViewById(R.id.frame1);


	 	 Animation animRightIn = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_bottom);
	 	 Animation animRightIn1 = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_top);
	 	 animRightIn.setDuration(1000);
	 	 animRightIn1.setDuration(2000);


	 	 frame.startAnimation(animRightIn);
         exit.startAnimation(animRightIn1);


		header  = (TextView) findViewById(R.id.header);
		text  = (TextView) findViewById(R.id.text1);
		text1  = (TextView) findViewById(R.id.text2);


		picture1 = (ImageView) findViewById(R.id.imageView2);
		picture2 = (ImageView) findViewById(R.id.imageView3);



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



		String text1edited = finalText.substring(finalText.lastIndexOf("<akapit1>"), finalText.indexOf("<akapit2>")).replace("<akapit1>", "     ");
		String text2edited = finalText.substring(finalText.lastIndexOf("<akapit2>"), finalText.length()).replace("<akapit2>", "     ");


		text.setText(Html.fromHtml(text1edited));
		text1.setText(Html.fromHtml(text2edited));

        header.setText(finalHeader);



		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-95Black.ttf");
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-55Roman.ttf");
        StringBuffer res = new StringBuffer();
        String[] strArr = finalHeader.split(" ");
        for (String str : strArr) {
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            str = new String(stringArray);

            res.append(str).append(" ");
            finalHeader = res.toString();
        }
		header.setTypeface(tf);
		text.setTypeface(tf1);
		text1.setTypeface(tf1);







	}

	   @Override
		public void onBackPressed(){
			Intent i = new Intent(this, MenuActivity.class);
			i.putExtra("lang", lang);
			startActivity(i);
			this.finish();
		}

	 @Override
	 public void onWindowFocusChanged(boolean focus) {
	    super.onWindowFocusChanged(focus);



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


		return true;
	}
}
