package com.tekno.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Choseone extends AppCompatActivity {

    Button zainbutton , mtnbutton , sudanibutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choseone);

        zainbutton   = (Button)findViewById(R.id.zainco);
        mtnbutton    = (Button)findViewById(R.id.mtnco);
        sudanibutton = (Button)findViewById(R.id.sudanico);

        zainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Choseone.this,ActiveService.class);
                startActivity(i);
            }
        });

        mtnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sudanibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
