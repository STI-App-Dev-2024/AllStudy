package com.jtdev.all_study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class New_Password extends AppCompatActivity {
private Button confirm_button;
private EditText newpassword;
private EditText confirmpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_10_new_password);

        Button confirm_button = findViewById(R.id.confirm_button);
        EditText newpassword = findViewById(R.id.newpassword);
        EditText confirmpassword = findViewById(R.id.confirmpassword);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        confirm_button.setOnClickListener(v -> {
            Toast.makeText(this, "Password Changed!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(New_Password.this, Login.class);
            startActivity(intent);
        });
    }
}