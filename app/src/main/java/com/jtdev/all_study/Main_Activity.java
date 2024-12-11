package com.jtdev.all_study;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Main_Activity extends AppCompatActivity {

    private static final String CHANNEL_ID = "simplified_coding";
    private static final CharSequence CHANNEL_NAME = "Simplified Coding Notifications";
    private static final String CHANNEL_DESCRIPTION = "This is the description of the channel.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_01_main);

        // Create Notification Channel
        createNotificationChannel();

        // Display the notification with a unique ID
        displayNotification();

        // Splash screen delay (3 seconds)
        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(() -> {
            // Navigate to LogIn_or_SignUp activity after splash screen
            Intent intent = new Intent(Main_Activity.this, LogIn_or_SignUp.class);
            startActivity(intent);
            finish();  // Close splash activity
        }, SPLASH_TIME_OUT);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    private void displayNotification() {
        Log.d("NotificationDebug", "Displaying notification...");

        // Use a unique ID for each notification
        int notificationId = (int) System.currentTimeMillis(); // Generates a unique ID based on current time

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.studenticon) // Replace with your drawable icon
                .setContentTitle("Welcome To AllStudy")
                .setContentText("Let Your Study Begin!")
                .setPriority(NotificationCompat.PRIORITY_HIGH) // High priority for visibility
                .setDefaults(NotificationCompat.DEFAULT_ALL) // Include sound, vibration, and lights
                .setAutoCancel(false); // Dismiss notification when clicked

        NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
        mNotificationMgr.notify(notificationId, mBuilder.build());
    }
}
