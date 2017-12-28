package me.jartigag.loginandrtemplate.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import me.jartigag.loginandrtemplate.R;
import me.jartigag.loginandrtemplate.listener.SignupClickListener;

/**
 * Actividad: pantalla para registrarse
 */

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // elementos del layout de SignupActivity (activity_signup)
        EditText nameField = (EditText) findViewById(R.id.name_signup);
        EditText emailField = (EditText) findViewById(R.id.email_signup);
        EditText passwordField = (EditText) findViewById(R.id.password_signup);
        EditText confirmField = (EditText) findViewById(R.id.confirm_password);
        Button signupBtn = (Button) findViewById(R.id.signup_button);

        // se asigna listener para crear cuenta (SignupClickListener)
        signupBtn.setOnClickListener(new SignupClickListener(this, emailField, passwordField, confirmField, nameField));
    }
}
