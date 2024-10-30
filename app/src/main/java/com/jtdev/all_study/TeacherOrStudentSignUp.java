package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TeacherOrStudentSignUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04_teacher_or_student_sign_up);

        // Initialize buttons
        ImageButton teacher = findViewById(R.id.teacher);
        ImageButton student = findViewById(R.id.student);
        ImageButton navback = findViewById(R.id.navback);

        // Handle system window insets for proper layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        teacher.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherOrStudentSignUp.this, Teacher_SignUp.class);
            Toast.makeText(TeacherOrStudentSignUp.this, "Welcome, Teacher!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        student.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherOrStudentSignUp.this, Student_SignUp.class);
            Toast.makeText(TeacherOrStudentSignUp.this, "Welcome, student!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        // Back button click listener
        navback.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherOrStudentSignUp.this, Login_SignUp.class);
            startActivity(intent);
        });
    }
}
