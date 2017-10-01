package com.shakibcsekuet.mainbooklistproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.shakibcsekuet.mainbooklistproject.R.layout.cse_1st_1st;

/**
 * Created by md sakib on 9/29/2017.
 */
public class CSE extends AppCompatActivity  {
    ListView simpleList;
    String SEMISTER_LIST[] = {"1st year 1st semister", "1st year 2nd semister", "2nd year 1st semister", "2nd year 2nd semister","3rd year 1st semister","3rd year 2nd semister","4th year 1st semister","4th year 2nd semister"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cse);
        simpleList = (ListView)findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.cse_book_listview, R.id.textView, SEMISTER_LIST);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked on "+SEMISTER_LIST[position], Toast.LENGTH_LONG).show();
                if(position==0){

                    Intent intent = new Intent(getApplicationContext(), cse_1st_1st.class);
                    startActivity(intent);
                }
                else if(position==1){

                    Intent intent = new Intent(getApplicationContext(), cse_1st_2nd.class);
                    startActivity(intent);
                }
                else if(position==2){

                    Intent intent = new Intent(getApplicationContext(), cse_2nd_1st.class);
                    startActivity(intent);
                }
                else if(position==3){
                    Intent intent = new Intent(getApplicationContext(), cse_2nd_2nd.class);
                    startActivity(intent);
                }
                else if(position==4){
                    Intent intent = new Intent(getApplicationContext(), cse_3rd_1st.class);
                    startActivity(intent);
                }
                else if(position==5){
                    Intent intent = new Intent(getApplicationContext(), cse_3rd_2nd.class);
                    startActivity(intent);
                }





            }
        });




    }



}