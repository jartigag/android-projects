package me.jartigag.loginandrtemplate.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import me.jartigag.loginandrtemplate.R;
import me.jartigag.loginandrtemplate.listener.AccessListItemClickListener;
import me.jartigag.loginandrtemplate.model.Access;
import me.jartigag.loginandrtemplate.model.AccessDao;
import me.jartigag.loginandrtemplate.model.DaoMaster;
import me.jartigag.loginandrtemplate.model.DaoSession;

/**
 * Actividad: lista los accesos
 */

public class AccessListActivity extends AppCompatActivity {

    public AccessDao accessDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_list);

        // para acceder a la base de datos:
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        // getLogDao tantas veces como se necesite
        accessDao = daoSession.getAccessDao();

        List<Access> accessData = accessDao.queryBuilder().orderDesc(AccessDao.Properties.Date).list();

        ListView accessList = (ListView) findViewById(R.id.access_list);
        accessList.setAdapter(new AccessAdapter(accessData));
        accessList.setOnItemClickListener(new AccessListItemClickListener(accessData,this));
    }
}
