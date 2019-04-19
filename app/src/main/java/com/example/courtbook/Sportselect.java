package com.example.courtbook;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.courtbook.R.id.logout;

public class Sportselect extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView recyclerView;
    private static final int RC_SIGN_IN=0;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
   private DrawerLayout mdrawer;
    private ActionBarDrawerToggle abt;
   private    FirebaseAuth firebaseAuth;
   private TextView textView;
     static String name;
     static String muid;
    static String memail;
    //private ImageView propi;
    //private String photourl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportselect);


        textView=findViewById(R.id.username);
        NavigationView mnavigationview=(NavigationView) findViewById(R.id.navid);
        //Listening to items clicked
        if(mnavigationview!=null)
        {
            mnavigationview.setNavigationItemSelectedListener(this);
            mnavigationview.bringToFront();
        }
        mdrawer= findViewById(R.id.drawerid);


        //Adding the menu icon to the nav drawer
        abt =new ActionBarDrawerToggle(this,mdrawer,R.string.open,R.string.close);
        mdrawer.addDrawerListener(abt);
        abt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //Firebase Auth using email and google providers
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
            //user already signed in
            Log.d("Auth",firebaseAuth.getCurrentUser().getEmail());
            Log.d("Auth",firebaseAuth.getCurrentUser().getDisplayName());
            name=firebaseAuth.getCurrentUser().getDisplayName();
            //photourl=firebaseAuth.getCurrentUser().getPhotoUrl().toString();
            Toast.makeText(this,"Welcome! "+name,Toast.LENGTH_SHORT).show();
            textView=(TextView) mnavigationview.getHeaderView(0).findViewById(R.id.username);
            textView.setText(name);
           // propi=(ImageView) mnavigationview.getHeaderView(0).findViewById(R.id.propic);
            muid=firebaseAuth.getCurrentUser().getUid();
            memail=firebaseAuth.getCurrentUser().getEmail();






           //databaseuser.child(bid).setValue(user);
        }
        else {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(Arrays.asList(
                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                            new AuthUI.IdpConfig.EmailBuilder().build()
                            )
                    )

                    .build(), RC_SIGN_IN);

        }



        //Getting the items for the cards in the view.
        ArrayList<Getsport>getsports=new ArrayList<>();
        getsports.add(new Getsport(1 ,R.drawable.cricket,"Cricket"));
        getsports.add(new Getsport(2, R.drawable.badminton,"Badminton"));
        getsports.add(new Getsport(3,R.drawable.football,"Football"));

        //setting the layout and adapter.
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

//Actions on the nav items clicked.
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        int id=menuItem.getItemId();
       if(id == R.id.logout){
           AuthUI.getInstance()
                   .signOut(this)
                   .addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           Log.d("Auth","USER LOGGED OUT");
                           finish();
                       }
                   });
        }

      return false;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if(requestCode==RC_SIGN_IN)
         {
             if(resultCode==RESULT_OK){
                 //user logged in
                Log.d("Auth",firebaseAuth.getCurrentUser().getEmail());

             }
             else{
                 //User not authenticated
                 Log.d("AUTH","NOT AUTHENTICATED");
             }
         }
    }
}

