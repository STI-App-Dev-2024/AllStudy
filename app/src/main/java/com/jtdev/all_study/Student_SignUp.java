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

public class Student_SignUp extends AppCompatActivity {

    private EditText full_name;
    private EditText email;
    private EditText student_id;
    private EditText password;
    private EditText confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_07_student_sign_up);

        // Initialize UI elements by finding them using their IDs
        ImageButton back_button = findViewById(R.id.back_button);
        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        student_id = findViewById(R.id.student_id);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        Button signup_button = findViewById(R.id.signup_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signup_button.setOnClickListener(view -> {

            if (full_name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || student_id.getText().toString().isEmpty()|| password.getText().toString().isEmpty() || confirm_password.getText().toString().isEmpty()) {
                Toast.makeText(Student_SignUp.this, "All fields are required", Toast.LENGTH_SHORT).show();
            }

            if (areAllFieldsValid()) {
                Intent intent = new Intent(Student_SignUp.this, Student_LogIn.class);
                Toast.makeText(Student_SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        back_button.setOnClickListener(view -> {
            Intent intent = new Intent(Student_SignUp.this, Student_or_Teacher_SignUp.class);
            startActivity(intent);
        });

    }

    private boolean areAllFieldsValid() {
        boolean isValid = true;

        if (full_name.getText().toString().isEmpty()) {
            full_name.setError("First name is required");
            isValid = false;
        }

        if (email.getText().toString().isEmpty()) {
            email.setError("Last name is required");
            isValid = false;
        }

        if (student_id.getText().toString().isEmpty()) {
            student_id.setError("Teacher ID is required");
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