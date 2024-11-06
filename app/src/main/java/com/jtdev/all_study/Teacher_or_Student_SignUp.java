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

public class Teacher_or_Student_SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_04_teacher_or_student_sign_up);

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
            Intent intent = new Intent(Teacher_or_Student_SignUp.this, Login_SignUp.class);
            startActivity(intent);
        });

        student.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_or_Student_SignUp.this, Student_SignUp.class);
            Toast.makeText(Teacher_or_Student_SignUp.this, "Welcome, student!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        teacher.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_or_Student_SignUp.this, Teacher_SignUp.class);
            Toast.makeText(Teacher_or_Student_SignUp.this, "Welcome, teacher!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

    }
}
