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

public class Student_Join_Server extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_join_server);

        ImageButton back_button = findViewById(R.id.back_button);
        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        Button sort_by_server_button = findViewById(R.id.sort_by_server_button);
        Button sort_by_host_button = findViewById(R.id.sort_by_host_button);

        Button join_now_button_1 = findViewById(R.id.join_now_button_1);
        Button join_now_button_2 = findViewById(R.id.join_now_button_2);
        Button see_more_button = findViewById(R.id.see_more_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Join_Server.this, Student_Home_Page.class);
            startActivity(intent);
        });

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Join_Server.this, Student_Edit_Profile_Page.class);
            startActivity(intent);
        });

        sort_by_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Join_Server.this, Student_Join_Server.class);
            startActivity(intent);
        });

        sort_by_host_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_Join_Server.this, Student_Join_Host_Page.class);
            startActivity(intent);
        });

    }
}