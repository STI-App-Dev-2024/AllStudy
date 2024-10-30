package com.jtdev.all_study;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_07_log_in);

        Button navback = findViewById(R.id.navback);
        Button buttonsign = findViewById(R.id.buttonsign);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonsign.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, HomePageAllStudy.class);
            Toast.makeText(Login.this, "Welcome back!", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        });

        navback.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Login_SignUp.class);
            startActivity(intent);

        });

    }
}
