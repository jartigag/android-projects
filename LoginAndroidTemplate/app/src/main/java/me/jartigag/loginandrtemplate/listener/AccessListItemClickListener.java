package me.jartigag.loginandrtemplate.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import java.text.SimpleDateFormat;
import java.util.List;

import me.jartigag.loginandrtemplate.activity.AccessListActivity;
import me.jartigag.loginandrtemplate.activity.DetailActivity;
import me.jartigag.loginandrtemplate.model.Access;

/**
 * Abre los detalles de un acceso
 */

public class AccessListItemClickListener implements AdapterView.OnItemClickListener {

    private List<Access> accessList;
    private Activity activity;

    public AccessListItemClickListener(List<Access> accessData, AccessListActivity accessListActivity) {
        this.accessList = accessData;
        this.activity = accessListActivity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this.activity, DetailActivity.class);
        String email = accessList.get(position).getEmail();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = dt.format(accessList.get(position).getDate());
        Boolean isValid = accessList.get(position).getValid();
        intent.putExtra("email",email);
        intent.putExtra("date",date);
        intent.putExtra("isValid",isValid);
        this.activity.startActivity(intent);

    }
}
