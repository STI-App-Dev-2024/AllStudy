package com.jtdev.all_study;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Student_PopUp_Leave_Server {

    public void showConfirmButton(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to leave server?");

        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent = new Intent(context, Student_Home_Page.class);

            context.startActivity(intent);
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).finish();
            }
            dialog.dismiss();
        });

        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog no = builder.create();
        no.show();
    }
}
