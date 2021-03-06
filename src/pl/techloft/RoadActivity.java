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

public class RoadActivity extends Activity implements OnTouchListener{


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
		setContentView(R.layout.activity_road);


		 exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("roadtextpl", "<akapit1><b>W</b>   obr�bie   Pomiech�wka   wyznaczonych   zosta�o   a�   pi��   szlak�w   pieszych   Polskiego Towarzystwa Turystyczno-Krajoznawczego � czarny, ��ty, niebieski, zielony i czerwony. S� to szlaki  o  charakterze  nizinnym,  prowadz�  g��wnie  przez tereny  le�ne,  ��ki,  wzd�u�  rzeki  oraz  w pobli�u g��wnych atrakcji turystycznych. Dobrym miejscem na rozpocz�cie w�dr�wki jest stacja PKP Pomiech�wek, sk�d mo�na rozpocz�� w�dr�wk� na p�noc szlakiem niebieskim biegn�cym wzd�u�  biegu  rzeki  poprzez  malowniczy  rezerwat  Dolina  Wkry, w  kierunku  grupy  fortowej Go�awice. Okolice stacji kolejowej to r�wnie� znakomita okazja do wkroczenia na szlak czarny, kt�ry  w  swoim  p�nocnym  przebiegu  prowadzi  obok  parku  linowego  w  kierunku  fortu  XVI  i dalej skrajem las�w pomiechowskich.  Znajduj�c  si�  na  stacji  PKP,  mo�emy  tak�e  zdecydowa�  si�  na  spacer  szlakiem  ��tym prowadz�cym  przez  rezerwat  przyrody  Pomiech�wek  do  fort�w  w  okolicy  Go�awic.  Szlaki zielony  i  czerwony  przecinaj�  tereny  Pomiech�wka  ze  wschodu  na  zach�d.  W�dr�wk�  nimi najlepiej  rozpocz��  na  stacji  kolejowej  Brody  Warszawskie.  Gdy  wybierzemy  ca�odzienn� wycieczk� szlakiem zielonym w kierunku wschodnim, mija� b�dziemy grup� fort�w Carski Dar, p�nocn�  kraw�d�  rezerwatu  Pomiech�wek,  by  po  przekroczeniu  rzeki  Wkry  trafi�  w  okolice rezerwatu Dolina Wkry. Ten sam  szlak w swoim  zachodnim przebiegu prowadzi g��wnie przez obszary  zalesione,  w  tym  te  w��czone  do  sieci  Natura 2000.  Szlak  czerwony  ��czy  natomiast stacj� Brody Warszawskie z grup�  fortow� w Go�awicach, gdzie opr�cz wypo�yczalni kajak�w znajduje si� tak�e punkt widokowy umo�liwiaj�cy obserwacj� doliny Wkry. Dla  mi�o�nik�w  dw�ch  k�ek  w  Pomiech�wku  i  okolicy  wyznaczony  zosta�  szlak rowerowy � wiod�cy tras� fortyfikacji twierdzy Modlin o d�ugo�ci przesz�o 20 kilometr�w. Trasa stanowi   dobry   pretekst   dla   kilkugodzinnej   wycieczki   wzd�u�   najwa�niejszych   zabytk�w fortyfikacji,  pocz�wszy  od  fortu  XVI  w  Pomiech�wku,  poprzez  najwi�kszy  fort  III  i  dalej  na p�noc  w  kierunku  grupy  fortowej  Carski  Dar.  Trasa  ta  ma  charakter  obwodowy  �  jej przejechanie daje rozeznanie w topografii i krajobrazie okolic Pomiech�wka. Swoj� wizyt� warto wi�c rozpocz�� od jej przemierzenia � mo�e to okaza� si� pomocne podczas planowania dalszych eskapad.");
	 	  texten =  preferences.getString("roadtexten", "<akapit1><b>T</b>he Pomiech�wek can be explored through as many as five hiking trails of the Polish Tourist and Sightseeing Society (PTTK): black, yellow, blue, green and red. Those are typical lowland trails that run through forests, grasslands, follow the banks of the river or connect the chief tourist attractions of the area. A good place to begin your hiking is the Pomiech�wek railway station, from which the blue trail takes you up north along the river through the picturesque Wkra Valley Reserve towards the cluster of fortifications �Go�awice�. The area of the railway station is a perfect place to get on the black trail, whose northern stretch passes by the Ropes Course towards Fort XVI and further along the edge of the Pomiech�wek Forest. The station also offers access to the yellow trail that will take you through the Pomiech�wek Reserve to the fortifications in the area of Go�awice. The green and the red trail cross the area from the east to the west. They are best accessed from the railway station Brody Warszawskie. An all-day hiking trip along the green trail will take you east next to the cluster of fortifications �Carski Dar�, along the northern edge of the Pomiech�wek Reserve and further across the river Wkra into the vicinity of the Wkra Valley Reserve. Along its western stretch, the same trail runs mainly through forests, including those listed as nature protection areas within the European network Nature 2000. The red trail connects the railway station Brody Warszawskie with the cluster of fortifications in Go�awice, where you will find a kayak rental shop and a vantage point that affords a panoramic view of the river Wkra valley. In Pomiech�wek and the nearby area, enthusiasts of cycling can enjoy a 20-kilometre bicycle route that runs along the fortifications of the Modlin Fortress. This is a great idea for a few hours of a trip that will allow you to take in the most important historic fortifications from Fort XVI in Pomiech�wek, to the largest Fort III, and further north to the cluster of fortifications �Carski Dar�. The trail is akin to a ringroad that can give you a general picture of the topography and landscape of Pomiech�wek. As such it is a perfect way to start your holidays in the area and may turn out helpful in planning further excursions!");
	 	  headerpl = preferences.getString("roadheaderpl", "Przygoda na szlaku!");
	 	  headeren = preferences.getString("roadheaderen", "Adeventure awaits on the trail!");


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

        StringBuffer res = new StringBuffer();
        String[] strArr = finalHeader.split(" ");
        for (String str : strArr) {
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            str = new String(stringArray);

            res.append(str).append(" ");
            finalHeader = res.toString();
        }

		String text1edited = finalText.substring(finalText.lastIndexOf("<akapit1>"),  finalText.trim().length()).replace("<akapit1>", "     ");



		text.setText(Html.fromHtml(text1edited));
        header.setText(finalHeader);



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
