package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class Forgot_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_09_forgot_password);

        // Initialize UI elements by finding them using their IDs
        EditText email_edit_text = findViewById(R.id.email);
        Button send_button = findViewById(R.id.send_button);
        TextView signup_click = findViewById(R.id.signup_click);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged (CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged (Editable s) {
                String email = s.toString();

                if (Email_Validator.isValidEmail(email) || !email.endsWith("@gmail.com")) {
                    email_edit_text.setError(null);
                    send_button.setEnabled(true);
                }
            }

        });

        // Set up click listener for the Send button
        send_button.setOnClickListener(v -> {
            // Here you should add logic to send the OTP
            String emailInput = email_edit_text.getText().toString().trim();

            if (emailInput.isEmpty()) {
                // Intent to OTP screen
                Toast.makeText(Forgot_Password.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            } else if (!emailInput.endsWith("@gmail.com")) {
                Snackbar.make(v, "Invalid email address", Snackbar.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(Forgot_Password.this, OTP_AllStudy.class);
                Toast.makeText(Forgot_Password.this, "OTP Sent!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        // Set up click listener for the Sign Up text
        signup_click.setOnClickListener(v -> {
            // Navigate to Sign Up Activity (Assuming you have a SignUp activity)
            Intent intent = new Intent(Forgot_Password.this, Student_or_Teacher_SignUp.class);
            startActivity(intent);
        });
    }
}
