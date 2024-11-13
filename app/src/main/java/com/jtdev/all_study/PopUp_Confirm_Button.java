package com.jtdev.all_study;

import android.app.AlertDialog;
import android.content.Context;

public class PopUp_Confirm_Button {

    public void showConfirmButton(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.are_you_sure);

        builder.setPositiveButton("Yes", (dialog, which) -> dialog.dismiss());
        AlertDialog yes = builder.create();
        yes.show();

        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog no = builder.create();
        no.show();
    }

}
