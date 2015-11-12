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

public class WinterActivity extends Activity implements OnTouchListener{


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
		setContentView(R.layout.activity_winter);


		 exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("wintertextpl", "<akapit1><b>Z</b>ima  z�a?  Niekoniecznie!Pomiech�wek  nie  zapada  w  sen  zimowy,  a  sezon  na odpoczynek  nie ko�czy si� tu wraz z pierwszym �niegiem. Wr�cz przeciwnie � to w�a�nie wtedy tutejsze walory rekreacyjne  ujawniaj�  swoje  mniej  znane  oblicze.  Zim�  Pomiech�wek  jest  spokojny  i  mniej ucz�szczany  przez  turyst�w,  co  sprawia,  �e  sprzyja  medytacji  i  zadumie.  O  tej  porze  roku pomiechowskie lasy stwarzaj� wr�cz idealne warunki do spacer�w (pami�taj, aby nie zapuszcza� si� zbyt g��boko), panuj� tu r�wnie� znakomite warunki do wielogodzinnych wypraw na nartach biegowych.  W  okresie  zimowym  warto  odwiedzi�  gminne  lodowisko znajduj�ce  si�  w  pobli�u hali sportowej przy ul. Szkolnej 3 (�y�wy za niewielk� op�at� mo�na wypo�yczy� na miejscu). A dzia�aj�ce na terenie Pomiech�wka gospodarstwa agroturystyczne oferuj� niezapominane chwile podczas  kulig�w  po��czonych  z  wieczornymi  ogniskami.  Warto  rozwa�y�  sp�dzenie  Nowego Roku  w�a�nie  w  Pomiech�wku.  Mazowiecka  zima  wcale  nie  musi by�  gorsza  ni�  ta  w Zakopanem!");
	 	  texten =  preferences.getString("wintertexten", "<akapit1><b>T</b>he least liked season of the year? Not necessarily! Pomiech�wek never hibernates and the holiday season does not come to an end here with the first snowfall. Quite the opposite � winter brings out a lesser known face of the local recreation potential. During this season, Pomiech�wek is tranquil and less popular among tourists � it becomes a perfect place for meditation and contemplation. But let's not let ice melt under our feet! In wintertime, the forests of Pomiech�wek offer an ideal environment for pleasure strolls (remember not to go too deep into the forest). They are also perfect for long hours of cross-country skiing. A great feature is also the local ice skating rink in the vicinity of the sports hall in ul. Szkolna 3 (ice skates can be rented at a modest price). Agrotourism farms located in the area are sure to deliver unforgettable moments during sleigh rides that culminate with night-time parties around a campfire. New Year's Eve in Pomiech�wek is a brilliant idea. Winter in Mazovia can be nothing short of the season in the Polish Tatra Mountains!");
	 	  headerpl = preferences.getString("winterheaderpl", "Zimowisko");
	 	  headeren = preferences.getString("winterheaderen", "Winter Holidays");


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


		return false;
	}
}
