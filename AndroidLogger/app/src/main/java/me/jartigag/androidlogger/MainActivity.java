package me.jartigag.androidlogger;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


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

        com.getbase.floatingactionbutton.FloatingActionButton addItemFAB = findViewById(R.id.action_sport);
        addItemFAB.setOnClickListener(new FABClickListener(this,itemDao));
    }
}