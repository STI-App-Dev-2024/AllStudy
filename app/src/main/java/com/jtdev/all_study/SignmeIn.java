package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignmeIn extends AppCompatActivity {

    private ImageButton navback;
    private Button buttonsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_08signme_in);


        navback = findViewById(R.id.navback);
        buttonsign = findViewById(R.id.buttonsign);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        buttonsign.setOnClickListener(v -> {

            Intent intent = new Intent(SignmeIn.this, HomePageAllStudy.class);
            startActivity(intent);

        });


        navback.setOnClickListener(v -> {

            Intent intent = new Intent(SignmeIn.this, Signin_SignUp.class);
            startActivity(intent);

        });

    }
}
