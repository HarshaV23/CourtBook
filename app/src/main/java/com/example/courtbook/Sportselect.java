package com.example.courtbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.courtbook.R.id.logout;

public class Sportselect extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
   private DrawerLayout mdrawer;
    private ActionBarDrawerToggle abt;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportselect);


        navigationView=findViewById(R.id.navid);
        navigationView.setNavigationItemSelectedListener(this);
        mdrawer= findViewById(R.id.drawerid);



        abt =new ActionBarDrawerToggle(this,mdrawer,R.string.open,R.string.close);
        mdrawer.addDrawerListener(abt);
        abt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(abt.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


       if(menuItem.getItemId()==R.id.logout){
           Toast.makeText(this,"g",Toast.LENGTH_SHORT).show();
        }

        mdrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

