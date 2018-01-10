package me.jartigag.showsguide;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ExpandableListView elvShows;
    ShowsListAdapter elaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignar Adapter a ExpandableListView elvShows
        elvShows = (ExpandableListView) findViewById(R.id.elvShows);
        elaAdapter = new ShowsListAdapter(MainActivity.this);
        elvShows.setAdapter(elaAdapter);

        //Asignar OnChildClickListener
        /*
        elvShows.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View v, int groupPosition, int childPosition, long id) {
                String showTitle = (String) elaAdapter.getChild(groupPosition, childPosition);
                Class<? extends Activity> showClass = elaAdapter.getShowClass(groupPosition, childPosition, id);
                if (showClass != null) {
                    Toast.makeText(MainActivity.this, showTitle, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, showClass));
                } else {
                    Toast.makeText(MainActivity.this, "Show Not Available",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });*/
    }
}
