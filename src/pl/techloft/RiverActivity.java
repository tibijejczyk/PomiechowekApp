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

public class RiverActivity extends Activity implements OnTouchListener{


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
		setContentView(R.layout.activity_river);

	    exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("rivertextpl", "<akapit1> <b>P</b>omiechówek usytuowany jest w bezpoœrednim s¹siedztwie malowniczego zbiegu dwóch wielkich rzek – Wis³y i Narwi. Jednak jego g³ówn¹ atrakcj¹ pozostaje spokojna i czysta Wkra, prawy dop³yw Narwi. Tereny te stanowi¹ nieskoñczony rezerwuar pomys³ów na spêdzanie wolnego czasu – pocz¹wszy od leœnych spacerów, poprzez letnie k¹piele i wylegiwanie siê na pomiechowskiej pla¿y, a skoñczywszy na wêdkowaniu. <akapit2> <b>W</b>kra to idealny wrêcz szlak kajakowy. W Pomiechówku znajduje siê kilka wypo¿yczalni sprzêtu kajakowego zajmuj¹cych siê równie¿ instrukta¿em oraz organizacj¹ sp³ywów. £agodny nurt rzeki pozwoli Ci rozkoszowaæ siê widokami na lasy i ³¹ki oraz korzystaæ z przyjemnoœci obcowania z bogactwem dzikiej natury. Szczególnie warte polecenia s¹ dwa szlaki – trudniejszy, 30-kilometrowy sp³yw z Joñca do Pomiechówka oraz krótsza, 10-kilometrowa trasa sp³ywu z B³êdowa do Pomiechówka.<akapit3> <b>P</b>oruszaj¹c siê po rzece, miej oczy szeroko otwarte – spotkasz tutaj rzadkie gatunki roœlin, ryb i zwierz¹t rzecznych takich jak na przyk³ad bobry. Rejon ujœcia Wkry do Narwi to równie¿ idealne miejsce dla wszystkich amatorów obserwacji ptaków. A wczasowicze, którym dopisze szczêœcie, bêd¹ mieli okazjê dostrzec br¹zowe popiersie cara Aleksandra II, które w 1912 roku mieszkañcy Pomiechówka na znak protestu utopili w rzece.");
	 	  texten =  preferences.getString("rivertexten", "	<akapit1>  <b>P</b>omiechówek is located in the immediate vicinity of the picturesque confluence of two great rivers – the Vistula and the Narew. But the chief attraction of the area is the peaceful and clean river Wkra, one of the right tributaries to the Narew. The river offers and endless array of ideas for leisure activities – from pleasure strolls in the forest, to summer swimming and lounging about on the beach in Pomiechówek, to angling. The Wkra is also perfect for kayaking. There are a few kayak rental shops in Pomiechówek (full list below), which also offer training and organise kayaking trips. The river's gentle current affords time to delight in the views of forests and grasslands, while taking in the abundance of wildlife. There are two kayak trails that are particularly worth your attention: a more demanding 30-kilometre trail from Joniec to Pomiechówek, and a shorter 10-kilometre trail from B³êdowo to Pomiechówek. <akapit2>	<b>K</b>eep your eyes open while meandering along the river – you're sure to encounter rare species of plants, fish and river animals, such as beavers. <akapit3> <b>T</b>he area where the Wkra flows into the Narew is also an ideal spot for all enthusiasts of bird watching. Some holidaymakers are lucky enough to catch a glimpse of a bronze bust of Tsar Alexander II of Russia, which was drowned in 1912 by the people of Pomiechówek as a sign of protest.");
	 	  headerpl = preferences.getString("riverheaderpl", "Czeka rzeka");
	 	  headeren = preferences.getString("riverheaderen", "River fun fever");


		 LinearLayout frame = (LinearLayout) findViewById(R.id.frame1);


	 	 Animation animRightIn = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_bottom);
	 	 Animation animRightIn1 = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_top);
	 	 animRightIn.setDuration(2000);
	 	 animRightIn1.setDuration(3000);


	 	 frame.startAnimation(animRightIn);
         exit.startAnimation(animRightIn1);


		header  = (TextView) findViewById(R.id.header);
		text  = (TextView) findViewById(R.id.text1);
		text1  = (TextView) findViewById(R.id.text2);
		text2  = (TextView) findViewById(R.id.text3);

		picture1 = (ImageView) findViewById(R.id.imageView2);
		picture2 = (ImageView) findViewById(R.id.imageView3);
		picture3 = (ImageView) findViewById(R.id.imageView4);


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


		String text1edited = finalText.substring(finalText.lastIndexOf("<akapit1>"), finalText.indexOf("<akapit2>")).replace("<akapit1>", "     ");
		String text2edited = finalText.substring(finalText.lastIndexOf("<akapit2>"), finalText.indexOf("<akapit3>")).replace("<akapit2>", "     ");
		String text3edited = finalText.substring(finalText.lastIndexOf("<akapit3>"), finalText.trim().length()).replace("<akapit3>", "     ");


		text.setText(Html.fromHtml(text1edited));
		text1.setText(Html.fromHtml(text2edited));
		text2.setText(Html.fromHtml(text3edited));
		 header.setText(finalHeader);

		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-95Black.ttf");
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-55Roman.ttf");

		header.setTypeface(tf);
		text.setTypeface(tf1);
		text1.setTypeface(tf1);
		text2.setTypeface(tf1);


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
