package com.framfresh.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent( SplashActivity.this,     RegistrationActivity.class));
                finish();
                overridePendingTransition(0, 0);

//                if(FirebaseAuth.getInstance().getCurrentUser()==null){
//
//
//
//                }else{
//                    startActivity(new Intent( SplashActivity.this,     MainActivity.class));
//                    finish();
//                    overridePendingTransition(0, 0);
//                }

            }
        }, secondsDelayed * 2000);


    }
}
