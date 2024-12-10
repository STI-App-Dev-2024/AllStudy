package com.jtdev.all_study;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Student_Notification_Page extends AppCompatActivity {

    private TextView notificationMessage;  // Reference for notification TextView

    private static final String CHANNEL_ID = "all_study_channel"; // Channel ID for notifications

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_notification_page);

        // Initialize buttons and notification area
        ImageButton back_button = findViewById(R.id.back_button);
        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        ImageButton join_server_button = findViewById(R.id.join_server_button);
        ImageButton favorite_button = findViewById(R.id.favorite_button);
        notificationMessage = findViewById(R.id.notification_message);  // Find the TextView

        // Handle window insets for edge-to-edge UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Button Click Listeners
        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Notification_Page.this, Student_Home_Page.class);
            startActivity(intent);
        });

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Notification_Page.this, Student_Edit_Profile_Page.class);
            startActivity(intent);
        });

        join_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Notification_Page.this, Student_Join_Server_Page.class);
            startActivity(intent);
        });

        favorite_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Notification_Page.this, Student_Favorite_Server_Page.class);
            startActivity(intent);
        });

        // Create notification channel for Android 8.0+ devices
        createNotificationChannel();

        // Display a sample notification after 2 seconds for demonstration
        String message = "New Notification: Let’s Start Learning!";
        showNotification(message);  // Update the TextView with the message
        displaySystemNotification(message);  // Display system notification
    }

    // Method to create a notification channel (required for Android 8.0+)
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "All Study Notifications";
            String description = "Notifications for All Study app";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    // Method to update notification message in the TextView
    private void showNotification(String message) {
        // Update the TextView dynamically with the notification message
        notificationMessage.setText(message);
    }

    // Method to display a system notification
    private void displaySystemNotification(String message) {
        // Build the system notification
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.studenticon)  // Icon for the notification
                .setContentTitle("All Study")  // Title of the notification
                .setContentText(message)  // Content of the notification
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);  // Set priority

        // Show the notification using the NotificationManagerCompat
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, mBuilder.build());  // 0 is the notification ID
    }
}
