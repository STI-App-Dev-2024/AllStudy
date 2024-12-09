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

public class Teacher_Classroom_Rules_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_classroom_rules);

        ImageButton edit_profile_button = findViewById(R.id.edit_profile_button);
        Button see_activities_button = findViewById(R.id.see_activities_button);
        ImageButton logout_button = findViewById(R.id.logout_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit_profile_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Classroom_Rules_Page.this, Teacher_Edit_Profile_Page.class);
            startActivity(intent);
        });

        see_activities_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Classroom_Rules_Page.this, Teacher_See_Activities_Page.class);
            startActivity(intent);
        });

        logout_button.setOnClickListener(v -> {
            PopUp_Logout_Confirm_Button popUp = new PopUp_Logout_Confirm_Button();
            popUp.showConfirmButton(Teacher_Classroom_Rules_Page.this);
        });

    }
}