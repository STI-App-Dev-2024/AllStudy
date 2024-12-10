package com.jtdev.all_study;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class PopUp_Logout_Confirm_Button {

    public void showConfirmButton(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to logout?");

        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent = new Intent (context, LogIn_or_SignUp.class);

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
