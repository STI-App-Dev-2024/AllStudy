package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_LogIn extends AppCompatActivity {

    private EditText email;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_05_teacher_log_in);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button buttonsign = findViewById(R.id.button_sign_in);
        ImageButton backbutton = findViewById(R.id.backbutton);
        TextView forgotPassword = findViewById(R.id.forgot_password);
        TextView signUp = findViewById(R.id.signmeup);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonsign.setOnClickListener(v -> {
            String emailInput = email.getText().toString();
            String passwordInput = password.getText().toString();

            // Check for empty fields
            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(Teacher_LogIn.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                // Perform login logic
                performLogin(emailInput, passwordInput);
            }
        });

        backbutton.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_LogIn.this, Student_or_Teacher_LogIn.class);
            startActivity(intent);
        });

        // Set up forgot password listener
        forgotPassword.setOnClickListener(v -> {
            // Navigate to Forgot Password Activity
            Intent intent = new Intent(Teacher_LogIn.this, Forgot_Password.class);
            startActivity(intent);
        });

        // Set up sign up listener
        signUp.setOnClickListener(v -> {
            // Navigate to Sign Up Activity
            Intent intent = new Intent(Teacher_LogIn.this, Teacher_SplashScreen.class);
            startActivity(intent);
        });
    }

    private void performLogin(String emailInput, String passwordInput) {
        // Placeholder login logic
        String correctEmail = "user@example.com";  // Replace with your testing email
        String correctPassword = "password123";    // Replace with your testing password

        if (emailInput.equals(correctEmail) && passwordInput.equals(correctPassword)) {
            // Login successful
            Toast.makeText(Teacher_LogIn.this, "Welcome back!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Teacher_LogIn.this, Student_HomePage.class);
            startActivity(intent);
            finish();
        } else {
            // Login failed
            Toast.makeText(Teacher_LogIn.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
        
    }
}