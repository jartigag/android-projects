package me.jartigag.loginandrtemplate.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.jartigag.loginandrtemplate.R;

/**
 * Actividad: detalle de un acceso
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // elementos del layout de DetailActivity (activity_detail)
        TextView emailTxt = (TextView)findViewById(R.id.email_content);
        TextView dateTxt = (TextView)findViewById(R.id.date_content);
        TextView validTxt = (TextView)findViewById(R.id.isValid_content);

        Bundle extras = getIntent().getExtras();
        emailTxt.setText(extras.getString("email"));
        dateTxt.setText(extras.getString("date"));
        if (extras.getBoolean("isValid")) {
            validTxt.setText(R.string.yes);
        } else {
            validTxt.setText(R.string.no);
        }
    }
}
