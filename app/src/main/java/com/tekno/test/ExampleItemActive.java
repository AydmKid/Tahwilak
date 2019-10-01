package com.tekno.test;

/**
 * Created by user on 9/29/2019.
 */

public class ExampleItemActive {
    private int mImageResource ;
    private String mtext1;
    private String mtext2;

    public ExampleItemActive (int imageResource , String text1 , String text2){
        mImageResource = imageResource;
        mtext1 = text1;
        mtext2 = text2;
    }
    public int getImageResource(){
        return mImageResource;
    }
    public String getText1(){
        return mtext1;
    }
    public String getText2(){
        return mtext2;
    }
}
