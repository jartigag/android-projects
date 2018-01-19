package me.jartigag.androidlogger;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refresh();

        final SwipeRefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    public void refresh() {
        // para acceder a la base de datos:
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        // getItemDao tantas veces como se necesite
        ItemDao itemDao = daoSession.getItemDao();

        List<Item> itemData = itemDao.queryBuilder().orderDesc(ItemDao.Properties.Date).list();
        ListView lvItems = findViewById(R.id.lvItems);

        lvItems.setAdapter(new ItemsAdapter(itemData));

        com.getbase.floatingactionbutton.FloatingActionButton addItemFAB = findViewById(R.id.fabShortcut1);
        addItemFAB.setOnClickListener(new FABClickListener(this,itemDao));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el recurso menú, en la action bar
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        SharedPreferences settings = this.getSharedPreferences("Config", 0);
        SharedPreferences.Editor editor = settings.edit();

        if (id == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.export) {
            //todo
        }
        return super.onOptionsItemSelected(item);
    }
}