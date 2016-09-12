package com.example.root.canteen;

import android.app.Application;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

/**
 * Created by root on 11/9/16.
 */
public class Button extends Application {

private AuthCallback authCallback;
    private static final String TWITTER_KEY = "NEdKxq7EZkkDEsC3TShGdrps5";
    private static final String TWITTER_SECRET = "GDlnrUYtkIxlwBMKMoI2ymeGsGwZI80Tn9HASMmGwjkPNwpJcc";


    @Override
    public void onCreate() {
        super.onCreate();

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());


        authCallback= new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                Toast.makeText(getApplicationContext(),"Digits Success,.....",Toast.LENGTH_SHORT);
            }

            @Override
            public void failure(DigitsException error) {

                Toast.makeText(getApplicationContext(),"Digits failed,.....",Toast.LENGTH_SHORT);
            }
        };

            }


        public AuthCallback getAuthCallback(){
            return authCallback;
        }
}
