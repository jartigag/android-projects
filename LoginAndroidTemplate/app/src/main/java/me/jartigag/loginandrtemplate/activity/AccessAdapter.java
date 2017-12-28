package me.jartigag.loginandrtemplate.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import me.jartigag.loginandrtemplate.R;
import me.jartigag.loginandrtemplate.model.Access;

/**
 * Adaptador para la lista de accesos
 */

public class AccessAdapter extends BaseAdapter {

    private List<Access> accesses;

    public AccessAdapter(List<Access> accessData) {
        this.accesses = accessData;
    }

    @Override
    public int getCount() {
        return this.accesses.size();
    }

    @Override
    public Access getItem(int position) {
        return this.accesses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Access access = this.getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell_access, null, false);
        }

        ImageView greenLight = (ImageView) convertView.findViewById(R.id.green_light);
        ImageView redLight = (ImageView) convertView.findViewById(R.id.red_light);
        TextView email = (TextView) convertView.findViewById(R.id.email);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        if (access.getValid()) {
            greenLight.setVisibility(View.VISIBLE);
            redLight.setVisibility(View.GONE);
        } else {
            greenLight.setVisibility(View.GONE);
            redLight.setVisibility(View.VISIBLE);
        }

        email.setText(access.getEmail());

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha = dt.format(access.getDate());

        date.setText(fecha);

        return convertView;
    }
}
