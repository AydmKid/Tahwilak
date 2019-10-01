package com.tekno.test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

public class splash_screen extends AppCompatActivity {


    private static int splash_time_out = 1200;

    TextView tekno;
    ToggleButton toggle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splash_screen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },splash_time_out);


        tekno = (TextView) findViewById(R.id.tek);

        final Animation zainani = AnimationUtils.loadAnimation(splash_screen.this,R.anim.fade);
        tekno.startAnimation(zainani);



    }




}



