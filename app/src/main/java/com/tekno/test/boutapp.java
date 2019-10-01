package com.tekno.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class boutapp extends AppCompatActivity {

    ImageView ali , omer ;
    ArrayList<String> arrayList , arrayList1 ;
    ArrayAdapter<String> adapter , adapter1 ;
    ListView infoo , om ;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutapp);



        infoo = (ListView) findViewById(R.id.listonee);





        //ali = (ImageView) findViewById(R.id.aliid);



        arrayList =   new ArrayList<String>();

        adapter   =   new ArrayAdapter<String>(boutapp.this,android.R.layout.simple_list_item_1,arrayList);

        infoo.setAdapter(adapter);


        arrayList.add(" Name : Ali yousuf (Tekno)");
        arrayList.add(" Email : aydmkid@gmail.com");
        arrayList.add(" Phone number : 0906911462");
        arrayList.add(" Facebbook page : Ali yousuf (Tekno) ");


        infoo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0 :
                        Toast.makeText(getApplicationContext(),"Ali",Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Intent intet = new Intent(Intent.ACTION_VIEW);
                        intet.setData(Uri.parse("http://www.Gmail.com"));
                        startActivity(intet);
                        break;
                    case 2 :
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        startActivity(intent);
                        break;
                    case 3 :
                        Intent inte = new Intent(Intent.ACTION_VIEW);
                        inte.setData(Uri.parse("http://www.facebook.com"));
                        startActivity(inte);
                        break;
                }

            }
        });







    }

}
