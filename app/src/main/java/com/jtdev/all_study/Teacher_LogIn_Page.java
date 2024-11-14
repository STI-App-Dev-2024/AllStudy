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

public class Teacher_LogIn_Page extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_05_teacher_log_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements by finding them using their IDs
        ImageButton back_button = findViewById(R.id.back_button);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button signin_button = findViewById(R.id.login_button);
        TextView forgot_pass_click = findViewById(R.id.forgot_pass_click);
        TextView signup_click = findViewById(R.id.signup_click);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signin_button.setOnClickListener(v -> {
            String emailInput = email.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();

            boolean hasError = false;

            // Check if email field is empty
            if (emailInput.isEmpty()) {
                email.setError("Email is required!");
                hasError = true;
            }

            // Check if password field is empty
            if (passwordInput.isEmpty()) {
                password.setError("Password is required!");
                hasError = true;
            }

            // If no errors, perform Firebase login
            if (!hasError) {
                performLogin(emailInput, passwordInput);
            } else {
                Toast.makeText(Teacher_LogIn_Page.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });

        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_LogIn_Page.this, Student_or_Teacher_LogIn.class);
            startActivity(intent);
        });

        // Set up forgot password listener
        forgot_pass_click.setOnClickListener(v -> {
            // Navigate to Forgot Password Activity
            Intent intent = new Intent(Teacher_LogIn_Page.this, Student_Forgot_Password.class);
            startActivity(intent);
        });

        // Set up sign up listener
        signup_click.setOnClickListener(v -> {
            // Navigate to Sign Up Activity
            Intent intent = new Intent(Teacher_LogIn_Page.this, Teacher_SignUp_Page.class);
            startActivity(intent);
        });
    }

    private void performLogin(String emailInput, String passwordInput) {
        // Firebase Authentication
        mAuth.signInWithEmailAndPassword(emailInput, passwordInput)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign-in success
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(Teacher_LogIn_Page.this, "Welcome back, " + user.getEmail(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Teacher_LogIn_Page.this, Teacher_Splash_Screen.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // If sign in fails, display a message to the user
                        Toast.makeText(Teacher_LogIn_Page.this, "Authentication failed. Invalid email or password.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
