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

public class Teacher_SignUp_Page extends AppCompatActivity {

    private EditText full_name;
    private EditText email;
    private EditText teacher_id;
    private EditText password;
    private EditText confirm_password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_08_teacher_sign_up);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements by finding them using their IDs
        ImageButton back_button = findViewById(R.id.back_button);
        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        teacher_id = findViewById(R.id.teacher_id);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        Button signup_button = findViewById(R.id.signup_button);

        // Handle insets for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signup_button.setOnClickListener(v -> {
            // Check if any fields are empty
            if (full_name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || teacher_id.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirm_password.getText().toString().isEmpty()) {
                Toast.makeText(Teacher_SignUp_Page.this, "All fields are required", Toast.LENGTH_SHORT).show();
            }

            // Check if all fields are valid
            if (areAllFieldsValid()) {
                // Create the user in Firebase
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();

                mAuth.createUserWithEmailAndPassword(emailInput, passwordInput)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                // Sign-up successful
                                Toast.makeText(Teacher_SignUp_Page.this, "Account successfully created!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Teacher_SignUp_Page.this, Teacher_LogIn_Page.class);
                                startActivity(intent);
                                finish(); // Close the sign-up activity
                            } else {
                                // Sign-up failed
                                Toast.makeText(Teacher_SignUp_Page.this, "Authentication failed. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_SignUp_Page.this, Student_or_Teacher_SignUp.class);
            startActivity(intent);
        });
    }

    private boolean areAllFieldsValid() {
        boolean isValid = true;

        if (full_name.getText().toString().isEmpty()) {
            full_name.setError("Full name is required");
            isValid = false;
        }

        if (email.getText().toString().isEmpty()) {
            email.setError("Email is required");
            isValid = false;
        }

        if (teacher_id.getText().toString().isEmpty()) {
            teacher_id.setError("Teacher ID is required");
            isValid = false;
        }

        if (password.getText().toString().isEmpty()) {
            password.setError("Password is required");
            isValid = false;
        }

        if (confirm_password.getText().toString().isEmpty()) {
            confirm_password.setError("Confirm Password is required");
            isValid = false;
        } else if (!password.getText().toString().equals(confirm_password.getText().toString())) {
            confirm_password.setError("Passwords do not match");
            isValid = false;
        }

        return isValid;
    }
}
