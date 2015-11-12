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

public class ZabytkiActivity extends Activity implements OnTouchListener{


	TextView header, text, text1, text2, text3;

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
		setContentView(R.layout.activity_zabytki);

	    exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();


	 	  textpl =  preferences.getString("monumentstextpl", "<akapit1><B>P</b>omiechówek to miejsce nie tylko o du¿ych walorach przyrodniczych, ale i o bogatym dziedzictwie historycznym oraz kulturowym. W I wieku przed nasz¹ er¹ przebiega³ têdy szlak bursztynowy. Pierwsze pisemne wzmianki o wsi Pomiechowo datowane s¹ na XII wiek naszej ery. W XIX wieku Pomiechówek stanowi³ istny tygiel kulturowy, w którym kultura polska miesza³a siê z wp³ywami niemieckimi, rosyjskimi i ¿ydowskimi. O bogatej historii tego miejsca œwiadcz¹ zabytki rozlokowane na terenie ca³ej gminy.<akapit2><B>D</b>o najstarszych i najciekawszych zabytków nale¿y koœció³ parafialny œwiêtej Anny w Pomiechowie – najstarszej osadzie w granicach Pomiechówka. Budowla datowana jest na 1415 rok, a projekt jej wnêtrza przypisuje siê Janowi Baptyœcie z Wenecji, odpowiedzialnemu miêdzy innymi za przebudowê monumentalnej kolegiaty w Pu³tusku. Bry³a koœcio³a, najlepiej widoczna z pobliskiego Stanis³awowa, by³a wielokrotnie przebudowywana i s³u¿yæ mo¿e za praktyczny podrêcznik do nauki stylów architektonicznych, pocz¹wszy od gotyku, przez renesans, a na baroku koñcz¹c. Rzymskokatolicka parafia zaprasza do udzia³u we mszach œwiêtych, które odbywaj¹ siê w dni powszednie w godzinach 7.15, 17.30, 18.00 oraz w niedziele w godzinach 7.00, 9.00, 10.30, 12.00 i 16.00.<akapit3><B>K</b>olejnym zabytkiem godnym odwiedzenia podczas wizyty w Pomiechówku jest prawos³awna cerkiew œw. Aleksandry Mêczennicy w Stanis³awowie. Jej budowa trwa³a od 1844 do 1846 roku wed³ug projektu warszawskiego architekta Jana Jakuba Gaya, autora miêdzy innymi gmachu Banku Polskiego i Gie³dy na placu Bankowym w Warszawie oraz nieistniej¹cego ju¿ obelisku ku czci cara Aleksandra I na warszawskiej Cytadeli. Jak ³atwo siê domyœliæ, budowa cerkwi zwi¹zana by³a z intensywn¹ akcj¹ osadnicz¹ prowadzon¹ na tych terenach przez carat w XIX wieku. Pomiechowska cerkiew dwukrotnie odwiedzana by³a przez w³adców rosyjskich – w 1834 roku by³ tu car Aleksander III, a piêæ lat póŸniej car Miko³aj II. Cerkiew jest aktywna do dnia dzisiejszego, miejscowa wspólnota zaprasza na nabo¿eñstwa codziennie o godzinie 17.00 oraz w niedziele o godzinie 10.00 (od wrzeœnia do maja) lub 9.00 (w czerwcu i sierpniu).<akapit4><B>N</b>iew¹tpliwie najciekawsz¹ atrakcj¹ Pomiechówka pozostaje rozbudowany system umocnieñ fortowych wchodz¹cych w sk³ad historycznej twierdzy Modlin. Wybudowany w latach 1883–1888 fort III Pomiechówek obok samej twierdzy stanowi³ najwa¿niejszy element tego XIX-wiecznego systemu umocnieñ Warszawy. Fort ulokowany na pagórku na prawym brzegu Wkry posiada³ bezpoœrednie po³¹czenie kolejowe z twierdz¹ Modlin oraz z maj¹tkiem w Pomiechówku. Okoliczne lasy s³u¿y³y za teren polowañ dla wysokich rang¹ wojskowych. Choæ wielokrotnie modernizowany i przebudowywany fort III jest najwiêkszy i najbardziej spektakularny, w okolicy znajduje siê tak¿e kilka równie interesuj¹cych zespo³ów umocnieñ – grupa fortowa Carski Dar, fort XVI czy grupa fortowa w Go³awicach oraz oczywiœcie sama twierdza Modlin. Wszystkie po³¹czone s¹ rowerow¹ tras¹ tematyczn¹. Ich zwiedzanie mo¿liwe jest jedynie z przewodnikiem po wczeœniejszym umówieniu siê z Towarzystwem Przyjació³ Twierdzy Modlin.");

