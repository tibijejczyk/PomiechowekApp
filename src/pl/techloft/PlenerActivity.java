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

public class PlenerActivity extends Activity implements OnTouchListener{


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
		setContentView(R.layout.activity_plener);


		 exit =(ImageView)findViewById(R.id.exit);

		 SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	 	   SharedPreferences.Editor editor = preferences.edit();

	 	  textpl =  preferences.getString("plenertextpl", "<akapit1><b>R</b>zeka, las, ��ki, pomniki kultury i przyrody � Pomiech�wek daje niesko�czon� liczb� pretekst�w i  okazji  do  sp�dzania  czasu  na  �wie�ym  powietrzu.  Okolica  jest  idealna  do  uprawiania nordic walkingu �  szybkiego  marszu  z  kijkami  odci��aj�cymi  stawy.  Popularn�  form�  aktywno�ci  s� r�wnie�  spacery  oraz  w�dr�wki  po  lesie.  Szczeg�lnej  uwadze  odwiedzaj�cych  Pomiech�wek polecamy  liczne  szlaki  turystyczne  oraz  �cie�ki  zdrowia  zlokalizowane  w  pobliskich  lasach. Opr�cz  szlak�w  pieszych  na  mi�o�nik�w  spacer�w  czeka  r�wnie�  PZU  Trasa  Zdrowia,  kt�r� wytyczono  w  okolicach  parku  linowego.  <akapit2> <b>D</b>ecyduj�c  si�  na  jej  przebycie,  b�dziecie  musieli pokona� rozmieszczone w lesie liczne drabinki, r�wnowa�nie, pacho�ki, por�cze i �aweczki. Dla dzieci  szczeg�ln�  atrakcj�   b�dzie  4-kilometrowa  �cie�ka  dydaktyczna  wytyczona  w   lesie pomi�dzy rezerwatem Pomiech�wek a dolin� Wkry. Spacer po tych okolicach stanowi znakomit� okazj� do poznania niezliczonej liczby gatunk�w ptak�w, grzyb�w, ro�lin i prawide� rz�dz�cych �yciem lasu. Na trasie �cie�ki zaplanowano r�wnie� miejsca do odpoczynku. Wycieczka t� tras� b�dzie wi�c nie tylko pouczaj�ca, ale przede wszystkim przyjemna! Na d�ugo�ci 1 kilometra trasa przystosowana  jest  do  u�ytkowania  przez  osoby  niepe�nosprawne.  Na  wszystkich  dbaj�cych  o rze�b� cia�a czekaj� r�wnie� si�ownie zewn�trzne ulokowane w pobli�u pomiechowskich pla�, a tak�e szlak konny wytyczony na terenie gminy.");
	 	  texten =  preferences.getString("plenertexten", "<akapit1><b>R</b>iver, forest, grasslands, monuments of culture and nature � Pomiech�wek offers an endless array of ideas and opportunities for spending leisure time outdooors. The area is ideal for nordic walking � fast-paced march with poles that unburden the joints. Popular local activities include pleasure strolls and roaming the forest. Highly recommended are the numerous tourist and fitness trails in the nearby forests � they are discussed in a separate chapter of the guide. Apart from those trails, enthusiasts of hiking are encouraged to explore the PZU Fitness Trail in the vicinity of the Ropes Course. Face the challenge of making your way through countless ladders, balance beams, bollards, handrails and benches. <akapi2><b>A</b> special attraction for kids, a 4-kilometre education trail in the forest connects the Pomiech�wek Reserve with the valley of the river Wkra. It offers an opportunity to learn about a wide array of bird, fungus and plant species, as well as discover the laws that govern the life of the forest. The trail also features perfect spots to take some rest. Hiking this trail is a perfect way to combine learning about natural life with the bliss of relaxation! A 1-kilometre stretch of the trail is accessible for people with disabilities. All those with a drive for bodybuilding are invited to use outdoor gyms installed near the Pomiech�wek beaches; the area also boasts a local horse trail.");
	 	  headerpl = preferences.getString("plenerheaderpl", "Plenerowe aktywno�ci");
	 	  headeren = preferences.getString("plenerheaderen", "Outdoor activites");


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


		picture1 = (ImageView) findViewById(R.id.imageView2);
		picture2 = (ImageView) findViewById(R.id.imageView3);



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
		String text2edited = finalText.substring(finalText.lastIndexOf("<akapit2>"), finalText.length()).replace("<akapit2>", "     ");


		text.setText(Html.fromHtml(text1edited));
		text1.setText(Html.fromHtml(text2edited));

        header.setText(finalHeader);



		Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-95Black.ttf");
		Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/disp/NeueHaasGrotDisp-55Roman.ttf");

		header.setTypeface(tf);
		text.setTypeface(tf1);
		text1.setTypeface(tf1);



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
