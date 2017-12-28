package me.jartigag.loginandrtemplate.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import me.jartigag.loginandrtemplate.R;
import me.jartigag.loginandrtemplate.listener.LoginClickListener;
import me.jartigag.loginandrtemplate.model.AccessDao;
import me.jartigag.loginandrtemplate.model.DaoMaster;
import me.jartigag.loginandrtemplate.model.DaoSession;

/**
 * Actividad: pantalla para logearse
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // elementos del layout de LoginActivity (activity_login)
        EditText emailField = (EditText) findViewById(R.id.email_login);
        EditText passwordField = (EditText) findViewById(R.id.password_login);
        Button loginBtn = (Button) findViewById(R.id.login_button);

        // para acceder a la base de datos:
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        // getLogDao tantas veces como se necesite
        AccessDao accessDao = daoSession.getAccessDao();

        // se asigna listener al botón
        loginBtn.setOnClickListener(new LoginClickListener(this,emailField, passwordField, accessDao));
    }
}
