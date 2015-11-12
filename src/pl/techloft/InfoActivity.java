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

public class InfoActivity extends Activity implements OnTouchListener{


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
		setContentView(R.layout.activity_info);


		 exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("infotextpl", "Pomiechówek po³o¿ony jest niespe³na godzinê drogi od centrum Warszawy. £atwo dotrzeæ tutaj poci¹gami (sk³ady Kolei Mazowieckich odje¿d¿aj¹ kilka razy na dzieñ ze stacji Warszawa Zachodnia lub Warszawa Gdañska), samochodem (45 minut na pó³noc od Warszawy tras¹ w kierunku Gdañska) oraz samolotem. Byæ mo¿e trudno w to uwierzyæ, ale dziêki bliskiemu s¹siedztwu lotniska w Modlinie Pomiechówek od wielu europejskich stolic dzieli nie wiêcej ni¿ 2,5 godziny lotu.Pomiechówek odwiedzaj¹cym go turystom ma do zaoferowania rozwiniêt¹ bazê noclegow¹ (hotele, gospodarstwa agroturystyczne) oraz ofertê rekreacyjn¹ (szczegó³owo opisan¹ w przewodniku). Wszelkie informacje dotycz¹ce organizacji pobytu w Pomiechówku w wygodny sposób mo¿na uzyskaæ w Punkcie Informacji Turystycznej lub za poœrednictwem ci¹gle aktualizowanej strony internetowej: www.pomiechowek.pl <br><br> Punkt Informacji Turystycznej <br> ul. Nasielska 1B, 05-180 Pomiechówek<br>tel. 660 990 700 , turystyka@pomiechowek.pl");
	 	  texten =  preferences.getString("infotexten", "Pomiechówek is situated less than an hour away from central Warsaw. The area can be easily reached by comfortable trains (Koleje Mazowieckie services run several times a day from the railway stations Warszawa Zachodnia or Warszawa Gdañska); by car (45 minutes north of Warsaw on the Gdañsk-bound route); and by air! It may sound improbable, but thanks to the nearby airport in Modlin, Pomiechówek is just 2.5 hours away from many European capitals.The area abounds in accommodation facilities (hotels, agrotourism farms) and offers a great potential for recreation activities (discussed in detail in the previous chapters). You can find everything you need to know about organising your trip to Pomiechówek in the local Tourist Information Office or on the constantly updated website www.pomiechowek.pl <br><br> Communal Information Centre 05-180 Pomiechówek <br> ul. Nasielska 1B, 05-180 Pomiechówek <br> phone +48 660 990 700 , turystyka@pomiechowek.pl");
	 	  headerpl = preferences.getString("infoheaderpl", "Przydatne informacje");
	 	  headeren = preferences.getString("infoheaderen", "Practical information");


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




		text.setText(Html.fromHtml(finalText));
        header.setText(finalHeader);



		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-95Black.ttf");
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-55Roman.ttf");

		header.setTypeface(tf);
		text.setTypeface(tf1);



		//SpannableStringBuilder str = new SpannableStringBuilder("Pomiechówek usytuowany jest w bezpoœrednim s¹siedztwie malowniczego zbiegu dwóch wielkich rzek – Wis³y i Narwi. Jednak jego g³ówn¹ atrakcj¹ pozostaje spokojna i czysta Wkra, prawy dop³yw Narwi. Tereny te stanowi¹ nieskoñczony rezerwuar pomys³ów na spêdzanie wolnego czasu – pocz¹wszy od leœnych spacerów, poprzez letnie k¹piele i wylegiwanie siê na pomiechowskiej pla¿y, a skoñczywszy na wêdkowaniu.Wkra to idealny wrêcz szlak kajakowy. W Pomiechówku znajduje siê kilka wypo¿yczalni sprzêtu kajakowego zajmuj¹cych siê równie¿ instrukta¿em oraz organizacj¹ sp³ywów. £agodny nurt rzeki pozwoli Ci rozkoszowaæ siê widokami na lasy i ³¹ki oraz korzystaæ z przyjemnoœci obcowania z bogactwem dzikiej natury. Szczególnie warte polecenia s¹ dwa szlaki – trudniejszy, 30-kilometrowy sp³yw z Joñca do Pomiechówka oraz krótsza, 10-kilometrowa trasa sp³ywu z B³êdowa do Pomiechówka.Poruszaj¹c siê po rzece, miej oczy szeroko otwarte – spotkasz tutaj rzadkie gatunki roœlin, ryb i zwierz¹t rzecznych takich jak na przyk³ad bobry. Rejon ujœcia Wkry do Narwi to równie¿ idealne miejsce dla wszystkich amatorów obserwacji ptaków. A wczasowicze, którym dopisze szczêœcie, bêd¹ mieli okazjê dostrzec br¹zowe popiersie cara Aleksandra II, które w 1912 roku mieszkañcy Pomiechówka na znak protestu utopili w rzece.");
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
