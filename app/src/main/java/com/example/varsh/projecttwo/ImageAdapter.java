package com.example.varsh.projecttwo;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private LinkedHashMap<String, String> hashMap;
    private String[] carNamesArray;

    public ImageAdapter(Context c,  LinkedHashMap<String, String>hashMap, String[] carNamesArray) {

        this.mContext = c;
        this.hashMap = hashMap;
        this.carNamesArray = carNamesArray;
    }

    public int getCount() {
        return hashMap.size();
    }

    public Object getItem(int position) {
        int i=-1;
        for(Map.Entry<String, String> entry: hashMap.entrySet()){
            i++;
            if(i==position){
                return Integer.parseInt(entry.getKey());
            }
        }
        return -1;
    }

    public long getItemId(int position) {
        int i=-1;
        for(Map.Entry<String, String> entry: hashMap.entrySet()){
            i++;
            if(i==position){
                return Long.parseLong(entry.getKey());
            }
        }
        return Long.parseLong("-1");
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        ImageView imageView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
//            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.grid_item_layout, null);

            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.android_gridview_text);
            imageView = (ImageView) gridViewAndroid.findViewById(R.id.android_gridview_image);
            textViewAndroid.setText(carNamesArray[position]);
 //           imageView = new ImageView(mContext);
 //           imageView.setLayoutParams(new ViewGroup.LayoutParams(500, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
 //           imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource((int)this.getItemId(position));

        } else {
            gridViewAndroid = (View) convertView;
        }


        return gridViewAndroid;

    }



}