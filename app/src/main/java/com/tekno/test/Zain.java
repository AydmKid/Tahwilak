package com.tekno.test;

/**
 * Created by user on 15/06/18.
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.notbytes.barcode_reader.BarcodeReaderActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;



public class Zain extends Fragment {

    private static final int BARCODE_READER_ACTIVITY_REQUEST = 1208;

    Button bn ;
    ImageView cll;
    View pr;
    String en = Uri.encode("#");
    ArrayList<String> arrayList ;
    ArrayAdapter<String> adapter ;
    public  EditText num , kash , kod , balan ;
    static String snum  , cod , caash ,bl;
    static String key = "*200*";
    static String star = "*";
    public static final String pre_name = "my";
    public static final String pre = "one";
    public static String sec , no1 ,vno1 , vno11 ,vam, am;
    public static final String def = "Empty";
    private String password;
    static ListView Show;
    static String [] mu = {"a","b","c"};
    ArrayList<String> addarray = new ArrayList<String>();
    Intent intentshare;
    TextView zainview;
    Intent intentlist ;
    String telnum;
    EditText edtphncall;
    TextView textViewDate;
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        pr = inflater.inflate(R.layout.tabzain, container, false);



        bn         =    (Button)       pr.findViewById(R.id.idrasid);
        cll        =    (ImageView)    pr.findViewById(R.id.idbtnCall);
        num        =    (EditText)     pr.findViewById(R.id.idnum);
        kash       =    (EditText)     pr.findViewById(R.id.idcash);
        //Show       =    (ListView)     pr.findViewById(R.id.lisst);
        zainview   =    (TextView)     pr.findViewById(R.id.zainid);


       /* Calendar calendar =  Calendar.getInstance();
        System.out.println("Current time =>" + calendar.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy - MM - dd : mm : ss");
        String formattedDate = df.format(calendar.getTime());

        TextView textViewDate = (TextView)pr.findViewById(R.id.mytime);
        textViewDate.setText(formattedDate); */




       final Animation zainani = AnimationUtils.loadAnimation(getActivity(),R.anim.left);
       zainview.startAnimation(zainani);


        FloatingActionButton fab = pr.findViewById(R.id.fab);
        final Intent launchIntent = BarcodeReaderActivity.getLaunchIntent(getContext(), true, false);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(launchIntent, BARCODE_READER_ACTIVITY_REQUEST);
            }
        });




        cll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Animation zoombtn = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom);
                cll.startAnimation(zoombtn);

                no1 = num.getText().toString();
                SharedPreferences s = getActivity().getSharedPreferences("no2", MODE_PRIVATE);
                SharedPreferences.Editor e = s.edit();
                e.putString("num", no1);
                e.apply();
                vno1 = s.getString("num", def);

                am = kash.getText().toString();
                SharedPreferences sh = getActivity().getSharedPreferences("no2", MODE_PRIVATE);
                SharedPreferences.Editor ed = sh.edit();
                ed.putString("num", no1);
                ed.apply();
                vam = s.getString("num", def);

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences ("data", Context.MODE_PRIVATE);
                String password =  sharedPreferences.getString("password",def);

                Intent i = new Intent(Intent.ACTION_CALL);
                caash = kash.getText().toString();
                snum = num.getText().toString();


                if (snum == null || snum .trim().equals("") && caash == null || caash.trim().equals("") ) {

                    Toast.makeText(getContext(),getString(R.string.dataa),Toast.LENGTH_LONG).show();
                    i.setData(Uri.parse("tel : 00000000"));

                } else if(snum == null || snum.trim().equals("") && caash != null || caash.trim().equals(kash) ) {

                    Toast.makeText(getContext(),getString(R.string.nom),Toast.LENGTH_LONG).show();

                } else if (caash == null || caash.trim().equals("") && snum != null || snum.trim().equals(num)){

                    Toast.makeText(getContext(),getString(R.string.amnt),Toast.LENGTH_LONG).show();

                } else {

                    i.setData(Uri.parse("tel:" + key + password + star + caash + star + snum + star + snum + en));

                }


                if  (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getContext(), "please granted", Toast.LENGTH_LONG).show();
                    requestPermission();

                } else {
                    try {
                        startActivity(i);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }


            }

        });



        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation zoombtn = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom);
                bn.startAnimation(zoombtn);

                Intent r = new Intent(Intent.ACTION_CALL);
                if (bn.isPressed()){
                    r.setData(Uri.parse("tel:" + star+ 888 + en));

                } else {
                    r.setData(Uri.parse("tel : 00000000"));
                }
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(),"please",Toast.LENGTH_LONG).show();
                    requestPermission();
                } else {
                    startActivity(r);
                }
            }
        });


        setHasOptionsMenu(true);
        return pr;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK) {
            Toast.makeText(getContext(), "error in  scanning", Toast.LENGTH_SHORT).show();
            return;
        }

        if (requestCode == BARCODE_READER_ACTIVITY_REQUEST && data != null) {
            Barcode barcode = data.getParcelableExtra(BarcodeReaderActivity.KEY_CAPTURED_BARCODE);
            //Toast.makeText(getContext(), barcode.rawValue, Toast.LENGTH_SHORT).show();
            Intent r = new Intent(Intent.ACTION_CALL);
            r.setData(Uri.parse("tel:" + star + 888 + star + barcode.rawValue + en));
            startActivity(r);
        }

    }


    public void diszain(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        password =  sharedPreferences.getString("password",def);
        final AlertDialog.Builder viewcod = new AlertDialog.Builder(getActivity());
        viewcod.setTitle(getString(R.string.kud));
        viewcod.setMessage(password);
        viewcod.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        viewcod.show();
    }

    public void youtube(){

        Intent browserinternt = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com"));
        startActivity(browserinternt);

    }



    public void Editzain(){
        AlertDialog.Builder edit = new AlertDialog.Builder(getActivity());
        edit.setTitle(getString(R.string.nwcod));
        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        edit.setView(input);

        edit.setPositiveButton(getString(R.string.sv), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sec=input.getText().toString();
                if (sec.trim().isEmpty()){
                    Toast.makeText(getContext(),getString(R.string.dat),Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("password" , sec);
                    editor.apply();
                    Toast.makeText(getContext(),getString(R.string.savco),Toast.LENGTH_LONG).show();
                }
            }
        });
        edit.show();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2 :
                diszain();
                return true;
            case R.id.item3 :
                Editzain();
                return true;
            case R.id.item5 :
                intentlist = new Intent(getActivity(),Zainlogs.class);
                intentlist.putExtra("log", num.getText().toString());
                intentlist.putExtra("logno", kash.getText().toString());
                startActivity(intentlist);
                num.setText("");
                kash.setText("");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void requestPermission() {
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
