package com.example.varsh.projecttwo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final static int clickedItemId = 0;

    static LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();  //Hashmap with R.drawable resources as keys and official website as values

    static String[] carNamesArray = {         //Array of Car names for Text view in grid items
            "ASTONMARTIN", "FERRARI",
            "JAGUAR", "LAMBHORGINI",
            "LANDROVER", "MASERATI",
            "PORSCHE", "SPIDER"
    };
    int[] mThumbIdsFlowers = new int[] {R.drawable.astonmartin, R.drawable.ferrari,
            R.drawable.jaguar, R.drawable.lambhorgini, R.drawable.landrover,
            R.drawable.maserati, R.drawable.porsche, R.drawable.spider};





    GridView gridview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hashMap.put(Integer.toString(R.drawable.astonmartin), "https://global.astonmartin.com/en-us/" );
        hashMap.put(Integer.toString(R.drawable.ferrari), "https://www.ferrari.com/en-US" );
        hashMap.put(Integer.toString(R.drawable.jaguar), "https://www.jaguarusa.com/index.html" );
        hashMap.put(Integer.toString(R.drawable.lambhorgini), "https://www.lamborghini.com/en-en" );
        hashMap.put(Integer.toString(R.drawable.landrover), "https://www.landroverusa.com/index.html" );
        hashMap.put(Integer.toString(R.drawable.maserati), "https://www.maseratiusa.com/maserati/us/en" );
        hashMap.put(Integer.toString(R.drawable.porsche), "https://www.porsche.com/usa/" );
        hashMap.put(Integer.toString(R.drawable.spider), "https://www.fiatusa.com/spider.html" );


        gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter imageAdapterObject = new ImageAdapter(this, hashMap, carNamesArray);
        gridview.setAdapter(imageAdapterObject);
        registerForContextMenu(gridview);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {     //Short Click Listener

                Log.i("MainActivity", "shortclick"+id);
                 function1((int)id);


            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {                       //Creating a context menu on long click
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

        Log.i("MainActivity", "Number of files present currently in Cache: "+this.fileList().length);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {                                                                   //Passes function call based on item chosen in the context menu

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = (int)info.id;
    //    Log.i("MainActivity", "insideonCreateContextMenu "+R.drawable.astonmartin+"  "+index);
        if(item.getItemId()==R.id.contextMenuItem1){function1(index);}
        else if(item.getItemId()==R.id.contextMenuItem2){function2(hashMap.get(Integer.toString(index)));}
        else {function3(index);}
        return true;
    }

    public void function1(int id){                                                          //Intent to display a bigger picture in new Activity
    //    Toast.makeText(this, "function 1 called", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, PictureZoom.class);
        intent.putExtra("imageID", (int)id);
        startActivity(intent);
        //finish();
    }
    public void function2(String url){                                                   //Intent to open the official website
    //    Log.i("MainActivity", "urlpassed"+url);
        Intent openWebsite = new Intent(Intent.ACTION_VIEW);
        openWebsite.setData(Uri.parse(url));
        startActivity(openWebsite);
 //       @Override

    }
    public void function3(int id){                                                        //Intent to open a list view containing 3 dealers for the selected car model
        if (id==R.drawable.astonmartin){ Log.i("MainActivity", "Yup"+id);}
    //    Log.i("MainActivity", "tolistview");
        Intent showList = new Intent(MainActivity.this, ListViewActivity.class);
        showList.putExtra("imageID", (int)id);
        startActivity(showList);
    }
}
