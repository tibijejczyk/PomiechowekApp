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


	 	  textpl =  preferences.getString("monumentstextpl", "<akapit1><B>P</b>omiech�wek to miejsce nie tylko o du�ych walorach przyrodniczych, ale i o bogatym dziedzictwie historycznym oraz kulturowym. W I wieku przed nasz� er� przebiega� t�dy szlak bursztynowy. Pierwsze pisemne wzmianki o wsi Pomiechowo datowane s� na XII wiek naszej ery. W XIX wieku Pomiech�wek stanowi� istny tygiel kulturowy, w kt�rym kultura polska miesza�a si� z wp�ywami niemieckimi, rosyjskimi i �ydowskimi. O bogatej historii tego miejsca �wiadcz� zabytki rozlokowane na terenie ca�ej gminy.<akapit2><B>D</b>o najstarszych i najciekawszych zabytk�w nale�y ko�ci� parafialny �wi�tej Anny w Pomiechowie � najstarszej osadzie w granicach Pomiech�wka. Budowla datowana jest na 1415 rok, a projekt jej wn�trza przypisuje si� Janowi Bapty�cie z Wenecji, odpowiedzialnemu mi�dzy innymi za przebudow� monumentalnej kolegiaty w Pu�tusku. Bry�a ko�cio�a, najlepiej widoczna z pobliskiego Stanis�awowa, by�a wielokrotnie przebudowywana i s�u�y� mo�e za praktyczny podr�cznik do nauki styl�w architektonicznych, pocz�wszy od gotyku, przez renesans, a na baroku ko�cz�c. Rzymskokatolicka parafia zaprasza do udzia�u we mszach �wi�tych, kt�re odbywaj� si� w dni powszednie w godzinach 7.15, 17.30, 18.00 oraz w niedziele w godzinach 7.00, 9.00, 10.30, 12.00 i 16.00.<akapit3><B>K</b>olejnym zabytkiem godnym odwiedzenia podczas wizyty w Pomiech�wku jest prawos�awna cerkiew �w. Aleksandry M�czennicy w Stanis�awowie. Jej budowa trwa�a od 1844 do 1846 roku wed�ug projektu warszawskiego architekta Jana Jakuba Gaya, autora mi�dzy innymi gmachu Banku Polskiego i Gie�dy na placu Bankowym w Warszawie oraz nieistniej�cego ju� obelisku ku czci cara Aleksandra I na warszawskiej Cytadeli. Jak �atwo si� domy�li�, budowa cerkwi zwi�zana by�a z intensywn� akcj� osadnicz� prowadzon� na tych terenach przez carat w XIX wieku. Pomiechowska cerkiew dwukrotnie odwiedzana by�a przez w�adc�w rosyjskich � w 1834 roku by� tu car Aleksander III, a pi�� lat p�niej car Miko�aj II. Cerkiew jest aktywna do dnia dzisiejszego, miejscowa wsp�lnota zaprasza na nabo�e�stwa codziennie o godzinie 17.00 oraz w niedziele o godzinie 10.00 (od wrze�nia do maja) lub 9.00 (w czerwcu i sierpniu).<akapit4><B>N</b>iew�tpliwie najciekawsz� atrakcj� Pomiech�wka pozostaje rozbudowany system umocnie� fortowych wchodz�cych w sk�ad historycznej twierdzy Modlin. Wybudowany w latach 1883�1888 fort III Pomiech�wek obok samej twierdzy stanowi� najwa�niejszy element tego XIX-wiecznego systemu umocnie� Warszawy. Fort ulokowany na pag�rku na prawym brzegu Wkry posiada� bezpo�rednie po��czenie kolejowe z twierdz� Modlin oraz z maj�tkiem w Pomiech�wku. Okoliczne lasy s�u�y�y za teren polowa� dla wysokich rang� wojskowych. Cho� wielokrotnie modernizowany i przebudowywany fort III jest najwi�kszy i najbardziej spektakularny, w okolicy znajduje si� tak�e kilka r�wnie interesuj�cych zespo��w umocnie� � grupa fortowa Carski Dar, fort XVI czy grupa fortowa w Go�awicach oraz oczywi�cie sama twierdza Modlin. Wszystkie po��czone s� rowerow� tras� tematyczn�. Ich zwiedzanie mo�liwe jest jedynie z przewodnikiem po wcze�niejszym um�wieniu si� z Towarzystwem Przyjaci� Twierdzy Modlin.");

	 	  texten =  preferences.getString("monumentstexten", "<akapit1><b>P</b>omiech�wek boasts not only outstanding natural values, but also a rich cultural and historical heritage. In the 1st century BC the area was situated on the Amber Road. The first written mentions about the village of Pomiechowo date back to the 12th century AD, and in the 19th century Pomiech�wek became a true cultural melting pot where Polish culture witnessed significant German, Russian and Jewish influences. Bearing testimony to the rich history of the place are its historic monuments located throughout the area. One of the oldest and most fascinating of those monuments is the St. Anna parish church in the village of Pomiechowo, the most ancient settlement in the area. The temple is dated to 1415, and its interior decoration is attributed to Giovanni Battista of Venice, who was in charge of the redevelopment of the monumental collegiate church in Pu�tusk, among other projects. The shell of the Pomiechowo church, best viewed from the nearby village of Stanis�aw�w, has witnessed a range of modifications and can perfectly serve as a practical handbook of architectural styles, from Gothic, to Renaissance, to Baroque. The Roman Catholic parish celebrates the holy mass at 7:15 am, 5:30 pm and 6 pm on weekdays, and at 7 am, 9 am, 10:30 am, noon and 4 pm on Sundays.<akapit2><b>A</b>nother historic monument that cannot be missed is the Orthodox church of St. Alexandra the Martyr in Stanis�aw�w. The temple was built between 1844 and 1846. The architect, Jan Jakub Gay (b. 1801) contributed with a number of prestigious designs, such as the edifice of the Bank of Poland and the Exchange Building in Warsaw's Bankowy Square, as well as the already non-existent obelisk in honour of Tsar Alexander I on the premises of the Warsaw Citadel. From a broader perspective, the construction of the Orthodox church was part of the intensive settlement efforts pursued in the area by the Russian Tsars in the 19th century. The emperors paid two visits to the Pomiech�wek temple � Tsar Alexander III came here in 1834, followed five years later by Nicholas II. The Orthodox church operates until the present day and the local community celebrates holy mass everyday at 5 pm and on Sundays at 10 am (September � May) or 9 am (in June and August).<akapit3><b>P</b>omiech�wek's greatest attraction is its elaborate system of fortifications that form part of the historic Modlin Fortress. Erected between 1883 and 1888, Fort III Pomiech�wek functioned as the most important element of the 19th century fortifications of Warsaw after the Modlin Fortress itself. Located on a hill on the right bank of the Wkra, it had a direct railway connection with the Modlin Fortress and the estate in Pomiech�wek. <akapit4><b>T</b>he nearby forests served as a hunting ground for high-rank military officers. Despite numerous modernisations and redevelopments, Fort III is the largest and most spectacular fortification, but the area also features a number of smaller complexes � the �Carski Dar� [�Tsar's Gift�] complex, Fort XVI, or the cluster of fortifications in Go�awice, apart from the Modlin Fortress itself. They are all connected by a bicycle route, purpose designed to feature the local fortifications. Sightseeing is possible only upon prior arrangement with the Society of Friends of the Modlin Fortress (TPTM).");
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
