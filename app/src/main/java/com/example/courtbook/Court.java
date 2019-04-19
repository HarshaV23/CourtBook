package com.example.courtbook;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class Court extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);


        ArrayList<Getcourt> getcourts = new ArrayList<>();
        if (Selection.sport.equals("Cricket")) {

            getcourts.add(new Getcourt(1, "Ragiv Gandhi International Stadium", "Uppal, Hyderabad, Telangana 500039", R.drawable.rgstadium));
            getcourts.add(new Getcourt(2, "Eden Gardens", "BBD Bagh, Kolkata, West Bengal 700021", R.drawable.edengardens));

        } else if (Selection.sport.equals("Badminton")) {
            getcourts.add(new Getcourt(1, "A1 SPORTS", " 201/2, 1st Main, 1st Cross Bagalur Cross Near to Brundavan College, Baba Nagar, Yelahanka, Bengaluru, Karnataka 560063", R.drawable.a1sports));
            getcourts.add(new Getcourt(2, "Takerz Badminton Academy", "No:39/2, Srirampura Village, Behind Manyata Tech Park, Jakkur, Bengaluru, Karnataka 560064", R.drawable.takerzs));
        } else if (Selection.sport.equals("Football")) {
            getcourts.add(new Getcourt(1, "Banglore Football Turf", "36/2, Royal Suites Hotel Apartments, Hennur Ring Road Junction, Bengaluru, Karnataka 560043", R.drawable.bft));
            getcourts.add(new Getcourt(2, "Shantiniketan Football Court", "474, K Main Rd, Tank Ground Shantiniketan Tank Park Muthuraya Swamy Layout, 560076, Vysya Bank Colony, Shantiniketan Layout, Arekere, Bengaluru, Karnataka 560076", R.drawable.sfa));
        }

        recyclerView = findViewById(R.id.recyclercourt);
        layoutManager = new LinearLayoutManager(this);

        adapter = new CourtAdapter(getcourts, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}
