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

public class Mtnlogs extends AppCompatActivity {

    List<NumberAmount> mtlist = new ArrayList<>() ;
    RecyclerView mtmyRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtnlogs);


        String mtdata = getIntent().getStringExtra("mtlog");
        String mtcash = getIntent().getStringExtra("mtlogno");

        mtmyRecycler = (RecyclerView) findViewById(R.id.recycler_viewmt);

        mtmyRecycler.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences.Editor editor;
        SharedPreferences prf = getSharedPreferences("mtali",MODE_PRIVATE);
        editor = getSharedPreferences("mtali", MODE_PRIVATE).edit();


        if( mtdata != "") {
            mtlist.add(new NumberAmount(mtdata, mtcash));
        }



        String getlist1 = prf.getString("mtlogs", "");
        String[] final_list = getlist1.split(",");
        String getlist12 = prf.getString("mtlogs1", "");
        String[] final_list2 = getlist12.split(",");

        for(int i = 0 ; i < final_list.length ; i++) {
            mtlist.add(new NumberAmount(final_list[i], final_list2[i]));
        }

        if (mtdata != "") {
            String getlist = prf.getString("mtlogs", "");
            String[] list_open = getlist.split(",");

            String getlist3 = prf.getString("mtlogs1", "");
            String[] list_open3 = getlist3.split(",");

            StringBuilder mylist = new StringBuilder();

            for(int i = 0 ; i < list_open.length ; i++) {
                if (i == 0) {
                    mylist.append(mtdata);
                    mylist.append(",");
                }
                mylist.append(list_open[i]);
                mylist.append(",");
            }

            StringBuilder mylist2 = new StringBuilder();

            for(int i = 0 ; i < list_open3.length ; i++) {
                if (i == 0) {
                    mylist2.append(mtcash);
                    mylist2.append(",");
                }
                mylist2.append(list_open3[i]);
                mylist2.append(",");
            }

            editor.putString("mtlogs", mylist.toString());
            editor.putString("mtlogs1", mylist2.toString());
            editor.apply();
        }
        RecyclerViewAdater adater = new RecyclerViewAdater(mtlist);

        mtmyRecycler.setAdapter(adater);

    }
}
