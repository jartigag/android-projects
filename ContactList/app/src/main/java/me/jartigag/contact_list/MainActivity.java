package me.jartigag.contact_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> listContacts;
    ListView lvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContacts = new ContactFetcher(this).fetchAll();
        lvContacts = (ListView) findViewById(R.id.lvContacts);
        ContactsAdapter adapterContacts = new ContactsAdapter(this, listContacts);
        lvContacts.setAdapter(adapterContacts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
