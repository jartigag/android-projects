package me.jartigag.loginandrtemplate.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import me.jartigag.loginandrtemplate.activity.AccessListActivity;

/**
 * Abre la actividad de accesos listados
 */

public class OpenAccessListClickListener implements View.OnClickListener {

    private Activity activity;

    public OpenAccessListClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.activity, AccessListActivity.class);
        this.activity.startActivity(intent);
    }

}
