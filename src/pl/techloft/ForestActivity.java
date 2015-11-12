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

public class ForestActivity extends Activity implements OnTouchListener{


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
		setContentView(R.layout.activity_forest);


		 exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("foresttextpl", "<akapit1><b>P</b>onad  jedn¹  trzeci¹  powierzchni  Pomiechówka  zajmuj¹  lasy.  Nie  s¹  to  lasy  zwyczajne  – wyraŸnie odró¿niaj¹ siê od tych rosn¹cych na piaszczystym i suchym pod³o¿u, tak powszechnym w   okolicach   Warszawy.   ¯yzne   gleby   morenowe   Pomiechówka   (pozosta³oœæ   po  ostatnim zlodowaceniu)  dodatkowo  nawo¿one  s¹  przez  regularne  wylewy rzek.  Dziêki  temu  panuj¹  tu idealne  warunki  dla  bujnego  rozwoju  roœlinnoœci  –  spaceruj¹c  po  okolicy,  podziwiaæ  mo¿esz sosny, dêby, modrzewie i brzozy oraz ca³e bogactwo roœlin tworz¹cych podszycie lasu. Na  terenie  Pomiechówka  znajduj¹  siê  a¿  dwa  rezerwaty  przyrody.  Pierwszy  z  nich  to rezerwat  Pomiechówek.  W  jego  obrêbie  mieœci  siê  obszar zwany  puszcz¹  pierwotn¹  –  las zachowany  w  stanie  zbli¿onym  do  naturalnego.  Podziwiaæ  tu  mo¿na  rzadkie  okazy  dêbów szypu³kowych  wysokich  na  30  metrów.  Drugi  rezerwat  nosi  nazwê  Dolina  Wkry  i  zosta³ powo³any do ochrony pozosta³oœci lasów ³êgowych – zbiorowisk leœnych regularnie zalewanych i nawo¿onych przez rzekê Wkrê. <akapit2> <b>W</b>art  wizyty  jest  równie¿  obszar  œwietlistych  d¹brów  i  gr¹d  w  Jab³onnej,  wpisany  do europejskiej  sieci  ochrony  przyrody  Natura  2000.  Miejsce  to  daje  mo¿liwoœæ  obcowania  z zanikaj¹cym  w  Polsce  lasem  dêbowym  oraz  szczególnie  malownicz¹  jego  odmian¹  –  œwietlist¹ d¹brow¹, czyli typem lasu charakteryzuj¹cym siê bogatym gatunkowo, bujnym runem; œwietliste d¹browy  uwa¿ane  s¹  za  najbogatszy  florystycznie  zespó³  leœny  Polski.  Równie  interesuj¹ce  s¹ gr¹dy,  czyli  lasy  poroœniête  przede  wszystkimi  grabami  i  dêbami.  Ciekawostk¹  pozostaje  fakt wystêpowania   na   tym   terenie   siedlisk   dêbów   bezszypu³kowych   osi¹gaj¹cych   imponuj¹ce rozmiary – zarówno jeœli chodzi o wysokoœæ, jak i obwód konarów. <akapit3> <b>W</b>a¿nym  elementem  pomiechowskiego  zasobu  leœnego  jest  zespó³  dwustuletnich  sosen, wœród  których  nestork¹  pozostaje  sosna  Anna  rosn¹ca  w  samym  centrum  Pomiechówka. Niezwyk³e  walory  krajobrazowe  okolic  sprawiaj¹,  ¿e  Pomiechówek  sta³  siê  popularnym  wœród filmowców plenerem do realizowania polskich produkcji. To tutaj krêcone by³y zdjêcia do wielu popularnych filmów, takich jak na przyk³ad „Nigdy w ¿yciu” z Danut¹ Stenk¹ w roli g³ównej.");
	 	  texten =  preferences.getString("foresttexten", "<akapit1><b>M</b>ore than one third of the area of Pomiechówek is covered by forest. The local forests are anything but ordinary. They are strikingly different from the ones that grow on the sandy and dry soil that prevails in the area of Warsaw. The fertile moraine soil of Pomiechówek (remnant of the last glacial period) is additionally enriched by regular river overflows. <akapit2> <b>T</b>he area offers perfect conditions for lush vegetation – pine, oak, larch and birch trees, and the abundance of plants of the forest understorey turn pleasure strolls around the area into a mesmerising adventure. The area of Pomiechówek is home to two nature reserves. The first one is the Pomiechówek Reserve, which includes an area of old-growth forest, preserved in a state that is close to natural. One of the local attractions are the rare 30 metre high pedunculate oaks. The second one, the Wkra Valley Reserve, was established to protect the remnants of riparian forest – regularly flooded and fertilised by the Wkra. <akapit3> <b>A</b>nother attractive area is that of thermophilous oak forests and hornbeam-oak forests in Jab³onna, listed as one of the nature protection areas within the European network Nature 2000. Here you can find an oak forest, which is becoming a rarity in Poland, and its particuarly picturesque thermophilous variation. One of the local curiosities are sessile oaks of monumental height and branch perimeter. A major feature of the Pomiechówek forest is a complex of 200-year-old pine trees – the oldest of them, called Anna, grows right in the centre of Pomiechówek. The unique picturesque landscapes of the area established Pomiechówek as a popular shooting location for Polish films.");
	 	  headerpl = preferences.getString("forestheaderpl", "Czeka las");
	 	  headeren = preferences.getString("forestheaderen", "GO REST IN THE FOREST");


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



		String text1edited = finalText.substring(finalText.lastIndexOf("<akapit1>"), finalText.indexOf("<akapit2>")).replace("<akapit1>", "     ");
		String text2edited = finalText.substring(finalText.lastIndexOf("<akapit2>"), finalText.indexOf("<akapit3>")).replace("<akapit2>", "     ");
		String text3edited = finalText.substring(finalText.lastIndexOf("<akapit3>"), finalText.trim().length()).replace("<akapit3>", "     ");
        StringBuffer res = new StringBuffer();
        String[] strArr = finalHeader.split(" ");
        for (String str : strArr) {
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            str = new String(stringArray);

            res.append(str).append(" ");
            finalHeader = res.toString();
        }

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
