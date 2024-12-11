package com.jtdev.all_study;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class PopUp_Create_Server_Confirm_Button {

    public void showConfirmButton(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Create this server?");

        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent = new Intent (context, Teacher_Home_Page.class);

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
