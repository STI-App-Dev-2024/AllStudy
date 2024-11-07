package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity after the timer ends
                Intent intent = new Intent(SplashScreen.this, HomePageAllStudy.class);
                startActivity(intent);
                finish();  // Finish the Splash Activity so the user can't go back to it
            }
        }, SPLASH_TIME_OUT);
    }
}