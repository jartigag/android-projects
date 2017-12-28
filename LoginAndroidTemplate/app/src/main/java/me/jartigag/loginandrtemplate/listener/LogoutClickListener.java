package me.jartigag.loginandrtemplate.listener;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;

import me.jartigag.loginandrtemplate.activity.MainActivity;

/**
 * Cierra la sesion
 */

public class LogoutClickListener implements View.OnClickListener {

    private Activity activity;

    public LogoutClickListener(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    @Override
    public void onClick(View view) {

        SharedPreferences settings = activity.getSharedPreferences("Config", 0);
        SharedPreferences.Editor editor = settings.edit();

        // se borra el email guardado en SharedPreferences
        editor.putString("E-mail", "");
        editor.commit();

        // se reestablecen los elementos correspondientes en MainActivity
        MainActivity.welcomeTxt.setVisibility(View.VISIBLE);
        MainActivity.loginBtn.setVisibility(View.VISIBLE);
        MainActivity.signupBtn.setVisibility(View.VISIBLE);

        MainActivity.helloTxt.setVisibility(View.GONE);
        MainActivity.logoutBtn.setVisibility(View.GONE);
    }
}
