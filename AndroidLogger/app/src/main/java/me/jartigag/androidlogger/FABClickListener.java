package me.jartigag.androidlogger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class FABClickListener implements View.OnClickListener {

    private Activity activity;
    private ItemDao itemDao;

    public FABClickListener(Activity activity, ItemDao itemDao) {
        this.activity = activity;
        this.itemDao = itemDao;
    }

    @Override
    public void onClick(View view) {
        createItemDialog();
    }

    private void createItemDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.additem, null);
        builder.setView(dialogView);

        final EditText edDialogText = dialogView.findViewById(R.id.eddDialogText);

        final Item newItem = new Item();


        builder.setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newItem.setEvent(edDialogText.getText().toString());
                newItem.setDate(new Date());
                itemDao.insert(newItem);
                Toast.makeText(activity, R.string.refresh,Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }
}
