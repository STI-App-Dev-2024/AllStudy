package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Student_SignUp extends AppCompatActivity {

    private EditText full_name;
    private EditText email;
    private EditText student_id;
    private EditText password;
    private EditText confirm_password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_07_student_sign_up);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements by finding them using their IDs
        ImageButton back_button = findViewById(R.id.back_button);
        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        student_id = findViewById(R.id.student_id);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        Button signup_button = findViewById(R.id.signup_button);

        // Handle the insets (safe area) on devices with notches or system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up the sign-up button click listener
        signup_button.setOnClickListener(view -> {
            if (areAllFieldsValid()) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();

                mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                // Sign up success, navigate to the login activity
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(Student_SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Student_SignUp.this, Student_LogIn.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign up fails, display a message to the user
                                Toast.makeText(Student_SignUp.this, "Authentication failed: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        // Set up the back button click listener
        back_button.setOnClickListener(view -> {
            Intent intent = new Intent(Student_SignUp.this, Student_or_Teacher_SignUp.class);
            startActivity(intent);
        });
    }

    private boolean areAllFieldsValid() {
        boolean isValid = true;

        // Validate full name
        if (full_name.getText().toString().trim().isEmpty()) {
            full_name.setError("Full name is required");
            isValid = false;
        } else {
            full_name.setError(null);
        }

        // Validate email
        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Email is required");
            isValid = false;
        } else {
            email.setError(null);
        }

        // Validate student ID
        if (student_id.getText().toString().trim().isEmpty()) {
            student_id.setError("Student ID is required");
            isValid = false;
        } else {
            student_id.setError(null);
        }

        // Validate password
        if (password.getText().toString().trim().isEmpty()) {
            password.setError("Password is required");
            isValid = false;
        } else {
            password.setError(null);
        }

        // Validate confirm password
        if (confirm_password.getText().toString().trim().isEmpty()) {
            confirm_password.setError("Confirm Password is required");
            isValid = false;
        } else if (!password.getText().toString().equals(confirm_password.getText().toString())) {
            confirm_password.setError("Passwords do not match");
            isValid = false;
        } else {
            confirm_password.setError(null);
        }

        return isValid;
    }
}
