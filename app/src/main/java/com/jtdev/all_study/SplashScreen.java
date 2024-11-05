package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_01_main);

        // 3 seconds
        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(() -> {
            // Start MainActivity after the timer ends
            Intent intent = new Intent(SplashScreen.this, HomePageAllStudy.class);
            startActivity(intent);
            finish();  // Finish the Splash Activity so the user can't go back to it
        }, SPLASH_TIME_OUT);
    }
}