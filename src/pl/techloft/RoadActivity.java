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

	 	  textpl =  preferences.getString("roadtextpl", "<akapit1><b>W</b>   obrêbie   Pomiechówka   wyznaczonych   zosta³o   a¿   piêæ   szlaków   pieszych   Polskiego Towarzystwa Turystyczno-Krajoznawczego – czarny, ¿ó³ty, niebieski, zielony i czerwony. S¹ to szlaki  o  charakterze  nizinnym,  prowadz¹  g³ównie  przez tereny  leœne,  ³¹ki,  wzd³u¿  rzeki  oraz  w pobli¿u g³ównych atrakcji turystycznych. Dobrym miejscem na rozpoczêcie wêdrówki jest stacja PKP Pomiechówek, sk¹d mo¿na rozpocz¹æ wêdrówkê na pó³noc szlakiem niebieskim biegn¹cym wzd³u¿  biegu  rzeki  poprzez  malowniczy  rezerwat  Dolina  Wkry, w  kierunku  grupy  fortowej Go³awice. Okolice stacji kolejowej to równie¿ znakomita okazja do wkroczenia na szlak czarny, który  w  swoim  pó³nocnym  przebiegu  prowadzi  obok  parku  linowego  w  kierunku  fortu  XVI  i dalej skrajem lasów pomiechowskich.  Znajduj¹c  siê  na  stacji  PKP,  mo¿emy  tak¿e  zdecydowaæ  siê  na  spacer  szlakiem  ¿ó³tym prowadz¹cym  przez  rezerwat  przyrody  Pomiechówek  do  fortów  w  okolicy  Go³awic.  Szlaki zielony  i  czerwony  przecinaj¹  tereny  Pomiechówka  ze  wschodu  na  zachód.  Wêdrówkê  nimi najlepiej  rozpocz¹æ  na  stacji  kolejowej  Brody  Warszawskie.  Gdy  wybierzemy  ca³odzienn¹ wycieczkê szlakiem zielonym w kierunku wschodnim, mijaæ bêdziemy grupê fortów Carski Dar, pó³nocn¹  krawêdŸ  rezerwatu  Pomiechówek,  by  po  przekroczeniu  rzeki  Wkry  trafiæ  w  okolice rezerwatu Dolina Wkry. Ten sam  szlak w swoim  zachodnim przebiegu prowadzi g³ównie przez obszary  zalesione,  w  tym  te  w³¹czone  do  sieci  Natura 2000.  Szlak  czerwony  ³¹czy  natomiast stacjê Brody Warszawskie z grup¹  fortow¹ w Go³awicach, gdzie oprócz wypo¿yczalni kajaków znajduje siê tak¿e punkt widokowy umo¿liwiaj¹cy obserwacjê doliny Wkry. Dla  mi³oœników  dwóch  kó³ek  w  Pomiechówku  i  okolicy  wyznaczony  zosta³  szlak rowerowy – wiod¹cy tras¹ fortyfikacji twierdzy Modlin o d³ugoœci przesz³o 20 kilometrów. Trasa stanowi   dobry   pretekst   dla   kilkugodzinnej   wycieczki   wzd³u¿   najwa¿niejszych   zabytków fortyfikacji,  pocz¹wszy  od  fortu  XVI  w  Pomiechówku,  poprzez  najwiêkszy  fort  III  i  dalej  na pó³noc  w  kierunku  grupy  fortowej  Carski  Dar.  Trasa  ta  ma  charakter  obwodowy  –  jej przejechanie daje rozeznanie w topografii i krajobrazie okolic Pomiechówka. Swoj¹ wizytê warto wiêc rozpocz¹æ od jej przemierzenia – mo¿e to okazaæ siê pomocne podczas planowania dalszych eskapad.");
	 	  texten =  preferences.getString("roadtexten", "<akapit1><b>T</b>he Pomiechówek can be explored through as many as five hiking trails of the Polish Tourist and Sightseeing Society (PTTK): black, yellow, blue, green and red. Those are typical lowland trails that run through forests, grasslands, follow the banks of the river or connect the chief tourist attractions of the area. A good place to begin your hiking is the Pomiechówek railway station, from which the blue trail takes you up north along the river through the picturesque Wkra Valley Reserve towards the cluster of fortifications “Go³awice”. The area of the railway station is a perfect place to get on the black trail, whose northern stretch passes by the Ropes Course towards Fort XVI and further along the edge of the Pomiechówek Forest. The station also offers access to the yellow trail that will take you through the Pomiechówek Reserve to the fortifications in the area of Go³awice. The green and the red trail cross the area from the east to the west. They are best accessed from the railway station Brody Warszawskie. An all-day hiking trip along the green trail will take you east next to the cluster of fortifications “Carski Dar”, along the northern edge of the Pomiechówek Reserve and further across the river Wkra into the vicinity of the Wkra Valley Reserve. Along its western stretch, the same trail runs mainly through forests, including those listed as nature protection areas within the European network Nature 2000. The red trail connects the railway station Brody Warszawskie with the cluster of fortifications in Go³awice, where you will find a kayak rental shop and a vantage point that affords a panoramic view of the river Wkra valley. In Pomiechówek and the nearby area, enthusiasts of cycling can enjoy a 20-kilometre bicycle route that runs along the fortifications of the Modlin Fortress. This is a great idea for a few hours of a trip that will allow you to take in the most important historic fortifications from Fort XVI in Pomiechówek, to the largest Fort III, and further north to the cluster of fortifications “Carski Dar”. The trail is akin to a ringroad that can give you a general picture of the topography and landscape of Pomiechówek. As such it is a perfect way to start your holidays in the area and may turn out helpful in planning further excursions!");
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
