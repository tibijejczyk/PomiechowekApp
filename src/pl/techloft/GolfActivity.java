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

public class GolfActivity extends Activity implements OnTouchListener{


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
		setContentView(R.layout.activity_golf);


		 exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("golftextpl", "<akapit1><b>M</b>oment  wynalezienia  gry  w  golfa  ginie  w  odm�tach  historii.  Cho�  powszechnie  uwa�a  si�,  �e kolebk� tej gry  jest �redniowieczna Szkocja, warto wiedzie�, �e nie trzeba odwiedza� celtyckiej krainy,  aby  zasmakowa�  emocji  zwi�zanych  z  celowaniem  pi�eczk�  do  do�ka.  Dzia�aj�cy  od wielu  lat  na  terenie  Pomiech�wka  Klub  Golfowy  Lisia  Polana  dysponuje  mistrzowskim,  18-do�kowym   polem   golfowym,   odpowiednim   zar�wno   dla   zaawansowanych,   jak   i   dla pocz�tkuj�cych graczy. Dodatkow� atrakcj� klubu pozostaje strzelnica golfowa (Driving Range) �  idealna  na  rozpocz�cie  nauki  i  rozwijanie  umiej�tno�ci.  Wybieraj�c  si�  do  Lisiej  Polany,  nie zapomnij, �e golf to niezawodny spos�b na popraw� kondycji niezale�nie od wieku. Odwiedzaj�c pomiechowskie pole golfowe, warto pami�ta�, �e na terenie klubu mie�ci si� r�wnie�  trzygwiazdkowy  hostel  z  restauracj�.  Taka  baza  daje  �wietne  warunki  do  organizacji wyjazd�w  firmowych  czy  wypad�w  na  weekend  po��czonych  z  nauk�  gry  w  golfa  pod  okiem do�wiadczonych instruktor�w.");
	 	  texten =  preferences.getString("golftexten", "<akapit1><b>T</b>he origins of the rules of golf have disappeared into the murk of history. Even though medieval Scotland is commonly believed to be the cradle of the game, the emotions of landing the ball in a hole can be experienced also outside the land of Celts. The Golf Club Lisia Polana, which has operated in Pomiech�wek for many years, prides itself in a high-profile 18-hole golf course, which caters for both advanced and amateur players. A special feature of the club is its driving range � ideal for taking first steps in golf and mastering your skills. When you consider a visit to Lisia Polana, don't forget that golf is a perfect way to get fit for people of all ages. The Pomiech�wek golf course is complete with a three-star hotel and a restaurant. As such it is an ideal location for company outings or weekend trips centred on golf training under the wings of experienced instructors.");
	 	  headerpl = preferences.getString("golfheaderpl", "Pi�k� do do�ka");
	 	  headeren = preferences.getString("golfheaderen", "Ball to the hole");


			 LinearLayout frame = (LinearLayout) findViewById(R.id.frame1);

	 	 Animation animRightIn = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_bottom);
	 	 Animation animRightIn1 = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_top);
	 	 animRightIn.setDuration(2000);
	 	 animRightIn1.setDuration(3000);


	 	 frame.startAnimation(animRightIn);
         exit.startAnimation(animRightIn1);


		header  = (TextView) findViewById(R.id.header);
		text  = (TextView) findViewById(R.id.text1);


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



		String text1edited = finalText.substring(finalText.lastIndexOf("<akapit1>"),  finalText.trim().length()).replace("<akapit1>", "     ");



		text.setText(Html.fromHtml(text1edited));
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
