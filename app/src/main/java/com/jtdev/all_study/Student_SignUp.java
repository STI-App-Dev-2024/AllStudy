package com.jtdev.all_study;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Student_SignUp extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_05_student_sign_up);

        Button signupbutton = findViewById(R.id.signupbutton);
        ImageButton backbutton = findViewById(R.id.backbutton);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signupbutton.setOnClickListener(view -> {
            Intent intent = new Intent(Student_SignUp.this, Login.class);
            Toast.makeText(Student_SignUp.this, "Account successfully created!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        backbutton.setOnClickListener(view -> {
            Intent intent = new Intent(Student_SignUp.this, TeacherOrStudentSignUp.class);
            startActivity(intent);
        });

    }
}