package com.example.varsh.projecttwo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListViewActivity extends ListActivity {

//    HashMap <String, List<String>>carDealerHashMap;
    HashMap<String, String[]> carDealerHashMap = new HashMap<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("ListViewActivity", "Inside new class");
        // Create a new Adapter containing a list of colors
        // Set the adapter on this ListActivity's built-in ListView
        TextView textView = new TextView(this);
        int gridItemId = getIntent().getIntExtra("imageID", 0);
        Log.i("ListViewActivity", "vals " + gridItemId + " " + R.drawable.astonmartin);
        switch (gridItemId) {                                                                               //Displays list elements according to the item chosen from the grid
            case R.drawable.astonmartin:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.astonMartin)));
                textView.setText("DEALERS: ASTONMARTIN");
                break;

            case R.drawable.maserati:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.maserati)));
                textView.setText("DEALERS: MASERATI");
                break;

            case R.drawable.ferrari:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.ferrari)));
                textView.setText("DEALERS: FERRARI");
                break;

            case R.drawable.jaguar:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.jaguar)));
                textView.setText("DEALERS: JAGUAR");
                break;

            case R.drawable.lambhorgini:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.lambhorgini)));
                textView.setText("DEALERS: LAMBHORGINI");
                break;

            case R.drawable.landrover:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.landrover)));
                textView.setText("DEALERS: LANDROVER");
                break;

            case R.drawable.porsche:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.porsche)));
                textView.setText("DEALERS: PORSCHE");
                break;

            case R.drawable.spider:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.view_list,
                        getResources().getStringArray(R.array.spider)));
                textView.setText("DEALERS: SPIDER");
                break;
        }


        ListView lv = getListView();



        lv.addHeaderView(textView);
    }

    @Override
    protected void onDestroy() {

        System.gc();

        super.onDestroy();
    }
 }
