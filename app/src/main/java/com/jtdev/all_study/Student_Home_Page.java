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

public class Student_Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_12_student_home_page);


        // Instantiated all buttons by getting their IDs from student_homepage.xml
        Button join_now_button = findViewById(R.id.join_now_button);
        Button see_more_button = findViewById(R.id.see_more_button);
        ImageButton notification_button = findViewById(R.id.notification_button);
        ImageButton join_server_button = findViewById(R.id.join_server_button);
        ImageButton favorite_button = findViewById(R.id.favorite_button);
        ImageButton generic_avatar = findViewById(R.id.generic_avatar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        see_more_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_See_More.class);
            startActivity(intent);
        });
        generic_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Home_Page.this, Student_Profile_Page.class);
            startActivity(intent);

        });
        }
    }
