package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_See_More_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_see_more_page);

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

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Profile_Page.class);
            startActivity(intent);
        });

        notification_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Notification_Page.class);
            startActivity(intent);
        });

        favorite_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_More_Page.this, Teacher_Favorite_Server_Page.class);
            startActivity(intent);
        });
    }
}