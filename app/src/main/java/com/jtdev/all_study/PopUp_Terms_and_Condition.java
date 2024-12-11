package com.jtdev.all_study;

import android.app.AlertDialog;
import android.content.Context;

public class PopUp_Terms_and_Condition {

    public void showPopUp(Context context) {
        // Terms and conditions policy
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.allstudy_terms_conditions);
        builder.setMessage(context.getString(R.string.all_study_terms_conditions_message));

        // Add "OK" button
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}


