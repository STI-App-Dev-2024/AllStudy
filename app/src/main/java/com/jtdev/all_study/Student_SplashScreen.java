package com.jtdev.all_study;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class Student_SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_splash_screen);
        int SPLASH_TIME_OUT = 1000;
        new Handler().postDelayed(() -> {
            // Start MainActivity after the timer ends
            Intent intent = new Intent(Student_SplashScreen.this, Student_HomePage.class);
            startActivity(intent);
            finish();  // Finish the Splash Activity so the user can't go back to it
        }, SPLASH_TIME_OUT);

    }
}