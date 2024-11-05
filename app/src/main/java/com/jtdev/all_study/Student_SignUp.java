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

    private EditText first_name;
    private EditText last_name;
    private EditText student_id;
    private EditText password;
    private EditText confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_05_student_sign_up);

        ImageButton backbutton = findViewById(R.id.backbutton);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        student_id = findViewById(R.id.student_id);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        Button sign_up_button = findViewById(R.id.sign_up_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sign_up_button.setOnClickListener(view -> {
            if (areAllFieldsValid()) {
                Intent intent = new Intent(Student_SignUp.this, Login.class);
                Toast.makeText(Student_SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        backbutton.setOnClickListener(view -> {
            Intent intent = new Intent(Student_SignUp.this, TeacherOrStudentSignUp.class);
            startActivity(intent);
        });

    }

    private boolean areAllFieldsValid() {
        if (first_name.getText().toString().trim().isEmpty()) {
            first_name.setError("First Name is required");
            return false;
        }

        if (last_name.getText().toString().trim().isEmpty()) {
            last_name.setError("Last Name is required");
            return false;
        }

        if (student_id.getText().toString().trim().isEmpty()) {
            student_id.setError("Student ID is required");
            return false;
        }

        if (password.getText().toString().trim().isEmpty()) {
            password.setError("Password is required");
            return false;
        }

        if (confirm_password.getText().toString().trim().isEmpty()) {
            confirm_password.setError("Confirm Password is required");
            return false;
        }
        return true;
    }
}