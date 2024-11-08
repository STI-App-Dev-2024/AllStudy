package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class New_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_11_new_password);

        // Create a PasswordValidator instance for password validation
        Password_Validator validator = new Password_Validator();

        // Instantiate EditText and UI element button
        EditText new_password = findViewById(R.id.new_password);
        String password = new_password.getText().toString();
        EditText confirm_password = findViewById(R.id.confirm_password);
        Button confirm_button = findViewById(R.id.confirm_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (validator.isValidPassword(password)) {
            confirm_button.setEnabled(true);
        } else if (new_password != confirm_password) {
            confirm_button.setEnabled(false);
        } else {
            new_password.setError("Invalid password");
        }

        confirm_button.setOnClickListener(v -> {
            String passwordInput = new_password.getText().toString().trim();

            if (!passwordInput.isEmpty()) {
                Intent intent = new Intent(New_Password.this, Student_or_Teacher_LogIn.class);
                Toast.makeText(this, "Password Changed!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}