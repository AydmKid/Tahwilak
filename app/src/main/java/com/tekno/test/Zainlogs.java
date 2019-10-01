package com.tekno.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Zainlogs extends AppCompatActivity  {


    List<NumberAmount> list = new ArrayList<>() ;
    RecyclerView myRecycler;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zainlogs);



        String data = getIntent().getStringExtra("log");
        String cash = getIntent().getStringExtra("logno");



        myRecycler = (RecyclerView) findViewById(R.id.recycler_view);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));


        SharedPreferences.Editor editor;
        SharedPreferences prf = getSharedPreferences("ali",MODE_PRIVATE);
        editor = getSharedPreferences("ali", MODE_PRIVATE).edit();


        if(data != null) {
            list.add(new NumberAmount(data,cash));

        }

        String getlist1 = prf.getString("logs", "");
        String[] final_list = getlist1.split(",");
        String getlist12 = prf.getString("logs1", "");
        String[] final_list2 = getlist12.split(",");


        for(int i = 0 ; i < final_list.length ; i++) {
            list.add(new NumberAmount(final_list[i], final_list2[i]));
        }

        if (data != null) {
            String getlist = prf.getString("logs", "");
            String[] list_open = getlist.split(",");

            String getlist3 = prf.getString("logs1", "" );
            String[] list_open3 = getlist3.split(",");

            StringBuilder mylist = new StringBuilder();

            for(int i = 0 ; i < list_open.length ; i++) {
                if (i == 0) {
                    mylist.append(data);
                    mylist.append(",");
                }
                mylist.append(list_open[i]);
                mylist.append(",");
            }

            StringBuilder mylist2 = new StringBuilder();

            for(int i = 0 ; i < list_open3.length ; i++) {
                if (i == 0) {
                    mylist2.append(cash);
                   mylist2.append(",");
                }
                mylist2.append(list_open3[i]);
                mylist2.append(",");
            }

            editor.putString("logs", mylist.toString());
            editor.putString("logs1", mylist2.toString());
            editor.commit();
        }

        RecyclerViewAdater adater = new RecyclerViewAdater(list);
        myRecycler.setAdapter(adater);


      }



}


