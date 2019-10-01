package com.tekno.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActiveService extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ExampleAdapterActive mAdapter ;
    private RecyclerView.LayoutManager  mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_service);


        ArrayList<ExampleItemActive> exampleListActive = new ArrayList<>();
        exampleListActive.add(new ExampleItemActive(R.drawable.worldwide,"ali","omer"));
        exampleListActive.add(new ExampleItemActive(R.drawable.worldwide,"ali","omer"));
        exampleListActive.add(new ExampleItemActive(R.drawable.worldwide,"ali","omer"));
        exampleListActive.add(new ExampleItemActive(R.drawable.worldwide,"ali","omer"));
        exampleListActive.add(new ExampleItemActive(R.drawable.worldwide,"ali","omer"));
        exampleListActive.add(new ExampleItemActive(R.drawable.worldwide,"ali","omer"));

        mRecyclerView = findViewById(R.id.recycler_viewActive);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter =new ExampleAdapterActive(exampleListActive);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapterActive.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0 :
                        Toast.makeText(getApplicationContext(),"sss" ,Toast.LENGTH_SHORT).show();
                        break;

                    case 1 :
                        break;

                    case 2 :
                        break;

                    case 3 :
                        break;

                        default:
                            Toast.makeText(getApplicationContext(),"ha ha ha" ,Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onActiveClick(int position) {
                Toast.makeText(getApplicationContext(),"yes" ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
