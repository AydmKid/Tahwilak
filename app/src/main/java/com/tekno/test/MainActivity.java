package com.tekno.test;

import android.Manifest;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView cll;
    ImageView btn;
    Button btn1 ;
    Button btn2 ;
    EditText num , kash , kod , balan ;
    static String snum  , cod , caash ,bl;
    static String key = "*200*";
    static String star = "*";
    String en = Uri.encode("#");
    String ussd = "*" + en + "12345" + en ;
    public static final String pre_name = "my";
    public static final String pre = "one";
    public static String sec , no1 ,vno1 , vno11 ,vam, am;
    private SharedPreferences myprefs;
    public static final String def = "Empty";

    ArrayList<String> addarray = new ArrayList<String>();
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.entrcod));
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sec=input.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("password" , sec);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Savecode",Toast.LENGTH_LONG).show();
            }
        });
        SharedPreferences sav = getSharedPreferences(pre_name , 0);
        boolean dialog = sav.getBoolean("dialog" , false);
        if (!dialog){
            SharedPreferences.Editor editor = sav.edit();
            builder.show();
            editor.putBoolean("dialog" , true);
            editor.apply();
        }



          Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));



    }

    public void moodee(){

        getWindow().getDecorView().setBackgroundColor(Color.parseColor("FF0000"));


    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           switch (position){
               case 0 :
                   Zain   tab1 = new Zain();
                   return tab1 ;
               case 1:
                   Sudani tab2 = new Sudani();
                   return tab2;
               case 2:
                   MTN    tab3 = new MTN();
                   return tab3;
                   default:
                       return null;
           }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
    }

}
