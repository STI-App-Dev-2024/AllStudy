package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Forgot_Password extends AppCompatActivity {
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_09_forgot_password);

        // Initialize UI elements
        Button send = findViewById(R.id.send);
        email = findViewById(R.id.email);
        TextView signUpText = findViewById(R.id.signmeup);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up click listener for the Send button
        send.setOnClickListener(v -> {
            // Here you should add logic to send the OTP
            String emailInput = email.getText().toString().trim();
            if (!emailInput.isEmpty()) {
                // Intent to OTP screen
                Intent intent = new Intent(Forgot_Password.this, OTP_AllStudy.class);
                Toast.makeText(Forgot_Password.this, "OTP Sent!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } else {
                Toast.makeText(Forgot_Password.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up click listener for the Sign Up text
        signUpText.setOnClickListener(v -> {
            // Navigate to Sign Up Activity (Assuming you have a SignUp activity)
            Intent intent = new Intent(Forgot_Password.this, OTP_AllStudy.class);
            startActivity(intent);
        });
    }
}
