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

	 	  textpl =  preferences.getString("foresttextpl", "<akapit1><b>P</b>onad  jedn�  trzeci�  powierzchni  Pomiech�wka  zajmuj�  lasy.  Nie  s�  to  lasy  zwyczajne  � wyra�nie odr�niaj� si� od tych rosn�cych na piaszczystym i suchym pod�o�u, tak powszechnym w   okolicach   Warszawy.   �yzne   gleby   morenowe   Pomiech�wka   (pozosta�o��   po  ostatnim zlodowaceniu)  dodatkowo  nawo�one  s�  przez  regularne  wylewy rzek.  Dzi�ki  temu  panuj�  tu idealne  warunki  dla  bujnego  rozwoju  ro�linno�ci  �  spaceruj�c  po  okolicy,  podziwia�  mo�esz sosny, d�by, modrzewie i brzozy oraz ca�e bogactwo ro�lin tworz�cych podszycie lasu. Na  terenie  Pomiech�wka  znajduj�  si�  a�  dwa  rezerwaty  przyrody.  Pierwszy  z  nich  to rezerwat  Pomiech�wek.  W  jego  obr�bie  mie�ci  si�  obszar zwany  puszcz�  pierwotn�  �  las zachowany  w  stanie  zbli�onym  do  naturalnego.  Podziwia�  tu  mo�na  rzadkie  okazy  d�b�w szypu�kowych  wysokich  na  30  metr�w.  Drugi  rezerwat  nosi  nazw�  Dolina  Wkry  i  zosta� powo�any do ochrony pozosta�o�ci las�w ��gowych � zbiorowisk le�nych regularnie zalewanych i nawo�onych przez rzek� Wkr�. <akapit2> <b>W</b>art  wizyty  jest  r�wnie�  obszar  �wietlistych  d�br�w  i  gr�d  w  Jab�onnej,  wpisany  do europejskiej  sieci  ochrony  przyrody  Natura  2000.  Miejsce  to  daje  mo�liwo��  obcowania  z zanikaj�cym  w  Polsce  lasem  d�bowym  oraz  szczeg�lnie  malownicz�  jego  odmian�  �  �wietlist� d�brow�, czyli typem lasu charakteryzuj�cym si� bogatym gatunkowo, bujnym runem; �wietliste d�browy  uwa�ane  s�  za  najbogatszy  florystycznie  zesp�  le�ny  Polski.  R�wnie  interesuj�ce  s� gr�dy,  czyli  lasy  poro�ni�te  przede  wszystkimi  grabami  i  d�bami.  Ciekawostk�  pozostaje  fakt wyst�powania   na   tym   terenie   siedlisk   d�b�w   bezszypu�kowych   osi�gaj�cych   imponuj�ce rozmiary � zar�wno je�li chodzi o wysoko��, jak i obw�d konar�w. <akapit3> <b>W</b>a�nym  elementem  pomiechowskiego  zasobu  le�nego  jest  zesp�  dwustuletnich  sosen, w�r�d  kt�rych  nestork�  pozostaje  sosna  Anna  rosn�ca  w  samym  centrum  Pomiech�wka. Niezwyk�e  walory  krajobrazowe  okolic  sprawiaj�,  �e  Pomiech�wek  sta�  si�  popularnym  w�r�d filmowc�w plenerem do realizowania polskich produkcji. To tutaj kr�cone by�y zdj�cia do wielu popularnych film�w, takich jak na przyk�ad �Nigdy w �yciu� z Danut� Stenk� w roli g��wnej.");
	 	  texten =  preferences.getString("foresttexten", "<akapit1><b>M</b>ore than one third of the area of Pomiech�wek is covered by forest. The local forests are anything but ordinary. They are strikingly different from the ones that grow on the sandy and dry soil that prevails in the area of Warsaw. The fertile moraine soil of Pomiech�wek (remnant of the last glacial period) is additionally enriched by regular river overflows. <akapit2> <b>T</b>he area offers perfect conditions for lush vegetation � pine, oak, larch and birch trees, and the abundance of plants of the forest understorey turn pleasure strolls around the area into a mesmerising adventure. The area of Pomiech�wek is home to two nature reserves. The first one is the Pomiech�wek Reserve, which includes an area of old-growth forest, preserved in a state that is close to natural. One of the local attractions are the rare 30 metre high pedunculate oaks. The second one, the Wkra Valley Reserve, was established to protect the remnants of riparian forest � regularly flooded and fertilised by the Wkra. <akapit3> <b>A</b>nother attractive area is that of thermophilous oak forests and hornbeam-oak forests in Jab�onna, listed as one of the nature protection areas within the European network Nature 2000. Here you can find an oak forest, which is becoming a rarity in Poland, and its particuarly picturesque thermophilous variation. One of the local curiosities are sessile oaks of monumental height and branch perimeter. A major feature of the Pomiech�wek forest is a complex of 200-year-old pine trees � the oldest of them, called Anna, grows right in the centre of Pomiech�wek. The unique picturesque landscapes of the area established Pomiech�wek as a popular shooting location for Polish films.");
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
