package com.jtdev.all_study;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_Notification_Page extends AppCompatActivity {

    private static final String CHANNEL_ID = "all_study_channel"; // Channel ID for notifications

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_notification_page);

        // Initialize buttons
        ImageButton back_button = findViewById(R.id.back_button);
        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        ImageButton rectangle_notification_1 = findViewById(R.id.rectangle_notification_1);
        ImageButton create_server_button = findViewById(R.id.create_server_button);
        ImageButton favorite_button = findViewById(R.id.favorite_button);

        // Handle window insets for edge-to-edge UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up button click listeners
        back_button.setOnClickListener(v -> {
            // Reset the notification count to 0
            resetNotificationCount();

            // Navigate back to Teacher_Home_Page
            Intent intent = new Intent(Teacher_Notification_Page.this, Teacher_Home_Page.class);
            startActivity(intent);
        });

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Notification_Page.this, Teacher_Edit_Profile_Page.class);
            startActivity(intent);
        });

        create_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Notification_Page.this, Teacher_Create_Server_Page.class);
            startActivity(intent);
        });

        favorite_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Notification_Page.this, Teacher_Favorite_Server_Page.class);
            startActivity(intent);
        });
    }

    // Method to reset the notification count (called when navigating back)
    private void resetNotificationCount() {
        // Store the updated notification count in SharedPreferences or handle logic to reset
        SharedPreferences prefs = getSharedPreferences("NotificationPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("notification_count", 0);  // Set the notification count to 0
        editor.apply();

        // Log reset
        Log.d("Notification", "Notification count reset to 0");
    }
}
