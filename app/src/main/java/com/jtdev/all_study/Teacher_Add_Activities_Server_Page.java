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

public class Teacher_Add_Activities_Server_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_add_activities_server_page);

        ImageButton back_button = findViewById(R.id.back_button);
        Button create_server_button = findViewById(R.id.create_server_button);
        ImageButton add_activity_button = findViewById(R.id.add_files_button);
        ImageButton logout_button = findViewById(R.id.logout_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Add_Activities_Server_Page.this, Teacher_Home_Page.class);
            startActivity(intent);
        });

        create_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Add_Activities_Server_Page.this, Teacher_Create_Server_Page.class);
            startActivity(intent);
        });

        add_activity_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Add_Activities_Server_Page.this, Teacher_Add_Activities_Server_Page.class);
            startActivity(intent);
        });

        logout_button.setOnClickListener(v -> {
            Teacher_PopUp_Leave_Server popUp = new Teacher_PopUp_Leave_Server();
            popUp.showConfirmButton(Teacher_Add_Activities_Server_Page.this);
        });

    }
}