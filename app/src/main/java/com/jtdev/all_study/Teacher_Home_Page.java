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

public class Teacher_Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_13_teacher_home_page);

        Button join_now_button = findViewById(R.id.join_now_button);
        Button see_more_button = findViewById(R.id.see_more_button);
        ImageButton create_server_button = findViewById(R.id.create_server_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        see_more_button.setOnClickListener(v ->{
            Intent intent = new Intent(Teacher_Home_Page.this, Student_See_More_Page.class);
            startActivity(intent);
        });

        create_server_button.setOnClickListener(v ->{
            Intent intent = new Intent(Teacher_Home_Page.this, Teacher_Create_Server_Page.class);
            startActivity(intent);
        });

    }
}