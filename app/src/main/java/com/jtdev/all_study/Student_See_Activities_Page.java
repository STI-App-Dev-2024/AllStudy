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


public class Student_See_Activities_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_see_activities_page);

        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        Button see_participants_button = findViewById(R.id.see_participants_button);
        ImageButton logout_button = findViewById(R.id.logout_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_See_Activities_Page.this, Student_Edit_Profile_Page.class);
            startActivity(intent);
        });

        see_participants_button.setOnClickListener(v -> {
            Intent intent = new Intent(Student_See_Activities_Page.this, Student_Inside_Server_Page.class);
            startActivity(intent);
        });

    }
}