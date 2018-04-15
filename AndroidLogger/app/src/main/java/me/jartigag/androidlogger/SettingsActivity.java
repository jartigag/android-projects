package me.jartigag.androidlogger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Spinner spnLanguage = findViewById(R.id.spnLanguage);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.languages));
        spnLanguage.setAdapter(spinnerAdapter);

        spnLanguage.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                /*switch (pos) { //NO FUNCIONA
                    case 1:
                        Toast.makeText(parent.getContext(),
                                R.string.tstSpanish, Toast.LENGTH_SHORT);
                        break;
                    case 2:
                        Toast.makeText(parent.getContext(),
                                R.string.tstEnglish, Toast.LENGTH_SHORT);
                        break;
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
