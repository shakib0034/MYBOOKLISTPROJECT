package com.shakibcsekuet.mainbooklistproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by md sakib on 9/30/2017.
 */

public class cse_1st_2nd extends AppCompatActivity {

    ListView simpleList2;
    String book[] ={"Structured programming","Digital Logic Design","Chemistry","Analog Electronics","Coordinate Geometry and Differential equations"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cse_1st_2nd);
        simpleList2 = (ListView)findViewById(R.id.simpleListView3);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview1st2nd, R.id.textView3, book);
        simpleList2.setAdapter(arrayAdapter);
        simpleList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked on "+book[position], Toast.LENGTH_LONG).show();





            }
        });

    }
}
