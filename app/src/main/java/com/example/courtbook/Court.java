package com.example.courtbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Court extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);

        ArrayList<Getcourt>getcourts=new ArrayList<>();
        if(Selection.sport.equals("Cricket")) {
            getcourts.add(new Getcourt(1, "Ragiv Gandhi International Stadium", "Uppal, Hyderabad, Telangana 500039", R.drawable.rgstadium));
            getcourts.add(new Getcourt(2, "Eden Gardens", "BBD Bagh, Kolkata, West Bengal 700021", R.drawable.edengardens));

        }
        else if(Selection.sport.equals("Badminton")) {
            getcourts.add(new Getcourt(1,"A1 SPORTS"," 201/2, 1st Main, 1st Cross Bagalur Cross Near to Brundavan College, Baba Nagar, Yelahanka, Bengaluru, Karnataka 560063",R.drawable.a1sports));
            getcourts.add(new Getcourt(2,"Takerz Badminton Academy","No:39/2, Srirampura Village, Behind Manyata Tech Park, Jakkur, Bengaluru, Karnataka 560064",R.drawable.takerzs));
        }

        recyclerView=findViewById(R.id.recyclercourt);
        layoutManager=new LinearLayoutManager(this);

        adapter=new CourtAdapter(getcourts,this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
