package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogIn_or_SignUp extends AppCompatActivity {

    private CheckBox agree_box;

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_02_login_or_sign_up);



        // Initialize UI elements by finding them using their IDs
        Button login_button = findViewById(R.id.login_button);
        Button signup_button = findViewById(R.id.signup_button);
        agree_box = findViewById(R.id.agree_box);
        TextView terms_and_condition_click = findViewById(R.id.terms_and_condition_click);

        // Set up insets for the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        login_button.setOnClickListener(v -> {
            if (agree_box.isChecked()) {
                // Logic for Log In button
                Intent intent = new Intent(LogIn_or_SignUp.this, Student_or_Teacher_LogIn.class);
                startActivity(intent);
            } else {
                Toast.makeText(LogIn_or_SignUp.this, R.string.agree_to_terms, Toast.LENGTH_SHORT).show();
            }
        });

        signup_button.setOnClickListener(v -> {
            if (agree_box.isChecked()) {
                // Logic for Sign Up button
                Intent intent = new Intent(LogIn_or_SignUp.this, Student_or_Teacher_SignUp.class);
                startActivity(intent);
            } else {
                Toast.makeText(LogIn_or_SignUp.this, R.string.agree_to_terms, Toast.LENGTH_SHORT).show();
            }
        });

        terms_and_condition_click.setOnClickListener(v -> {
            PopUp_Terms_and_Condition popUp = new PopUp_Terms_and_Condition();
            popUp.showPopUp(LogIn_or_SignUp.this);
        });
    }
}

