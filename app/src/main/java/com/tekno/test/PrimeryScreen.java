package com.tekno.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class PrimeryScreen extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primery_screen);


        ArrayList<ExampleItem> exampleIiist = new ArrayList<>();
        exampleIiist.add(new ExampleItem(R.drawable.transfer,getString(R.string.transf) , "Details"));
        exampleIiist.add(new ExampleItem(R.drawable.telephone,getString(R.string.commun), " Details"));
        exampleIiist.add(new ExampleItem(R.drawable.worldwide,getString(R.string.intr) , "Details"));
        exampleIiist.add(new ExampleItem(R.drawable.youtube,getString(R.string.htu) , "Details"));
        exampleIiist.add(new ExampleItem(R.drawable.share,getString(R.string.sh) , "Details"));
        exampleIiist.add(new ExampleItem(R.drawable.ic_android,getString(R.string.abou) , "Details"));


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleIiist);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        mAdapter.setOnItemClickListenr(new ExampleAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0 :
                        Intent intent = new Intent(PrimeryScreen.this,MainActivity.class);
                        startActivity(intent);
                            break;
                    case 1 :
                        Intent ichos = new Intent(PrimeryScreen.this,Choseone.class);
                        startActivity(ichos);

                        break;
                    case 2 :

                        break;
                    case 3 :

                        break;

                    case 4 :
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "Here is the share content body";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        break;
                    case 5 :

                        break;
                            default:
                                Toast.makeText(getApplicationContext(),"tekno",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
