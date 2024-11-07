package com.jtdev.all_study;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TeacherOrStudentLogIn extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04teacher_or_student_log_in);

        // Initialize buttons
        ImageButton student = findViewById(R.id.student);
        ImageButton teacher = findViewById(R.id.teacher);
        ImageButton back = findViewById(R.id.back);

        // Handle system window insets for proper layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Teacher button click listener
        teacher.setOnClickListener(v -> {
            Toast.makeText(TeacherOrStudentLogIn.this, "Welcome Teacher!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TeacherOrStudentLogIn.this, Teacher_SignUp.class);
            startActivity(intent);
        });

        // Student button click listener
        student.setOnClickListener(v -> {
            Toast.makeText(TeacherOrStudentLogIn.this, "Welcome Student!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TeacherOrStudentLogIn.this, Student_SignUp.class);
            startActivity(intent);
        });

        // Back button click listener
        back.setOnClickListener(v -> {
            Intent intent = new Intent(TeacherOrStudentLogIn.this, Signin_SignUp.class);
            startActivity(intent);
        });
    }
}
