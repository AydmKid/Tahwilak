package com.tekno.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 07/08/18.
 */

public class RecyclerViewAdater extends RecyclerView.Adapter<RecyclerViewAdater.myViewHolder> {

    List<NumberAmount> myList = new ArrayList<>();

    RecyclerViewAdater(List<NumberAmount> list) {
        myList = list;
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView myNumber, myAmount;




        public myViewHolder(View itemView) {
            super(itemView);
            myNumber = itemView.findViewById(R.id.mynumber);
            myAmount = itemView.findViewById(R.id.amount);


        }
    }




    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_rows, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position ) {
        String text = myList.get(position).getNumber().trim();
        if(text != "") {

            holder.myNumber.setText(myList.get(position).getNumber());

            holder.myAmount.setText(myList.get(position).getAmount());


        }
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
