package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Forgot_Password extends AppCompatActivity {
private Button send;
private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_08_forgot_password);

        Button send = findViewById(R.id.send);
        EditText email = findViewById(R.id.email);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        send.setOnClickListener(v -> {
            Intent intent = new Intent(Forgot_Password.this, OTP_AllStudy.class);
            Toast.makeText(Forgot_Password.this, "OTP Sent!", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        });
    }
}