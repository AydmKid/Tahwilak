package com.tekno.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 9/29/2019.
 */

public class ExampleAdapterActive extends RecyclerView.Adapter<ExampleAdapterActive.ExampleViewHolder> {
    private ArrayList<ExampleItemActive> mExampleListActive;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onActiveClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public Button mbutton;

        public ExampleViewHolder(View itemView , final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageViewActive);
            mTextView1 = itemView.findViewById(R.id.textViewActive);
            mTextView2 = itemView.findViewById(R.id.textViewActive2);
            mbutton    = itemView.findViewById(R.id.btnActive);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            mbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onActiveClick(position);
                        }
                    }

                }
            });

        }
    }

    public ExampleAdapterActive(ArrayList<ExampleItemActive> exampleList){

        mExampleListActive = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_itemacitve,parent,false);
            ExampleViewHolder evh = new ExampleViewHolder(v , mListener);
            return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        ExampleItemActive currentItem = mExampleListActive.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mExampleListActive.size();
    }
}
