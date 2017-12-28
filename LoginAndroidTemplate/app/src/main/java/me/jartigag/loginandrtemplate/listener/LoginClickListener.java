package me.jartigag.loginandrtemplate.listener;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import me.jartigag.loginandrtemplate.R;
import me.jartigag.loginandrtemplate.activity.MainActivity;
import me.jartigag.loginandrtemplate.model.Access;
import me.jartigag.loginandrtemplate.model.AccessDao;

/**
 * Inicia sesion con una cuenta existente
 */

public class LoginClickListener implements View.OnClickListener {

    private Activity activity;
    private EditText emailField;
    private EditText passwordField;
    private AccessDao accessDao;

    public LoginClickListener(Activity activity, EditText emailField, EditText passwordField, AccessDao accessDao) {
        this.activity = activity;
        this.emailField = emailField;
        this.passwordField = passwordField;
        this.accessDao = accessDao;
    }

    @Override
    public void onClick(View v) {

        if (emailField.getText().toString().equals("")) {
            Toast.makeText(activity, R.string.empty_email_message, Toast.LENGTH_SHORT).show();
        } else if (passwordField.getText().toString().equals("")) {
            Toast.makeText(activity, R.string.empty_password_message, Toast.LENGTH_SHORT).show();
        } else {
            /*
            Gson gson = new Gson();
            AsyncHttpClient client = new AsyncHttpClient();
            try {
                client.post(
                        activity,
                        "https:https://api.url.com/auth/login",
                        new StringEntity(gson.toJson(new LoginRequest(emailField.getText().toString(), passwordField.getText().toString()))),
                        "application/json", new LoginResponseHandler(activity)
                );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            */

            // se guarda fecha y hora actual
            Date date = new Date();
            // objeto Access para escribir nueva fila en la BD
            Access newAccess = new Access();

            newAccess.setEmail(emailField.getText().toString());
            newAccess.setDate(date);

            if (passwordField.getText().toString().equals(emailField.getText().toString())) { //TODO comprobar email-contraseña
                // contraseña CORRECTA

                Toast.makeText(activity, activity.getString(R.string.hello_message) + " " + emailField.getText().toString(), Toast.LENGTH_SHORT).show();

                // se guarda el acceso en la BD como valido
                newAccess.setValid(true);

                SharedPreferences settings = activity.getSharedPreferences("Config", 0);
                SharedPreferences.Editor editor = settings.edit();

                String localEmail = settings.getString("email", "");

                if (!localEmail.equals(emailField.getText().toString())) {
                    // email NO ALMACENADO

                    // se guarda en SharedPreferences
                    editor.putString("email", emailField.getText().toString());
                    editor.commit();
                }

                // se ocultan los elementos correspondientes en MainActivity
                MainActivity.welcomeTxt.setVisibility(View.GONE);
                MainActivity.loginBtn.setVisibility(View.GONE);
                MainActivity.signupBtn.setVisibility(View.GONE);

                // se modifica el mensaje de helloTxt y se hacen visibles helloTxt y logoutBtn
                MainActivity.helloTxt.setText(activity.getString(R.string.hello_message) + " " + localEmail);
                MainActivity.helloTxt.setVisibility(View.VISIBLE);
                MainActivity.logoutBtn.setVisibility(View.VISIBLE);

                // si se inicia sesion correctamente, cerrar esta activity y volver a la pantalla inicial
                activity.finish();

            } else {
                // contraseña INCORRECTA
                Toast.makeText(activity, R.string.wrong_password_message, Toast.LENGTH_SHORT).show();

                // se guarda el acceso en la BD como no valido
                newAccess.setValid(false);
            }

            // se inserta la nueva fila en la BD
            accessDao.insert(newAccess);

        }


    }
}
