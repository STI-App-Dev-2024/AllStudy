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

public class Teacher_SignUp extends AppCompatActivity {

    private EditText first_name;
    private EditText last_name;
    private EditText teacher_id;
    private EditText password;
    private EditText confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_08_teacher_sign_up);



        ImageButton backbutton = findViewById(R.id.backbutton);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        teacher_id = findViewById(R.id.teacher_id);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        Button sign_up_button = findViewById(R.id.sign_up_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sign_up_button.setOnClickListener(v -> {
            if (areAllFieldsValid()) {
                Intent intent = new Intent(Teacher_SignUp.this, Login.class);
                Toast.makeText(Teacher_SignUp.this, "Account successfully created!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        backbutton.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_SignUp.this, Student_or_Teacher_SignUp.class);
            startActivity(intent);
        });

    }
    private boolean areAllFieldsValid() {
        boolean isValid = true;

        if (first_name.getText().toString().isEmpty()) {
            first_name.setError("First name is required");
            isValid = false;
        }

        if (last_name.getText().toString().isEmpty()) {
            last_name.setError("Last name is required");
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