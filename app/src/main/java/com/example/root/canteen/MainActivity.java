package com.example.root.canteen;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;
import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;


public class MainActivity extends AppCompatActivity {

    private AuthCallback authCallback;
    //Log.d("Test","AuthCallback set");
    private static final String TWITTER_KEY = "NEdKxq7EZkkDEsC3TShGdrps5";
    private static final String TWITTER_SECRET = "GDlnrUYtkIxlwBMKMoI2ymeGsGwZI80Tn9HASMmGwjkPNwpJcc";

    DigitsAuthButton btnDigits ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());
Log.d("Test","Twiter set ");

      /*  authCallback= new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                }

            @Override
            public void failure(DigitsException error) {

            }
        };*/


        btnDigits  = (DigitsAuthButton)findViewById(R.id.Digits_AuthBtn1);
        Log.d("Test","Digits set");

        btnDigits.setCallback(new AuthCallback() {
            @Override

            public void success(DigitsSession session, String phoneNumber) {
                Toast.makeText(getApplicationContext(),"Digits Success,....."+phoneNumber,Toast.LENGTH_SHORT);
                Log.d("Test","success");

            }

            @Override
            public void failure(DigitsException error) {
                Toast.makeText(getApplicationContext(),"Digits failed,.....",Toast.LENGTH_SHORT);
                Log.d("Test","failure");

            }
        });




    }
   // public AuthCallback getAuthCallback(){
     //   return authCallback;
   // }

}
