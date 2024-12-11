package com.jtdev.all_study;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Student_LogIn extends AppCompatActivity {

    private static final String CHANNEL_ID = "simplified_coding";
    private static final CharSequence CHANNEL_NAME = "Simplified Coding Notifications";
    private static final String CHANNEL_DESCRIPTION = "This is the description of the channel.";

    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_04_student_log_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements by finding them using their IDs
        ImageButton back_button = findViewById(R.id.back_button);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button login_button = findViewById(R.id.login_button);
        TextView forgot_pass_click = findViewById(R.id.forgot_pass_click);
        TextView signup_click = findViewById(R.id.signup_click);

        // Handle the insets (safe area) on devices with notches or system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Request Notification Permission (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        // Set up login button click listener
        login_button.setOnClickListener(view -> {
            if (areAllFieldsValid()) {
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();
                performLogin(emailInput, passwordInput);
            } else {
                Toast.makeText(Student_LogIn.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up back button listener
        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_LogIn.this, Student_or_Teacher_LogIn.class);
            startActivity(intent);
        });

        // Set up forgot password listener
        forgot_pass_click.setOnClickListener(v -> {
            Intent intent = new Intent(Student_LogIn.this, Student_Forgot_Password.class);
            startActivity(intent);
        });

        // Set up sign up listener
        signup_click.setOnClickListener(v -> {
            Intent intent = new Intent(Student_LogIn.this, Student_SignUp.class);
            startActivity(intent);
        });
    }


    private boolean areAllFieldsValid() {
        boolean isValid = true;

        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Email is required"); // Shows error with a red exclamation mark
            isValid = false;
        } else {
            email.setError(null); // Clears the error if input is valid
        }

        if (password.getText().toString().trim().isEmpty()) {
            password.setError("Password is required"); // Shows error with a red exclamation mark
            isValid = false;
        } else {
            password.setError(null); // Clears the error if input is valid
        }

        return isValid;
    }

    private void performLogin(String emailInput, String passwordInput) {
        // Firebase authentication logic
        mAuth.signInWithEmailAndPassword(emailInput, passwordInput)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login successful
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(Student_LogIn.this, "Welcome back, " + user.getEmail(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Student_LogIn.this, Student_Splash_Screen.class);
                        displayNotification();
                        startActivity(intent);
                        finish(); // Close the current activity
                    } else {
                        // Login failed
                        Toast.makeText(Student_LogIn.this, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void displayNotification() {
        Log.d("NotificationDebug", "Preparing to display notification...");

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.teachericon)
                    .setContentTitle("Hello There Student!")
                    .setContentText("Welcome to AllStudy Server")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setAutoCancel(false);

            NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
            mNotificationMgr.notify(1, mBuilder.build());

            Log.d("NotificationDebug", "Notification displayed.");
        }, 1000);
    }
}
