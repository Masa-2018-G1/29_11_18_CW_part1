package com.sheygam.masa_g1_2018_29_11_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    private String[] names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        fillList();
//        ListView myList = findViewById(R.id.my_list);
//        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
//        myList.setAdapter(adapter);

//        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        LayoutInflater layoutInflater = LayoutInflater.from(this);

//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
//        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        TextView textView = new TextView(this);
//        textView.setLayoutParams(llParams);


        FrameLayout container = findViewById(R.id.container);

        View view = layoutInflater.inflate(R.layout.test_text,null);//return  TextView ViewGroup.LayoutParams
        view = layoutInflater.inflate(R.layout.test_text,container);// return FrameLayout -> added to container -> TextView got FrameLayout.LayoutParams

        view = layoutInflater.inflate(R.layout.test_text,null,false);// equals first

        view = layoutInflater.inflate(R.layout.test_text,container,false);// return TextView with FrameLayout.LayoutParams, without added to container
        view = layoutInflater.inflate(R.layout.test_text,container,true);//equals second


        Log.d("TAG", "onCreate: " + view.getClass().getSimpleName());
    }

    private void fillList(){
        names = new String[100];
        for (int i = 0; i < names.length; i++) {
            names[i] = "Name " + (i+1);
        }
    }
}
