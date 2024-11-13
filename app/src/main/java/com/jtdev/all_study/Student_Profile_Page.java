package com.jtdev.all_study;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Student_Profile_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_profile_page);

        ImageButton back_button = findViewById(R.id.back_button);
        ImageButton change_profile_button = findViewById(R.id.change_profile_button);
        ImageButton notification_button = findViewById(R.id.notification_button);
        ImageButton join_server_button = findViewById(R.id.join_server_button);
        ImageButton favorite_button = findViewById(R.id.favorite_button);


        // Apply window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void showLogoutConfirmationDialog() {
        // Create an AlertDialog to confirm logout action
        new AlertDialog.Builder(this)
                .setTitle("Confirm Logout")
                .setMessage("Do you want to continue?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        logout(); // Proceed with logout
                    }
                })
                .setNegativeButton("No", null) // Dismiss dialog if "No" is clicked
                .show();
    }

    private void logout() {
        // Clear the session or user data in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();  // Clear all data
        editor.apply();  // Save changes

        // Redirect to LoginActivity
        Intent intent = new Intent(Student_Profile_Page.this, Student_LogIn.class);  // Fixed the intent destination
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the activity stack
        startActivity(intent);
        finish();  // Close the current activity
    }
}
