package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_Edit_Profile_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_edit_profile_page);

        ImageButton back_button = findViewById(R.id.back_button);
        ImageView change_profile_button = findViewById(R.id.change_profile_button);
        ImageButton logout_button = findViewById(R.id.logout_button);
        ImageButton notification_button = findViewById(R.id.notification_button);
        ImageButton create_server_button = findViewById(R.id.create_server_button);
        ImageButton favorite_button = findViewById(R.id.favorite_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Edit_Profile_Page.this, Teacher_Home_Page.class);
            startActivity(intent);
        });

        logout_button.setOnClickListener(v -> {
            PopUp_Logout_Confirm_Button popUp = new PopUp_Logout_Confirm_Button();
            popUp.showConfirmButton(Teacher_Edit_Profile_Page.this);
        });

        notification_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Edit_Profile_Page.this, Teacher_Notification_Page.class);
            startActivity(intent);
        });

        create_server_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Edit_Profile_Page.this, Teacher_Create_Server_Page.class);
            startActivity(intent);
        });

        favorite_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Edit_Profile_Page.this, Teacher_Favorite_Server_Page.class);
            startActivity(intent);
        });

    }
}