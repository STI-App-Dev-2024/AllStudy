package com.jtdev.all_study;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Teacher_Enable_Apps_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_enable_apps_page);

        ImageButton back_button = findViewById(R.id.back_button);
        ImageButton add_apps_button = findViewById(R.id.add_apps_button);
        Button create_server_button = findViewById(R.id.create_server_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Enable_Apps_Page.this, Teacher_Create_Server_Page.class);
            startActivity(intent);
        });

        add_apps_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_Enable_Apps_Page.this, Teacher_Enable_Apps_Page.class);
            startActivity(intent);
        });

        create_server_button.setOnClickListener(v -> {
            PopUp_Create_Server_Confirm_Button popUp = new PopUp_Create_Server_Confirm_Button();
            popUp.showConfirmButton(Teacher_Enable_Apps_Page.this);
        });

    }
}