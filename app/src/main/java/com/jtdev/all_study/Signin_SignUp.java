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

public class Signin_SignUp extends AppCompatActivity {

    private ImageButton signup;
    private Button signin;


    //For unit testing
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    } //For unit testing


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_03signin_sign_up);

        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);

        // Set up insets for the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        signup.setOnClickListener(v -> {
            // Logic for Sign Up button
            Toast.makeText(Signin_SignUp.this, "Sign Up!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Signin_SignUp.this, TeacherOrStudentLogIn.class);
            startActivity(intent);
        });


        signin.setOnClickListener(v -> {
            // Logic for Sign In button
            Toast.makeText(Signin_SignUp.this, "Sign In!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Signin_SignUp.this, SignmeIn.class);
            startActivity(intent);
        });
    }
}
