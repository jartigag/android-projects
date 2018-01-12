package me.jartigag.androidlogger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class ItemsAdapter extends BaseAdapter {

    private List<Item> items;

    public ItemsAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Item getItem(int i) {
        return this.items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Item item = this.getItem(position);

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cell, null, false);
        }

        TextView tvDate = view.findViewById(R.id.tvDate);
        TextView tvEvent = view.findViewById(R.id.tvEvent);

        tvDate.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(item.getDate()));
        tvEvent.setText(item.getEvent().toString());

        return view;
    }
}
