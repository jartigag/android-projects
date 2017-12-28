package me.jartigag.loginandrtemplate.listener;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import me.jartigag.loginandrtemplate.R;

/**
 * Crea una cuenta nueva
 */

public class SignupClickListener implements View.OnClickListener {

    private Activity activity;
    private EditText emailField;
    private EditText passwordField;
    private EditText confirmField;
    private EditText nameField;

    public SignupClickListener(Activity signInActivity, EditText emailField, EditText passwordField, EditText confirmField, EditText nameField) {
        this.activity = signInActivity;
        this.emailField = emailField;
        this.passwordField = passwordField;
        this.confirmField = confirmField;
        this.nameField = nameField;
    }

    @Override
    public void onClick(View view) {
        // comprobar validez de los campos
        if (nameField.getText().toString().equals("")){
            Toast.makeText(activity, R.string.empty_name_message, Toast.LENGTH_SHORT).show();
        } else if (emailField.getText().toString().equals("")){
            Toast.makeText(activity, R.string.empty_email_message, Toast.LENGTH_SHORT).show();
        } else if (passwordField.getText().toString().equals("")) {
            Toast.makeText(activity, R.string.empty_password_message, Toast.LENGTH_SHORT).show();
        } else if (!passwordField.getText().toString().equals(confirmField.getText().toString())) {
            Toast.makeText(activity, R.string.unmatched_passwords_message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(activity, emailField.getText().toString() + activity.getString(R.string.account_created_message), Toast.LENGTH_LONG).show();
            //TODO guardar nombre/email/contraseña en BD
            // si el registro se realiza con exito, cerrar esta activity y volver a la pantalla inicial
            activity.finish();
            /*
            Gson gson =  new Gson();
            AsyncHttpClient client = new AsyncHttpClient();
            try {
                client.post(activity, "https://api.url.com/auth/register",
                        new StringEntity(gson.toJson(new RegisterRequest(emailField.getText().toString(), passwordField.getText().toString(), nameField.getText().toString()))),
                        "application/json", new SignInResponseHandler(activity));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            */
        }
    }
}
