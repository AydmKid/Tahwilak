package com.tekno.test;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by user on 15/06/18.
 */

public class MTN extends Fragment {

    Button bn ;
    ImageView cll;
    View pr;
    String en = Uri.encode("#");
    EditText num , kash , kod , balan ;
    static String snum  , cod , caash ,bl;
    static String key = "*121*";
    static String star = "*";
    public static final String pre_name = "my";
    public static final String pre = "one";
    public static String secmtn , no1 ,vno1 , vno11 ,vam, am;
    public static final String def = "Empty";
    TextView mtnview;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        pr = inflater.inflate(R.layout.tabmtn, container, false);


        bn    =  (Button) pr.findViewById(R.id.idrasid);
        cll   =  (ImageView)pr.findViewById(R.id.idbtnCall);
        num   =  (EditText)   pr.findViewById(R.id.idnum);
        kash  =  (EditText)   pr.findViewById(R.id.idcash);
        mtnview=(TextView)  pr.findViewById(R.id.mtnid);



        final Animation zainani = AnimationUtils.loadAnimation(getActivity(),R.anim.left);
        mtnview.startAnimation(zainani);



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


                SharedPreferences sharedPreferences = getActivity().getSharedPreferences ("datamtn", Context.MODE_PRIVATE);
                String passwordmtn =  sharedPreferences.getString("passwordmtn",def);

                Intent i = new Intent(Intent.ACTION_CALL);
                caash = kash.getText().toString();
                snum = num.getText().toString();



                if (snum == null || snum .trim().equals("") && caash == null || caash.trim().equals("") ) {


                    Toast.makeText(getContext(),getString(R.string.dataa),Toast.LENGTH_LONG).show();
                    i.setData(Uri.parse("tel : 00000000"));

                } else if(snum == null || snum.trim().equals("")) {

                    Toast.makeText(getContext(),getString(R.string.nom),Toast.LENGTH_LONG).show();


                } else if (caash == null || caash.trim().equals("")){

                    Toast.makeText(getContext(),getString(R.string.amnt),Toast.LENGTH_LONG).show();

                } else {

                    i.setData(Uri.parse("tel:" + key + snum  + star + caash + star + passwordmtn + en));


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
                    r.setData(Uri.parse("tel:" + star+ 141 + en));

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


    public void dismtn(){
        SharedPreferences sharedPreferencesmtn = getActivity().getSharedPreferences("datamtn", Context.MODE_PRIVATE);
        String passwordmtn =  sharedPreferencesmtn.getString("passwordmtn",def);
        final AlertDialog.Builder viewcodmtn = new AlertDialog.Builder(getActivity());
        viewcodmtn.setTitle(getString(R.string.kud));
        viewcodmtn.setMessage(passwordmtn);
        viewcodmtn.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        viewcodmtn.show();
    }

    public void sharmtn(){
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text");
        String sharebody = "Here is the share";
        String sharesub = "Here is the share";
        share.putExtra(Intent.EXTRA_SUBJECT,sharesub);
        share.putExtra(Intent.EXTRA_TEXT,sharebody);
        startActivity(Intent.createChooser(share,"share via"));
    }

    public void Editmtn(){
        AlertDialog.Builder edit = new AlertDialog.Builder(getActivity());
        edit.setTitle(getString(R.string.nwcod));
        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        edit.setView(input);
        edit.setPositiveButton(getString(R.string.sv), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                secmtn=input.getText().toString();
                if (secmtn.trim().isEmpty()){
                    Toast.makeText(getContext(),getString(R.string.dat),Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("datamtn",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("passwordmtn" , secmtn);
                    editor.apply();
                    Toast.makeText(getContext(),getString(R.string.savco),Toast.LENGTH_LONG).show();
                }
            }
        });
        edit.show();
    }


    public void aboutmtn(){
        AlertDialog.Builder bout = new AlertDialog.Builder(getActivity());
        bout.setTitle(getString(R.string.abou));
        bout.setMessage(" \t\t\t programmer \t TeKnO \n\t\t\t Designer \t\t\t SaMmi  \n\n \t\t\t For more Info Call us : " +
                "\n\t\t\t +249922513385 " +
                " \t\t\t\t   \n\n\t\t\t  Thank you for using Balance ^_^  "  );
        bout.setPositiveButton(getString(R.string.thank), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        bout.show();
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
                dismtn();
                return true;
            case R.id.item3 :
                Editmtn();
                return true;
            case R.id.item5 :
                Intent i = new Intent(getActivity(),Mtnlogs.class);
                i.putExtra("mtlog", num.getText().toString());
                i.putExtra("mtlogno", kash.getText().toString());
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void requestPermission() {
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
    }
}