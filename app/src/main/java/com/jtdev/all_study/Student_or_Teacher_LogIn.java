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

public class Student_or_Teacher_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_03_student_or_teacher_log_in);

        // Initialize buttons
        ImageButton navback = findViewById(R.id.navback);
        ImageButton student = findViewById(R.id.student);
        ImageButton teacher = findViewById(R.id.teacher);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navback.setOnClickListener(v -> {
            Intent intent = new Intent(Student_or_Teacher_LogIn.this, Login_SignUp.class);
            startActivity(intent);
        });

        student.setOnClickListener(v -> {
            Intent intent = new Intent(Student_or_Teacher_LogIn.this, Student_LogIn.class);
            Toast.makeText(Student_or_Teacher_LogIn.this, "Welcome, Student!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        teacher.setOnClickListener(v -> {
            Intent intent = new Intent(Student_or_Teacher_LogIn.this, Teacher_LogIn.class);
            Toast.makeText(Student_or_Teacher_LogIn.this, "Welcome, Teacher!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}