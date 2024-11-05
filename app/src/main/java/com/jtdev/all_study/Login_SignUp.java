package com.jtdev.all_study;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login_SignUp extends AppCompatActivity {

    private CheckBox agree_box;

    //For unit testing
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    } //For unit testing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_03_login_sign_up);

        Button signup = findViewById(R.id.sign_up);
        Button login = findViewById(R.id.log_in);
        agree_box = findViewById(R.id.agree_box);

        // Set up insets for the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signup.setOnClickListener(v -> {
            if (agree_box.isChecked()) {
                // Logic for Sign Up button
                Intent intent = new Intent(Login_SignUp.this, TeacherOrStudentSignUp.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login_SignUp.this, "Please agree to the terms & condition first.", Toast.LENGTH_SHORT).show();
            }
        });

        login.setOnClickListener(v -> {
            if (agree_box.isChecked()) {
                // Logic for Log In button
                Intent intent = new Intent(Login_SignUp.this, Login.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login_SignUp.this, "Please agree to the terms & condition first.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
