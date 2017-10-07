package com.shakibcsekuet.mainbooklistproject;

/**
 * Created by md sakib on 9/28/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class HomeActivity extends AppCompatActivity {
    ///--------//////////////////////////////////--------////////////
    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;
    ///--------//////////////////////////////////--------////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ///--------//////////////////////////////////--------////////////

        loadData();


        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);

        listAdapter = new CustomAdapter(HomeActivity.this, deptList);

        simpleExpandableListView.setAdapter(listAdapter);


        expandAll();


        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                GroupInfo headerInfo = deptList.get(groupPosition);

                ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);

                Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
                        + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                if(headerInfo.getName()=="KUET" && detailInfo.getName()=="CSE"){
                    Intent intent = new Intent(getApplicationContext(), CSE.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="EEE"){
                    Intent intent = new Intent(getApplicationContext(), EEE.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="MECANICAL"){
                    Intent intent = new Intent(getApplicationContext(), MECA.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="CIVIL"){
                    Intent intent = new Intent(getApplicationContext(), CIVIL.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="BME"){
                    Intent intent = new Intent(getApplicationContext(), BME.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="ECE"){
                    Intent intent = new Intent(getApplicationContext(), ECE.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="IEM"){
                    Intent intent = new Intent(getApplicationContext(), IEM.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="BECM"){
                    Intent intent = new Intent(getApplicationContext(), BECM.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="TE"){
                    Intent intent = new Intent(getApplicationContext(), TE.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="ET"){
                    Intent intent = new Intent(getApplicationContext(), ET.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="LE"){
                    Intent intent = new Intent(getApplicationContext(), LE.class);
                    startActivity(intent);
                }
                else if(headerInfo.getName()=="KUET" && detailInfo.getName()=="URP"){
                    Intent intent = new Intent(getApplicationContext(), URP.class);
                    startActivity(intent);
                }







                return false;
            }
        });

        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                GroupInfo headerInfo = deptList.get(groupPosition);

                Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
                        Toast.LENGTH_LONG).show();

                return false;
            }
        });



        ///--------//////////////////////////////////--------////////////
    }
    ///--------//////////////////////////////////--------////////////

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.expandGroup(i);
        }
    }


    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.collapseGroup(i);
        }
    }


    private void loadData(){

        addProduct("KUET","CSE");
        addProduct("KUET","EEE");
        addProduct("KUET","MECANICAL");
        addProduct("KUET","CIVIL");
        addProduct("KUET","BME");
        addProduct("KUET","ECE");
        addProduct("KUET","IEM");
        addProduct("KUET","BECM");
        addProduct("KUET","TE");
        addProduct("KUET","ET");
        addProduct("KUET","LE");
        addProduct("KUET","URP");
    }
    private int addProduct(String department, String product){

        int groupPosition = 0;


        GroupInfo headerInfo = subjects.get(department);

        if(headerInfo == null){
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }


        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        int listSize = productList.size();
        listSize++;

        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);


        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }
    ///--------//////////////////////////////////--------////////////
}