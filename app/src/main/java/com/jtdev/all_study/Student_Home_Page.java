package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Student_Home_Page extends AppCompatActivity {

    private static final String CHANNEL_ID = "simplified_coding";
    private static final CharSequence CHANNEL_NAME = "Simplified Coding Notifications";
    private static final String CHANNEL_DESCRIPTION = "This is the description of the channel.";

    ImageButton button1;
    ImageButton button2;
    ImageButton edit_profile_button;
    Button join_now_button;
    Button see_more_button;
    ImageButton notification_button;
    ImageButton join_server_button;
    ImageButton favorite_button;
    TextView notificationBadge;    // Reference for the notification badge

    // Variable to hold the number of notifications
    private int notificationCount = 0;  // Start with 0 notifications

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_12_student_home_page);

        // Instantiated all buttons by getting their IDs from student_homepage.xml
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        edit_profile_button = findViewById(R.id.edit_profile_button);
        join_now_button = findViewById(R.id.join_now_button);
        see_more_button = findViewById(R.id.see_more_button);
        notification_button = findViewById(R.id.notification_button);
        join_server_button = findViewById(R.id.join_server_button);
        favorite_button = findViewById(R.id.favorite_button);
        notificationBadge = findViewById(R.id.notification_badge);  // Find the notification badge TextView

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Show the notification badge with the initial count
        setNotificationBadge(notificationCount);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Set up button actions
        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Edit_Profile_Page.class);
            startActivity(intent);
        });

        join_now_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Inside_Server_Page.class);
            displayNotification();
            startActivity(intent);
        });

        see_more_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Join_Server_Page.class);
            startActivity(intent);
        });

        notification_button.setOnClickListener(v -> {
            // Navigate to the notifications page
            Intent intent = new Intent(Student_Home_Page.this, Student_Notification_Page.class);
            startActivity(intent);

            // Show the notification badge with 1 notification count (indicating unread notifications)
            notificationCount = 1;  // Set 1 notification to be displayed
            setNotificationBadge(notificationCount);  // Update badge visibility and count
        });

        join_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Inside_Server_Page.class);
            displayNotification();
            startActivity(intent);
        });

        favorite_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Favorite_Server_Page.class);
            startActivity(intent);
        });

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Inside_Server_Page.class);
            displayNotification();
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Inside_Server_Page_2.class);
            displayNotification2();
            startActivity(intent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        // If there are still notifications, show the badge
        setNotificationBadge(notificationCount);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // Reset the notification count and hide the badge when navigating back from the notifications page
        notificationCount = 0;  // No more notifications after viewing
        setNotificationBadge(notificationCount);  // Hide the badge
    }

    // Method to dynamically set the notification badge count
    private void setNotificationBadge(int notificationCount) {
        if (notificationCount > 0) {
            notificationBadge.setText(String.valueOf(notificationCount));  // Display the count
            notificationBadge.setVisibility(TextView.VISIBLE);  // Show the badge
        } else {
            notificationBadge.setVisibility(TextView.GONE);  // Hide the badge if there are no notifications
        }
    }
        private void displayNotification() {
            Log.d("NotificationDebug", "Displaying notification...");

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.studenticon)
                    .setContentTitle("Hello There Dear Student!")
                    .setContentText("Welcome to Computer Science Server! AllStudy Server is Online!")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setAutoCancel(false);

            NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
            mNotificationMgr.notify(1, mBuilder.build());
        }

            private void displayNotification2() {
                Log.d("NotificationDebug", "Preparing to display notification...");

                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.teachericon)
                            .setContentTitle("Hello There Student!")
                            .setContentText("Welcome to Information Technology Server! AllStudy Server is Online!")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setDefaults(NotificationCompat.DEFAULT_ALL)
                            .setAutoCancel(false);

                    NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
                    mNotificationMgr.notify(1, mBuilder.build());

                    Log.d("NotificationDebug", "Notification displayed.");
                }, 1000); // 2000 milliseconds = 2 seconds
        }


    }

