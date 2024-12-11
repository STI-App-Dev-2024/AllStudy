package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_See_More_Page extends AppCompatActivity {

    private static final String CHANNEL_ID = "simplified_coding";
    private static final CharSequence CHANNEL_NAME = "Simplified Coding Notifications";
    private static final String CHANNEL_DESCRIPTION = "This is the description of the channel.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_see_more_page);

        ImageButton back_button = findViewById(R.id.back_button);
        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        Button join_now_button_1 = findViewById(R.id.join_now_button_1);
        Button join_now_button_2 = findViewById(R.id.join_now_button_2);
        ImageButton notification_button = findViewById(R.id.notification_button);
        ImageButton create_server_button = findViewById(R.id.create_server_button);
        ImageButton favorite_button = findViewById(R.id.favorite_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Home_Page.class);
            startActivity(intent);
        });

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Edit_Profile_Page.class);
            startActivity(intent);
        });

        join_now_button_1.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Inside_Server_Page.class);
            displayNotification();
            startActivity(intent);
        });

        join_now_button_2.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Inside_Server_Page.class);
            displayNotification2();
            startActivity(intent);
        });

        notification_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Notification_Page.class);
            startActivity(intent);
        });

        create_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Create_Server_Page.class);
            startActivity(intent);
        });

        favorite_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Favorite_Server_Page.class);
            startActivity(intent);
        });
    }

        private void displayNotification() {
            Log.d("NotificationDebug", "Preparing to display notification...");

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.teachericon)
                        .setContentTitle("Hello There Student!")
                        .setContentText("Welcome to Computer Science! AllStudy Server is Online!")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setAutoCancel(false);

                NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
                mNotificationMgr.notify(1, mBuilder.build());

                Log.d("NotificationDebug", "Notification displayed.");
            }, 1000); // 2000 milliseconds = 2 seconds
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
            }, 1000);

        }
}