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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Student_LogIn extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_04_student_log_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements by finding them using their IDs
        ImageButton back_button = findViewById(R.id.back_button);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button login_button = findViewById(R.id.login_button);
        TextView forgot_pass_click = findViewById(R.id.forgot_pass_click);
        TextView signup_click = findViewById(R.id.signup_click);

        // Handle the insets (safe area) on devices with notches or system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up login button click listener
        login_button.setOnClickListener(v -> {
            String emailInput = email.getText().toString();
            String passwordInput = password.getText().toString();

            // Check for empty fields
            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(Student_LogIn.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                // Perform Firebase login
                performLogin(emailInput, passwordInput);
            }
        });

        // Set up back button listener
        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_LogIn.this, Student_or_Teacher_LogIn.class);
            startActivity(intent);
        });

        // Set up forgot password listener
        forgot_pass_click.setOnClickListener(v -> {
            Intent intent = new Intent(Student_LogIn.this, Student_Forgot_Password.class);
            startActivity(intent);
        });

        // Set up sign up listener
        signup_click.setOnClickListener(v -> {
            Intent intent = new Intent(Student_LogIn.this, Student_SignUp.class);
            startActivity(intent);
        });
    }

    private void performLogin(String emailInput, String passwordInput) {
        // Firebase authentication logic
        mAuth.signInWithEmailAndPassword(emailInput, passwordInput)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login successful
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(Student_LogIn.this, "Welcome back, " + user.getEmail(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Student_LogIn.this, Student_Splash_Screen.class);
                        startActivity(intent);
                        finish();  // Close the current activity
                    } else {
                        // Login failed
                        Toast.makeText(Student_LogIn.this, "Authentication failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
