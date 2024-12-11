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

public class Teacher_Inside_Server_Page extends AppCompatActivity {
    private static final String CHANNEL_ID = "simplified_coding";
    private static final CharSequence CHANNEL_NAME = "Simplified Coding Notifications";
    private static final String CHANNEL_DESCRIPTION = "This is the description of the channel.";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_inside_server_page);

        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        Button see_activities_button = findViewById(R.id.see_activities_button);
        TextView see_classroom_rules_click = findViewById(R.id.see_classroom_rules_click);
        ImageButton leave_server_button = findViewById(R.id.leave_server_button);
        displayNotification();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Inside_Server_Page.this, Teacher_Edit_Profile_Page.class);
            startActivity(intent);
        });

        see_activities_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Inside_Server_Page.this, Teacher_See_Activities_Page.class);
            startActivity(intent);
        });

        see_classroom_rules_click.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Inside_Server_Page.this, Teacher_See_Classroom_Rules_Page.class);
            startActivity(intent);
        });

        leave_server_button.setOnClickListener(v -> {
            Teacher_PopUp_Leave_Server popUp = new Teacher_PopUp_Leave_Server();
            popUp.showConfirmButton(Teacher_Inside_Server_Page.this);

        });
    }

    private void displayNotification() {
        Log.d("NotificationDebug", "Preparing to display notification...");

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.teachericon)
                    .setContentTitle("Hello There Teacher!")
                    .setContentText("A Student Has Left The Server!")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setAutoCancel(false);

            NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
            mNotificationMgr.notify(1, mBuilder.build());

            Log.d("NotificationDebug", "Notification displayed.");
        }, 1500); // 2000 milliseconds = 2 seconds

    }
}