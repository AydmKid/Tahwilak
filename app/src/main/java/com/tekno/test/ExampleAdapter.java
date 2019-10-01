package com.tekno.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 9/27/2019.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListner mListner;

    public interface OnItemClickListner{
        void onItemClick(int position);
    }

    public void setOnItemClickListenr(OnItemClickListner listenr){

        mListner = listenr;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageview;
        public TextView mTextview1;
        public TextView mTextview2;


        public ExampleViewHolder(View itemView , final OnItemClickListner listner) {
            super(itemView);

            mImageview = itemView.findViewById(R.id.imageView11);
            mTextview1 = itemView.findViewById(R.id.textView1h);
            mTextview2 = itemView.findViewById(R.id.textView2h);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listner != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listner.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {

        mExampleList = exampleList;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v , mListner);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {

        final ExampleItem currentItem = mExampleList.get(position);
        holder.mImageview.setImageResource(currentItem.getImageResource());
        holder.mTextview1.setText(currentItem.getText1());
        holder.mTextview2.setText(currentItem.getText2());

        holder.mTextview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }

    @Override
    public int getItemCount() {
        return mExampleList.size() ;
    }
}
