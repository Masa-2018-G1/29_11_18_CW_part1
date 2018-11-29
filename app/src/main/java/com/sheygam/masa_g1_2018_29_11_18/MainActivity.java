package com.sheygam.masa_g1_2018_29_11_18;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private MenuItem doneItem, editItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        doneItem = menu.findItem(R.id.done_item);
        editItem = menu.findItem(R.id.edit_item);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.edit_item){
            doneItem.setVisible(true);
            editItem.setVisible(false);

            new AlertDialog.Builder(this)
                    .setTitle("Title")
                    .setMessage("My message")
                    .setPositiveButton("Ok",null)
                    .setCancelable(false)
                    .create()
                    .show();

        }else if(item.getItemId() == R.id.done_item){
            doneItem.setVisible(false);
            editItem.setVisible(true);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("My dialog");
            builder.setMessage("Message");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d("TAG", "onClick: YES button");
                }
            });
            builder.setNegativeButton("NO",null);
            builder.setNeutralButton("Cancel",null);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setCancelable(false);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
