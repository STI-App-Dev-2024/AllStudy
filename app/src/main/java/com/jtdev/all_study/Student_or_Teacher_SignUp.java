package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Student_or_Teacher_SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_06_student_or_teacher_signup);

        // Initialize buttons
        ImageButton navback = findViewById(R.id.navback);
        ImageButton student = findViewById(R.id.student);
        ImageButton teacher = findViewById(R.id.teacher);

        // Handle system window insets for proper layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back button click listener
        navback.setOnClickListener(v -> {
            Intent intent = new Intent(Student_or_Teacher_SignUp.this, LogIn_or_SignUp.class);
            startActivity(intent);
        });

        student.setOnClickListener(v -> {
            Intent intent = new Intent(Student_or_Teacher_SignUp.this, Student_SignUp.class);
            Toast.makeText(Student_or_Teacher_SignUp.this, "Welcome, student!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        teacher.setOnClickListener(v -> {
            Intent intent = new Intent(Student_or_Teacher_SignUp.this, Teacher_SignUp.class);
            Toast.makeText(Student_or_Teacher_SignUp.this, "Welcome, teacher!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

    }
}
