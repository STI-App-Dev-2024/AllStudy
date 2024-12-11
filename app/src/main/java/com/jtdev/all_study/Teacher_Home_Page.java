package com.jtdev.all_study;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_Home_Page extends AppCompatActivity {

    // SharedPreferences keys for notification management
    private static final String PREFS_NAME = "NotificationPrefs";
    private static final String KEY_NOTIFICATION_COUNT = "notification_count";

    private TextView notificationBadge; // Reference for the notification badge

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_13_teacher_home_page);

        // Instantiate UI components
        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        Button join_now_button = findViewById(R.id.join_now_button);
        ImageButton server_button_1 = findViewById(R.id.server_button_1);
        ImageButton server_button_2 = findViewById(R.id.server_button_2);
        Button see_more_button = findViewById(R.id.see_more_button);
        ImageButton notification_button = findViewById(R.id.notification_button);
        ImageButton create_server_button = findViewById(R.id.create_server_button);
        ImageButton favorite_button = findViewById(R.id.favorite_button);
        notificationBadge = findViewById(R.id.notification_badge); // Find the notification badge TextView

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Dynamically set the notification badge based on stored count
        setNotificationBadge(getNotificationCount());

        // Button click listeners
        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Edit_Profile_Page.class);
            startActivity(intent);
        });

        join_now_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Inside_Server_Page.class);
            startActivity(intent);
        });

        see_more_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_See_More_Page.class);
            startActivity(intent);
        });

        notification_button.setOnClickListener(v -> {
            // Navigate to the notifications page
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Notification_Page.class);
            startActivity(intent);

            // Reset the badge count after clicking the notification button
            setNotificationCount(0); // Reset count in preferences
            setNotificationBadge(0); // Hide badge
        });

        create_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Create_Server_Page.class);
            startActivity(intent);
        });

        favorite_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Favorite_Server_Page.class);
            startActivity(intent);
        });

        server_button_1.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Inside_Server_Page.class);
            startActivity(intent);
        });
        server_button_2.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Inside_Server_Page_2.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the notification badge when returning to the page
        setNotificationBadge(getNotificationCount());
    }

    // Retrieve the notification count from SharedPreferences
    private int getNotificationCount() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.getInt(KEY_NOTIFICATION_COUNT, 0); // Default to 0
    }

    // Update the notification count in SharedPreferences
    private void setNotificationCount(int count) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_NOTIFICATION_COUNT, count);
        editor.apply();
    }

    // Dynamically update the notification badge visibility and count
    private void setNotificationBadge(int notificationCount) {
        if (notificationCount > 0) {
            notificationBadge.setText(String.valueOf(notificationCount)); // Display count
            notificationBadge.setVisibility(TextView.VISIBLE); // Show badge
        } else {
            notificationBadge.setVisibility(TextView.GONE); // Hide badge
        }
    }
}
