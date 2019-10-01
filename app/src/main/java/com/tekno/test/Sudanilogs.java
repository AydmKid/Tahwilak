package com.tekno.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Sudanilogs extends AppCompatActivity {


    List<NumberAmount> sulist = new ArrayList<>() ;
    RecyclerView sumyRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudanilogs);


        String sudata = getIntent().getStringExtra("sulog");
        String sucash = getIntent().getStringExtra("sulogno");

        sumyRecycler = (RecyclerView) findViewById(R.id.recycler_viewsu);

        sumyRecycler.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences.Editor editor;
        SharedPreferences prf = getSharedPreferences("suali",MODE_PRIVATE);
        editor = getSharedPreferences("suali", MODE_PRIVATE).edit();


        if( sudata != "") {
            sulist.add(new NumberAmount(sudata, sucash));
        }



        String sugetlist1 = prf.getString("sulogs", "");
        String[] sufinal_list = sugetlist1.split(",");
        String sugetlist12 = prf.getString("sulogs1", "");
        String[] sufinal_list2 = sugetlist12.split(",");

        for(int i = 0 ; i < sufinal_list.length ; i++) {
            sulist.add(new NumberAmount(sufinal_list[i], sufinal_list2[i]));
        }

        if (sudata != "") {
            String getlist = prf.getString("sulogs", "");
            String[] list_open = getlist.split(",");

            String getlist3 = prf.getString("sulogs1", "");
            String[] list_open3 = getlist3.split(",");

            StringBuilder mylist = new StringBuilder();

            for(int i = 0 ; i < list_open.length ; i++) {
                if (i == 0) {
                    mylist.append(sudata);
                    mylist.append(",");
                }
                mylist.append(list_open[i]);
                mylist.append(",");
            }

            StringBuilder mylist2 = new StringBuilder();

            for(int i = 0 ; i < list_open3.length ; i++) {
                if (i == 0) {
                    mylist2.append(sucash);
                    mylist2.append(",");
                }
                mylist2.append(list_open3[i]);
                mylist2.append(",");
            }

            editor.putString("sulogs", mylist.toString());
            editor.putString("sulogs1", mylist2.toString());
            editor.apply();
        }
        RecyclerViewAdater adater = new RecyclerViewAdater(sulist);

        sumyRecycler.setAdapter(adater);


    }
}
