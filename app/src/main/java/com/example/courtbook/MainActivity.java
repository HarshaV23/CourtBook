package com.example.courtbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

  //  SignInButton signInButton;
  //  GoogleSignInClient googleSignInClient;
    //int RC_SIGN_IN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








       // signInButton = findViewById(R.id.g_signin);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
    //    googleSignInClient = GoogleSignIn.getClient(this, gso);
        //signInButton.setOnClickListener(sign());

        // private void sign(){
        //   Intent signintent=googleSignInClient.getSignInIntent();
        // startActivityForResult(signintent,RC_SIGN_IN);
        //}

        //  Button button=(Button)findViewById(R.id.);
        //button.setOnClickListener(new View.OnClickListener() {
        //@Override
        //  public void onClick(View v) {
        //      Intent intent=new Intent(MainActivity.this,Sportselect.class);
        //    startActivity(intent);
    }
    //});
    //}
}
