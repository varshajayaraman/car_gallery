package com.example.varsh.projecttwo;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PictureZoom extends AppCompatActivity {

    ImageView griditemview;
    int imageId;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom_picture);

        griditemview = (ImageView) findViewById(R.id.griditemview);
        //   griditemview = new ImageView(getApplicationContext());
        imageId = (getIntent().getIntExtra("imageID", 0));
        Log.i("PictureZoom", "ImageID:" + imageId);
        griditemview.setImageResource(imageId);
        griditemview.setScaleType(ImageView.ScaleType.FIT_CENTER);           //Displaying a  bigger picture. Image View was created dynamically.
        //   setContentView(griditemview);


        griditemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //        String url = "https://www.facebook.com";

        //        Log.i("PictureZoom", "needid"+imageId);
                Toast.makeText(PictureZoom.this, "Opening website...",
                        Toast.LENGTH_SHORT).show();
                function2(MainActivity.hashMap.get(Integer.toString(imageId)));     //Intent call for browser activity

            }
        });

    }

    @Override
    protected void onDestroy() {                  //Cleaning RAM space

        System.gc();

        super.onDestroy();
    }

     public void function2(String url){                          //Opens a brwoser page with the specified URL
         Intent openWebsite = new Intent(Intent.ACTION_VIEW);
         openWebsite.setData(Uri.parse(url));
         startActivity(openWebsite);
         //finish();
     }


}
