package me.jartigag.loginandrtemplate.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import me.jartigag.loginandrtemplate.activity.LoginActivity;

/**
 * Abre la actividad de login
 */

public class OpenLoginClickListener implements View.OnClickListener {

    private Activity activity;

    public OpenLoginClickListener(Activity mainActivity) {
        this.activity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.activity, LoginActivity.class);
        this.activity.startActivity(intent);
    }
}
