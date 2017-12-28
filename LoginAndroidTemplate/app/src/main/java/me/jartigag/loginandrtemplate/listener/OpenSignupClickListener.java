package me.jartigag.loginandrtemplate.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import me.jartigag.loginandrtemplate.activity.SignupActivity;

/**
 * Abre la actividad de registro
 */

public class OpenSignupClickListener implements View.OnClickListener {

    private Activity activity;

    public OpenSignupClickListener(Activity mainActivity) {
        this.activity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.activity, SignupActivity.class);
        this.activity.startActivity(intent);
    }
}
