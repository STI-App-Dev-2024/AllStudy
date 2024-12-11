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

public class Teacher_See_Activities_Page_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_see_activities_page2);

        Button see_participants_button = findViewById(R.id.see_participants_button);
        ImageButton leave_server_button = findViewById(R.id.leave_server_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        see_participants_button.setOnClickListener(v -> {
            Intent intent = new Intent(Teacher_See_Activities_Page_2.this, Teacher_Inside_Server_Page_2.class);
            startActivity(intent);
        });

        leave_server_button.setOnClickListener(v -> {
            Teacher_PopUp_Leave_Server popUp = new Teacher_PopUp_Leave_Server();
            popUp.showConfirmButton(Teacher_See_Activities_Page_2.this);
        });

    }
}