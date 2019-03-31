package com.example.courtbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;

public class Sportselect extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportselect);


        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.GoogleBuilder().build(),
                        new AuthUI.IdpConfig.EmailBuilder().build()
                        )
                )

                .build(),1 );
        ArrayList<Getsport>getsports=new ArrayList<>();
        getsports.add(new Getsport(1 ,R.drawable.cricket,"Cricket"));
        getsports.add(new Getsport(2, R.drawable.badminton,"Badminton"));
        getsports.add(new Getsport(3,R.drawable.football,"Football"));


        recyclerView=findViewById(R.id.recyclerSport);
        layoutManager=new LinearLayoutManager(this);

        adapter=new SportSelectAdapter(getsports,this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