	 	  texten =  preferences.getString("monumentstexten", "<akapit1><b>P</b>omiechówek boasts not only outstanding natural values, but also a rich cultural and historical heritage. In the 1st century BC the area was situated on the Amber Road. The first written mentions about the village of Pomiechowo date back to the 12th century AD, and in the 19th century Pomiechówek became a true cultural melting pot where Polish culture witnessed significant German, Russian and Jewish influences. Bearing testimony to the rich history of the place are its historic monuments located throughout the area. One of the oldest and most fascinating of those monuments is the St. Anna parish church in the village of Pomiechowo, the most ancient settlement in the area. The temple is dated to 1415, and its interior decoration is attributed to Giovanni Battista of Venice, who was in charge of the redevelopment of the monumental collegiate church in Pu³tusk, among other projects. The shell of the Pomiechowo church, best viewed from the nearby village of Stanis³awów, has witnessed a range of modifications and can perfectly serve as a practical handbook of architectural styles, from Gothic, to Renaissance, to Baroque. The Roman Catholic parish celebrates the holy mass at 7:15 am, 5:30 pm and 6 pm on weekdays, and at 7 am, 9 am, 10:30 am, noon and 4 pm on Sundays.<akapit2><b>A</b>nother historic monument that cannot be missed is the Orthodox church of St. Alexandra the Martyr in Stanis³awów. The temple was built between 1844 and 1846. The architect, Jan Jakub Gay (b. 1801) contributed with a number of prestigious designs, such as the edifice of the Bank of Poland and the Exchange Building in Warsaw's Bankowy Square, as well as the already non-existent obelisk in honour of Tsar Alexander I on the premises of the Warsaw Citadel. From a broader perspective, the construction of the Orthodox church was part of the intensive settlement efforts pursued in the area by the Russian Tsars in the 19th century. The emperors paid two visits to the Pomiechówek temple – Tsar Alexander III came here in 1834, followed five years later by Nicholas II. The Orthodox church operates until the present day and the local community celebrates holy mass everyday at 5 pm and on Sundays at 10 am (September – May) or 9 am (in June and August).<akapit3><b>P</b>omiechówek's greatest attraction is its elaborate system of fortifications that form part of the historic Modlin Fortress. Erected between 1883 and 1888, Fort III Pomiechówek functioned as the most important element of the 19th century fortifications of Warsaw after the Modlin Fortress itself. Located on a hill on the right bank of the Wkra, it had a direct railway connection with the Modlin Fortress and the estate in Pomiechówek. <akapit4><b>T</b>he nearby forests served as a hunting ground for high-rank military officers. Despite numerous modernisations and redevelopments, Fort III is the largest and most spectacular fortification, but the area also features a number of smaller complexes – the “Carski Dar” [“Tsar's Gift”] complex, Fort XVI, or the cluster of fortifications in Go³awice, apart from the Modlin Fortress itself. They are all connected by a bicycle route, purpose designed to feature the local fortifications. Sightseeing is possible only upon prior arrangement with the Society of Friends of the Modlin Fortress (TPTM).");
	 	  headerpl = preferences.getString("monumentsheaderpl", "Zabytki");
	 	  headeren = preferences.getString("monumentsheaderen", "Historic Monuments");


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
		text3  = (TextView) findViewById(R.id.text8);


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
		String text3edited = finalText.substring(finalText.lastIndexOf("<akapit3>"), finalText.indexOf("<akapit4>")).replace("<akapit3>", "     ");
		String text4edited = finalText.substring(finalText.lastIndexOf("<akapit4>"), finalText.trim().length()).replace("<akapit4>", "     ");



		text.setText(Html.fromHtml(text1edited));
		text1.setText(Html.fromHtml(text2edited));
		text2.setText(Html.fromHtml(text3edited));
		text3.setText(Html.fromHtml(text4edited));
		 header.setText(finalHeader);

		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-95Black.ttf");
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-55Roman.ttf");

		header.setTypeface(tf);
		text.setTypeface(tf1);
		text1.setTypeface(tf1);
		text2.setTypeface(tf1);
		text3.setTypeface(tf1);

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
