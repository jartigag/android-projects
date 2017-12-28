package me.jartigag.loginandrtemplate.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import me.jartigag.loginandrtemplate.listener.LogoutClickListener;
import me.jartigag.loginandrtemplate.listener.OpenAccessListClickListener;
import me.jartigag.loginandrtemplate.listener.OpenLoginClickListener;
import me.jartigag.loginandrtemplate.listener.OpenSignupClickListener;
import me.jartigag.loginandrtemplate.R;
import me.jartigag.loginandrtemplate.model.AccessDao;
import me.jartigag.loginandrtemplate.model.DaoMaster;
import me.jartigag.loginandrtemplate.model.DaoSession;

/**
 * Actividad principal: da opcion de ir a Login/Signup, Logout y AccessList
 */

public class MainActivity extends AppCompatActivity {

    public static TextView welcomeTxt;
    public static TextView helloTxt;
    public static Button signupBtn;
    public static Button loginBtn;
    public static Button accessBtn;
    public static Button logoutBtn;
    public AccessDao accessDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // elementos del layout de MainActivity (activity_main)
        // publicos y de clase para que sean accesibles desde otra actividad
        welcomeTxt = (TextView) findViewById(R.id.welcome);
        helloTxt = (TextView) findViewById(R.id.hello);
        signupBtn = (Button) findViewById(R.id.sign_up);
        loginBtn = (Button) findViewById(R.id.log_in);
        accessBtn = (Button) findViewById(R.id.access_list);
        logoutBtn = (Button) findViewById(R.id.log_out);

        // para acceder a la base de datos:
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        // getLogDao tantas veces como se necesite
        accessDao = daoSession.getAccessDao();

        // se asigna listener a cada botón
        signupBtn.setOnClickListener(new OpenSignupClickListener(this));
        loginBtn.setOnClickListener(new OpenLoginClickListener(this));
        accessBtn.setOnClickListener(new OpenAccessListClickListener(this));
        logoutBtn.setOnClickListener(new LogoutClickListener(this));
    }

}
